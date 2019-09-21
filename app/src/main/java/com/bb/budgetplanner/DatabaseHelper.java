package com.bb.budgetplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Budgetplanner.db";
    public static final String TABLE_NAME = "budget";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATE";
    public static final String COL_3 = "AMOUNT";
    public static final String COL_4 = "PURPOSE";
    public static final String COL_5 = "PAYMENT_METHOD";
    public static final String COL_6 = "COMMENTS";
    public static final String COL_7 = "BILL_DETAILS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DATE TEXT,AMOUNT TEXT,PURPOSE TEXT,PAYMENT_METHOD TEXT,COMMENTS TEXT,BILL_DETAILS TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String date, String amount, String purpose, String payment, String comments, String bill){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_2,date);
        contentvalues.put(COL_3,amount);
        contentvalues.put(COL_4,purpose);
        contentvalues.put(COL_5,payment);
        contentvalues.put(COL_6,comments);
        contentvalues.put(COL_7,bill);
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
}
