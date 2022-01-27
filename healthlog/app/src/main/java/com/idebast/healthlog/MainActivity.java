package com.idebast.healthlog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.idebast.healthlog.fragments.HistoryFragment;
import com.idebast.healthlog.model.DbHelperSingleton;
import com.idebast.healthlog.model.LogEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController mNavController;
    private DatabaseHelper dbHandler;
    public ArrayList<LogEntry> logEntries = new ArrayList<>();

    private void clearInputArea() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedString = now.format(formatter);
        TextView tDatum = findViewById(R.id.tv_Datum);
        tDatum.setText(formattedString);

        TextView tTime = findViewById(R.id.tv_Time);
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        formattedString = now.format(formatter);
        tTime.setText(formattedString);

        EditText et_gewicht = ((EditText) findViewById(R.id.et_Gewicht));
        EditText et_bovendruk = ((EditText) findViewById(R.id.et_Bovendruk));
        EditText et_onderdruk = ((EditText) findViewById(R.id.et_Onderdruk));
        EditText et_pols = ((EditText) findViewById(R.id.et_Pols));
        EditText et_opmerking = ((EditText) findViewById(R.id.et_Opmerking));

        et_gewicht.getText().clear();
        et_bovendruk.getText().clear();
        et_onderdruk.getText().clear();
        et_pols.getText().clear();
        et_opmerking.getText().clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mNavController = Navigation.findNavController(this, R.id.navhost);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.historyFragment).build();
        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DatabaseHelper(MainActivity.this);

        DbHelperSingleton dbHelperSingleton = DbHelperSingleton.getINSTANCE();
        dbHelperSingleton.setDbHelper(dbHandler);

        // read all entries ofthe database
        dbHelperSingleton.getDbHelper().readLogEntries(logEntries);


        FloatingActionButton myFab = (FloatingActionButton) this.findViewById(R.id.fab_AddEntry);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View rootview = findViewById(android.R.id.content).getRootView();

                String datum = ((TextView) rootview.findViewById(R.id.tv_Datum)).getText().toString();
                String time = ((TextView) rootview.findViewById(R.id.tv_Time)).getText().toString();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(String.format("%s %s", datum, time), formatter);

                // XXX.parseXXX() kan niet werken met "" string
                String s;
                s = (((EditText) rootview.findViewById(R.id.et_Gewicht)).getText()).toString();
                float gewicht =  (s.isEmpty()) ? 0.0f : Float.parseFloat(s);

                s = (((EditText) rootview.findViewById(R.id.et_Bovendruk)).getText()).toString();
                int bovenDruk =  (s.isEmpty()) ? 0 : Integer.parseInt(s);

                s = (((EditText) rootview.findViewById(R.id.et_Onderdruk)).getText()).toString();
                int onderDruk =  (s.isEmpty()) ? 0 : Integer.parseInt(s);

                s = (((EditText) rootview.findViewById(R.id.et_Pols)).getText()).toString();
                int pols =  (s.isEmpty()) ? 0 : Integer.parseInt(s);

                String opmerking = (((EditText) rootview.findViewById(R.id.et_Opmerking)).getText()).toString();

                LogEntry newEntry = new LogEntry(localDateTime, gewicht, bovenDruk, onderDruk, pols, opmerking);

                // herlees database
                if ((gewicht != 0 ) || (bovenDruk !=0 ) || (onderDruk != 0) || (pols !=0) || !opmerking.isEmpty()) {
                    // alleen maar als niet alle velden leeg zijn
                    DatabaseHelper dbh = DbHelperSingleton.getINSTANCE().getDbHelper();
                    // schrijf naar database
                    dbh.addLogEntry(newEntry);
                    // en lees opnieuw
                    dbh.readLogEntries(logEntries);
                }

                // https://stackoverflow.com/questions/59965336/calling-method-on-navigation-host-fragment-inside-mainactivity
                // https://stackoverflow.com/questions/51385067/android-navigation-architecture-component-get-current-visible-fragment/51732378#51732378
                NavHostFragment f1 = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navhost);
                HistoryFragment frag1 = (HistoryFragment) f1.getChildFragmentManager().getFragments().get(0);
                frag1.updateUi();

                Toast.makeText(MainActivity.this, "Data submitted",
                        Toast.LENGTH_SHORT).show();
                clearInputArea();
            }
        });

        // wis input scherm
        clearInputArea();
    }

