package com.idebast.healthlog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.idebast.healthlog.model.LogEntry;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "healthlogdb";
    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Log_table";
    private static final String ID_COL = "id";
    private static final String DATE_COL = "Date";
    private static final String TIME_COL = "Time";
    private static final String TIMESTAMP_COL ="Timestamp";
    private static final String GEWICHT_COL = "Gewicht";
    private static final String BOVENDRUK_COL = "Bovendruk";
    private static final String ONDERDRUK_COL = "Onderdruk";
    private static final String POLS_COL = "Pols";
    private static final String COMMENT_COL = "Opmerking";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DATE_COL + " TEXT,"
                + TIME_COL + " TEXT,"
                + TIMESTAMP_COL + " INTEGER,"
                + GEWICHT_COL + " REAL,"
                + BOVENDRUK_COL + " INTEGER,"
                + ONDERDRUK_COL + " INTEGER,"
                + POLS_COL +" INTEGER,"
                + COMMENT_COL + " TEXT )";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public long addLogEntry(LogEntry logEntry) {
        long newRowId;
                // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DATE_COL, logEntry.getDatum());
        values.put(TIME_COL, logEntry.getTime());
        values.put(TIMESTAMP_COL, logEntry.getTimestamp().toEpochSecond(ZoneOffset.UTC));
        values.put(GEWICHT_COL, logEntry.getGewicht());
        values.put(BOVENDRUK_COL, logEntry.getBovendruk());
        values.put(ONDERDRUK_COL, logEntry.getOnderdruk());
        values.put(POLS_COL, logEntry.getPols());
        values.put(COMMENT_COL, logEntry.getComment());
        // after adding all values we are passing
        // content values to our table.
        newRowId = db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
        return newRowId;
    }

    public ArrayList<LogEntry> readLogEntries() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<LogEntry> logEntries = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {

                logEntries.add(new LogEntry(
                        LocalDateTime.ofEpochSecond(cursor.getLong(cursor.getColumnIndexOrThrow(TIMESTAMP_COL)), 0, ZoneOffset.UTC),
//                        cursor.getString(cursor.getColumnIndexOrThrow(TIME_COL)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(GEWICHT_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BOVENDRUK_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(ONDERDRUK_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(POLS_COL)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COMMENT_COL))));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();

        db.close();
        return logEntries;
    }

    // zelfde als boven, maar gebruik zelfde object reference
    public ArrayList<LogEntry> readLogEntries(ArrayList<LogEntry> logEntries) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        // maak de lijst leeg
        logEntries.clear();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {

                logEntries.add(new LogEntry(
                        LocalDateTime.ofEpochSecond(cursor.getLong(cursor.getColumnIndexOrThrow(TIMESTAMP_COL)), 0, ZoneOffset.UTC),
//                        cursor.getString(cursor.getColumnIndexOrThrow(TIME_COL)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(GEWICHT_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BOVENDRUK_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(ONDERDRUK_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(POLS_COL)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COMMENT_COL))));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();

        db.close();
        return logEntries;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void dropDatabase(Context context) {
        context.deleteDatabase(DB_NAME);
    }
}
