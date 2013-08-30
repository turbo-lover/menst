package com.menst_verstka.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexander on 21.08.13.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "params";
    public static final String DATE = "date";
    public static final String PARAMS = "params";

    private static final String DB_NAME = "menstruation";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            DATE+" TEXT NOT NULL, "+PARAMS+" TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) { }
}
