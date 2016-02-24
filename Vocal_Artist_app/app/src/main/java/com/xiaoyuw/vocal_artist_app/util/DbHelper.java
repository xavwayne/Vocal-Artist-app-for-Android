/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.util;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xiaoyuw.vocal_artist_app.model.Audience;

import java.util.HashMap;


/**
 * Helper class for operation of database
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="mailing_list.db";
    public static final String TABLE_NAME="mailing_list_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="EMAIL";
    ;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }

    /**
     * inset a entry in the database
     * @param aud the Audience instance
     * @return true when succeed, false otherwise
     */
    public boolean insertData(Audience aud){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COL_2,aud.getName());
        cv.put(COL_3,aud.getEmail());



        long result = db.insert(TABLE_NAME,null,cv);
        if(result==-1)
            return false;
        else
            return  true;
    }

    /**
     * get all information of the database
     * @return Cursor object as result
     */
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    /**
     *  delete all data from the table
     */
    public void delTab(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("drop table if exists " + TABLE_NAME);
        db.execSQL("create table " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT)");

//        db.execSQL("drop table if exists " + TABLE_NAME);
//        db.execSQL("delete from "+TABLE_NAME);
    }





}
