package com.menst_verstka.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * Created by Alexander on 21.08.13.
 * All necessary method are presented here;
 */
public class DBHelper extends SQLiteOpenHelper {
    /* * * * * * * * * * * *  Tables * * * * * * * * * * * */
    private static final String TABLE_PARAMS = "params";
    /* * * *  * * * * * * * *  Columns of TABLE_PARAMS * * * * * * * * * * * */
    //DATE FORMAT yyyy-MM-dd
    private static final String DATE = "date";
    private static final String PARAMS = "params";
    /* * * * * * * * * * * *  FIELDS OF JSON OBJ * * * * * * * * * * * */
    private static final String DB_NAME = "menstruation";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_PARAMS +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +DATE+" TEXT NOT NULL UNIQUE, "+PARAMS+" TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    /**
     *
     * @param date
     * @return com.google.gson.JsonObject that contain all information about
     * this date;
     */
    public JsonObject getRawJsonByDate (String date){
        SQLiteDatabase db = null;
        Cursor cursor  = null;
        try {
            //try to get readableDatabase;
            db = getReadableDatabase();
            if (db != null) {
                // select $PARAMS from table $TABLE_PARAMS where $DATE == $date
                cursor = db.query(TABLE_PARAMS, new String[]{PARAMS}, DATE + "=?", new String[]{date}, null, null, null);
            }
            String str = null;
            if(cursor.getCount() != 0 ) {
                cursor.moveToFirst();
                str = cursor.getString(cursor.getColumnIndex(PARAMS));
                return new JsonParser().parse(str).getAsJsonObject();
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if(db !=null)
            db.close();
        }
        return null;
    }

    public void SetJsonByDate(String date,JsonObject object) {
        SQLiteDatabase db = null;
        try {
            db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(PARAMS,object.toString());
            cv.put(DATE,date);
            db.insertWithOnConflict(TABLE_PARAMS,null,cv,SQLiteDatabase.CONFLICT_REPLACE);
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if(db !=null)
                db.close();
        }
    }

}




