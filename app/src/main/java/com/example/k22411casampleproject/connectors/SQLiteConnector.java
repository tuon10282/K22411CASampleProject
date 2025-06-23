package com.example.k22411casampleproject.connectors;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteConnector {
    String DATABASE_NAME="SalesDatabase.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    Activity context;

    public SQLiteConnector() {
    }
    public SQLiteConnector(Activity context)
    {
        this.context=context;
    }

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }
    public SQLiteDatabase openDatabase()
    {
        database =this.context.openOrCreateDatabase(DATABASE_NAME,
                this.context.MODE_PRIVATE, null);
        return database;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }
}
