package com.example.dllo.baidumusic.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dllo on 16/11/1.
 */

public class DB_Helper extends SQLiteOpenHelper {
    public DB_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DBValues.TABLE_NAME+"("+"id integer primary key autoincrement,"
                +DBValues.MUSICNAME+" text,"
                +DBValues.SINGER+" text,"
                +DBValues.SONGURL+" text,"
                +DBValues.LRCURL+" text,"
                +DBValues.MUSICID+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
