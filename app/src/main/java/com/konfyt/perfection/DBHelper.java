package com.konfyt.perfection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Konfyt on 2016/7/29.
 */
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "cat", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table goods (_id integer primary key autoincrement," +
                "pic varchar(100),name varchar(100),price varchar(100),num integer,goodid integer,tiaozhuanid integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