//    // https://stackoverflow.com/questions/15027454/how-to-get-onclick-in-datepickerdialog-ondatesetlistener
//    EditText e = findViewById(R.id.et_Date);
//
//    e.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View arg0) {
//            DateDialogFragment datepicker=new DateDialogFragment();
//            datepicker.show(getSupportFragmentManager(), "showDate");
//        }
//    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mi_Chart:
                Intent intent = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(intent);
                return true;
            case R.id.mi_populate:
                populateDb();

                // HACK: https://stackoverflow.com/questions/51385067/android-navigation-architecture-component-get-current-visible-fragment/51732378#51732378
                NavHostFragment f1 = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navhost);
                HistoryFragment frag1 = (HistoryFragment) f1.getChildFragmentManager().getFragments().get(0);
                frag1.updateUi();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void populateDb() {
        // fill database with some data
        DatabaseHelper dbh = DbHelperSingleton.getINSTANCE().getDbHelper();

        dbh.addLogEntry(new LogEntry("2021-10-25","22:00",0.0f,123,77,68,""));
        dbh.addLogEntry(new LogEntry("2021-10-25","22:00",0.0f,123,79,70,""));
        dbh.addLogEntry(new LogEntry("2021-10-25","22:00",0.0f,119,77,70,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","08:00",87.7f,132,86,77,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","08:00",0.0f,126,82,79,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","08:00",0.0f,129,83,79,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","16:00",0.0f,145,85,62,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","16:00",0.0f,133,82,60,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","16:00",0.0f,141,82,63,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","18:00",0.0f,140,89,68,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","18:00",0.0f,130,81,66,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","18:00",0.0f,128,81,65,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","22:30",0.0f,141,88,65,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","22:30",0.0f,133,87,62,""));
        dbh.addLogEntry(new LogEntry("2021-10-26","22:30",0.0f,135,87,65,""));
        dbh.addLogEntry(new LogEntry("2021-10-27","09:30",87.3f,137,90,83,""));
        dbh.addLogEntry(new LogEntry("2021-10-27","09:30",0.0f,130,86,85,""));
        dbh.addLogEntry(new LogEntry("2021-10-27","09:30",0.0f,126,84,85,""));
        dbh.addLogEntry(new LogEntry("2021-10-27","19:30",0.0f,133,89,73,""));
        dbh.addLogEntry(new LogEntry("2021-10-27","19:30",0.0f,125,85,75,""));
        dbh.addLogEntry(new LogEntry("2021-10-27","19:30",0.0f,121,85,75,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","09:30",86.5f,127,87,78,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","09:30",0.0f,123,81,77,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","09:30",0.0f,126,82,76,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","15:30",0.0f,124,81,72,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","15:30",0.0f,117,80,70,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","15:30",0.0f,119,81,76,"Opmerking 1"));
        dbh.addLogEntry(new LogEntry("2021-10-28","22:00",0.0f,138,90,70,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","22:00",0.0f,130,87,67,""));
        dbh.addLogEntry(new LogEntry("2021-10-28","22:00",0.0f,129,85,66,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","16:00",86.1f,115,78,66,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","16:00",0.0f,112,77,65,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","16:00",0.0f,109,74,64,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","16:00",0.0f,115,80,68,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","19:30",0.0f,118,81,71,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","19:30",0.0f,126,80,71,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","19:30",0.0f,114,79,74,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","22:00",0.0f,123,81,75,"Opmerking 2"));
        dbh.addLogEntry(new LogEntry("2021-10-29","22:00",0.0f,118,81,72,""));
        dbh.addLogEntry(new LogEntry("2021-10-29","22:00",0.0f,115,79,76,""));
        dbh.addLogEntry(new LogEntry("2021-10-30","22:00",0.0f,139,89,71,""));
        dbh.addLogEntry(new LogEntry("2021-10-30","22:00",0.0f,124,71,71,""));
        dbh.addLogEntry(new LogEntry("2021-10-30","22:00",0.0f,116,83,75,""));
        dbh.addLogEntry(new LogEntry("2021-10-31","15:00",85.4f,115,84,70,""));
        dbh.addLogEntry(new LogEntry("2021-10-31","15:00",0.0f,116,82,69,""));
        dbh.addLogEntry(new LogEntry("2021-10-31","15:00",0.0f,116,80,71,""));
        dbh.addLogEntry(new LogEntry("2021-10-31","21:00",0.0f,116,84,71,""));
        dbh.addLogEntry(new LogEntry("2021-10-31","21:00",0.0f,119,85,73,""));
        dbh.addLogEntry(new LogEntry("2021-10-31","21:00",0.0f,118,90,78,""));
        dbh.addLogEntry(new LogEntry("2021-11-01","15:00",85.3f,107,77,73,""));

        dbh.readLogEntries(logEntries);

        Toast.makeText(MainActivity.this, "Database initialized",
        Toast.LENGTH_SHORT).show();
        };

public void onClicktextDatum(View view) {
        TextView tv_Datum = view.findViewById(R.id.tv_Datum);

        DatePickerDialog.OnDateSetListener dateListener;

        LocalDateTime now = LocalDateTime.now();
        int nowYear = now.getYear();
        int nowMonth = now.getMonthValue(); // 1-12
        int nowDay = now.getDayOfMonth();

        String formattedDate = String.format("%04d-%02d-%02d", nowYear, (nowMonth), nowDay);
        tv_Datum.setText(formattedDate);

        // https://androidchennai.blogspot.com/2012/05/simple-calendar-control-android.html
        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                String formattedDate = String.format("%04d-%02d-%02d", year, (monthOfYear+1), dayOfMonth);
                tv_Datum.setText(formattedDate);
            }
       };

        DatePickerDialog datePicker = new DatePickerDialog(this, dateListener, nowYear, nowMonth-1, nowDay);
        datePicker.show();
    }

    public void onClicktextTime(View view) {
        TextView tv_Time = view.findViewById(R.id.tv_Time);

        TimePickerDialog.OnTimeSetListener timeListener;

        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minutes = now.getMinute();
        int seconds = now.getSecond();

        String formattedTime = String.format("%02d:%02d:%02d" , hour, minutes, seconds);
        tv_Time.setText(formattedTime);

        // inspired on https://androidchennai.blogspot.com/2012/05/simple-calendar-control-android.html
        timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minutes) {
                String formattedTime = String.format("%02d:%02d:%02d" , hour, minutes, seconds);
                tv_Time.setText(formattedTime);
            }
        };

        TimePickerDialog timePicker = new TimePickerDialog(this, timeListener, hour, minutes, true);
        timePicker.show();

    }

    public void onClickfab_AddEntry(View view) {
        LogEntry newEntry;

        String dateString = ((TextView) view.findViewById(R.id.tv_Datum)).getText().toString();
        String timeString = ((TextView) view.findViewById(R.id.tv_Time)).getText().toString();
        float gewicht =  Float.parseFloat( ((EditText) view.findViewById(R.id.et_Gewicht)).getText().toString());
        int bovenDruk =  Integer.parseInt( ((EditText) view.findViewById(R.id.et_Bovendruk)).getText().toString());
        int onderDruk =  Integer.parseInt( ((EditText) view.findViewById(R.id.et_Onderdruk)).getText().toString());
        int pols = Integer.parseInt( ((EditText) view.findViewById(R.id.et_Pols)).getText().toString());

        newEntry = new LogEntry(dateString, timeString, gewicht, bovenDruk, onderDruk, pols, "");

        dbHandler.addLogEntry(newEntry);

        HistoryFragment fragment = (HistoryFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout2);
        fragment.updateUi();
    }
}