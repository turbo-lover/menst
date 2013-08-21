package com.menst_verstka.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexander on 21.08.13.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME1 = "cycle";
    public static final String TABLE_NAME2 = "params";
    public static final String CYCLE_START = "start";
    public static final String CYCLE_END = "end";
    public static final String DATE = "date";
    public static final String PARAMS = "params";

    private static final String DB_NAME = "menstruation";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE1 = "CREATE TABLE "+TABLE_NAME1+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CYCLE_START+" TEXT NOT NULL, "+CYCLE_END+" TEXT NOT NULL);";
    private static final String CREATE_TABLE2 = "CREATE TABLE "+TABLE_NAME2+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            DATE+" TEXT NOT NULL, "+PARAMS+" TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE1);
        sqLiteDatabase.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
