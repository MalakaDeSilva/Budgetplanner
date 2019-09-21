package com.bb.budgetplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Budgetplanner.db";
    public static final String TABLE_NAME = "spend";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MONTHLY_LIMIT";
    public static final String COL_3 = "TRAVEL";
    public static final String COL_4 = "FOOD";
    public static final String COL_5 = "SHOPPING";
    public static final String COL_6 = "RENT";
    public static final String COL_7 = "TELEPHONE_BILL";
    public static final String COL_8 = "OTHERS";
    public static final String COL_9 = "TOTAL";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "MONTHLY_LIMIT INTEGER,TRAVEL INTEGER,FOOD INTEGER,SHOPPING INTEGER,RENT INTEGER,TELEPHONE_BILL INTEGER,OTHERS INTEGER,TOTAL INTEGER)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String monthly, String travel, String food, String shopping, String rent, String bill, String others, String total){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_2,monthly);
        contentvalues.put(COL_3,travel);
        contentvalues.put(COL_4,food);
        contentvalues.put(COL_5,shopping);
        contentvalues.put(COL_6,rent);
        contentvalues.put(COL_7,bill);
        contentvalues.put(COL_8,others);
        contentvalues.put(COL_9,total);
        long result = db.insert(TABLE_NAME,null,contentvalues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }

    public Integer deleteData (Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID =?",new String[]{id.toString()});
    }
}
