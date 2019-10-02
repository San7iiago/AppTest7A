package com.example.database.Base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class connectionDB extends SQLiteOpenHelper {
    public connectionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        market.execSQL("create table users(id int primary key autoincrement, " +
                "firstname text not null, lastname text not null, email text not null, password text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
