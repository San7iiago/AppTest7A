package com.example.productos.Base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.productos.utilidades.Utilidades;

public class connectionDB extends SQLiteOpenHelper {

    public connectionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        market.execSQL(Utilidades.CREAR_TABLA_PRODUCTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase market, int i, int i1) {
        market.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRODUCTOS);
        onCreate(market);
    }

    /*public List<fuente> select(){
        List<fuente> userList = new ArrayList<>();
        //Let DB read
        SQLiteDatabase market = this.getReadableDatabase();
        //Get data
        Cursor cursor = market.rawQuery("SELECT * from " + Utilidades.TABLA_USUARIO, null);
        //Store all users into a user list
        while (cursor.moveToNext()) {
            userList.add(new fuente(cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }

        cursor.close();
        return userList;
    }*/
}
