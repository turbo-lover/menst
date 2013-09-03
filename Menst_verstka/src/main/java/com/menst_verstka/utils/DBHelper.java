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
    private static final String TABLE_CYCLE = "cycle";
    private static final String TABLE_PARAMS = "params";
    /* * * *  * * * * * * * *  Columns of TABLE_CYCLE * * * * * * * * * * * */
    //DATE FORMAT yyyy-MM-dd
    private static final String CYCLE_START = "start";
    private static final String CYCLE_END = "end";
    /* * * *  * * * * * * * *  Columns of TABLE_PARAMS * * * * * * * * * * * */
    private static final String DATE = "date";
    private static final String PARAMS = "params";
    /* * * * * * * * * * * *  FIELDS OF JSON OBJ * * * * * * * * * * * */


    private static final String DB_NAME = "menstruation";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE1 = "CREATE TABLE "+TABLE_CYCLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CYCLE_START+" TEXT NOT NULL, "+CYCLE_END+" TEXT NOT NULL);";
    private static final String CREATE_TABLE2 = "CREATE TABLE "+ TABLE_PARAMS +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +DATE+" TEXT NOT NULL, "+PARAMS+" TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE1);
        sqLiteDatabase.execSQL(CREATE_TABLE2);
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
            int columnIndex = cursor.getColumnIndex(PARAMS);
            String str = null;
            if(cursor.getCount() != 0 ) {
                cursor.moveToFirst();
                str = cursor.getString(columnIndex);
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
        Cursor cursor  = null;
        try {
            db = getWritableDatabase();
            cursor = db.query(TABLE_PARAMS,new String[]{PARAMS},DATE + "=?",new String[]{date},null,null,null);
            ContentValues cv = new ContentValues();
            cv.put(PARAMS,object.toString());
            if(cursor != null) {
                db.update(TABLE_PARAMS,cv,DATE + "=?",new String[]{date});
            } else {
                cv.put(DATE,date);
                db.insert(TABLE_PARAMS,null,cv);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if(db !=null)
                db.close();
        }
    }

}




