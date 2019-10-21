package com.example.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.Base.connectionDB;
import com.example.database.utilidades.Utilidades;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUser;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    connectionDB conn;

    List<fuente> usuario;

    /*public List<fuente> obtenerUsuarios(){
        connectionDB conn = new connectionDB(this, "market", null, 1);
        SQLiteDatabase market=conn.getReadableDatabase();
        Cursor cursor = market.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_APELLIDO+","+Utilidades.CAMPO_EMAIL
                +" FROM "+ Utilidades.TABLA_USUARIO, null);

        while (cursor.moveToNext()) {
            usuario.add(new fuente(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }

        cursor.close();

        return usuario;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*recyclerViewUser = findViewById(R.id.RecyclerUsuario);

        recyclerViewUser.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(lManager);

        //usuario = conn.select();

        adapter = new listaAdaptador(usuario);
        recyclerViewUser.setAdapter(adapter);*/
    }

    /*@Override
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
    }*/
}
