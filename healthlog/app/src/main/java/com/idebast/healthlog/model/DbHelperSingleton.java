package com.idebast.healthlog.model;

import com.idebast.healthlog.DatabaseHelper;

import java.util.ArrayList;

// https://www.developer.com/guides/global-variables-in-java-with-the-singleton-pattern/
// https://dzone.com/articles/java-singletons-using-enum
public class DbHelperSingleton {
    //een static instance van de klasse
    private static DbHelperSingleton INSTANCE = null;
    //singleton pattern
    //constructor afschermen
    private DbHelperSingleton(){ };

    public static DbHelperSingleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DbHelperSingleton();
        }
        return INSTANCE;
    }

    // de echte data
    private static DatabaseHelper mDbHandler;

    public static DatabaseHelper getDbHelper(){
        return mDbHandler;
    }
    public void setDbHelper(DatabaseHelper dbHelper) {
        mDbHandler = dbHelper;
    }

}
