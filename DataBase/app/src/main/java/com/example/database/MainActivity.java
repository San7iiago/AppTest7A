package com.example.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.database.Base.connectionDB;
import com.example.database.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    List<String> item = null;
    connectionDB conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        listarUsuarios();
    }

    private void listarUsuarios(){
        conn=new connectionDB(this,"bd_users",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();

        Cursor c = getUsers();
        item = new ArrayList<String>();
        String usu = "";

        if (c.moveToFirst()){
            do{
                usu = c.getString(0);
                item.add(usu);
            }while(c.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        lista.setAdapter(adaptador);
    }

    public Cursor getUsers(){
        conn=new connectionDB(this,"bd_users",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();
        String[] columnas= {Utilidades.CAMPO_EMAIL};

        Cursor cursor=market.rawQuery("SELECT "+Utilidades.CAMPO_EMAIL+
                " FROM "+Utilidades.TABLA_USUARIO, null);
        return cursor;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iteFemale:
                return true;
            case R.id.iteMale:
                return true;
            case R.id.iteAllUsers:
                return true;
            case R.id.iteAbout:
                return true;
            case R.id.iteLogout:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
