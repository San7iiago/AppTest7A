package com.example.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productos.Base.connectionDB;
import com.example.productos.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    private EditText lnombre;
    private EditText lcategoria;
    private EditText lcantidad;
    connectionDB conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lnombre = findViewById(R.id.idProducto);
        lcategoria = findViewById(R.id.idCategoria);
        lcantidad = findViewById(R.id.idCantidad);
    }

    public void SignUp (View view){
        conn=new connectionDB(this,"market",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();

        String nombre = lnombre.getText().toString();
        String categoria = lcategoria.getText().toString();
        String cantidad = lcategoria.getText().toString();

        if (nombre.length() == 0){
            lnombre.setError("Debe escribir un nombre");
        } else if (categoria.length() == 0){
            lcategoria.setError("Debe escribir un categoria");
        } else if (cantidad.length() == 0){
            lcantidad.setError("Debe escribir una cantidad");
        } else if (nombre.length() != 0 && categoria.length() != 0 && cantidad.length() != 0) {
            registrarProductos();
        }
    }

    private void registrarProductos() {
        conn=new connectionDB(this,"market",null,1);

        SQLiteDatabase market=conn.getWritableDatabase();

        //Traer datos
        String nombre = lnombre.getText().toString();
        String categoria = lcategoria.getText().toString();
        int cantidad = Integer.parseInt(lcantidad.getText().toString());

        //Llenar datos en BD
        ContentValues pack=new ContentValues();
        pack.put(Utilidades.CAMPO_NOMBRE, nombre);
        pack.put(Utilidades.CAMPO_CATEGORIA, categoria);
        pack.put(Utilidades.CAMPO_CANTIDAD, cantidad);

        //insertar datos
        long insert = market.insert(Utilidades.CREAR_TABLA_PRODUCTOS, Utilidades.CAMPO_ID, pack);

        Toast.makeText(this, "The product has been registered", Toast.LENGTH_SHORT).show();
        market.close();
    }
}
