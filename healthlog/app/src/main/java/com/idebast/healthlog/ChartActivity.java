package com.idebast.healthlog;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.idebast.healthlog.fragments.BloeddrukFragment;
import com.idebast.healthlog.fragments.GewichtFragment;
import com.idebast.healthlog.fragments.HealthDataSet;
import com.idebast.healthlog.fragments.HealthDataSetEntry;
import com.idebast.healthlog.fragments.PolsFragment;
import com.idebast.healthlog.fragments.util.LogEntryComparatorByDateTime;
import com.idebast.healthlog.fragments.util.LogStatFilter;
import com.idebast.healthlog.model.DbHelperSingleton;
import com.idebast.healthlog.model.LogEntry;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=-vAI7RSPxOA

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        // forceer in landscape orientation
        // https://stackoverflow.com/questions/2067426/android-force-horizontal-landscape-layout
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // remove app title bar, https://stackoverflow.com/questions/14475109/remove-android-app-title-bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        DatabaseHelper dbh = DbHelperSingleton.getINSTANCE().getDbHelper();
        ArrayList<LogEntry> logData = new ArrayList<>();
        dbh.readLogEntries(logData);
        logData.sort(new LogEntryComparatorByDateTime());
        LogStatFilter filter = new LogStatFilter(logData);
        ArrayList<HealthDataSetEntry> graphData = new ArrayList<HealthDataSetEntry>();

        int cursor = 0;
        while (filter.hasNext()) {
            cursor = filter.process(cursor); // en update cursor naar nieuwe index

            graphData.add(filter.result());
        }

        HealthDataSet.data = graphData;

        // https://developer.android.com/guide/fragments/fragmentmanager
        // set initial fragment in fragment container
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, BloeddrukFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();
    }

    // https://stackoverflow.com/questions/10231309/android-button-onclick
    public void onClickBtnBloeddruk(View view) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, BloeddrukFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();
    }

    public void onClickBtnPols(View view) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, PolsFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();
    }

    public void onClickBtnGewicht(View view) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, GewichtFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        //super.onBackPressed();
    }
}