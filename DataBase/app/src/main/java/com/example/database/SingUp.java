package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.Base.connectionDB;

public class SingUp extends AppCompatActivity {

    private EditText fname;
    private EditText lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
    }

    public void SignUp (View view){

        SQLiteOpenHelper admin = new connectionDB(this,
                "administracion", null, 1);

        SQLiteDatabase market = admin.getWritableDatabase();

        //Traer datos
        String nombre = fname.getText().toString();
        String apellido = lname.getText().toString();

        //Llenar datos en BD
        ContentValues pack = new ContentValues();
        pack.put("firstname", nombre);
        pack.put("lastname", apellido);
        pack.put("email", "");
        pack.put("password", "");

        //insertar datos
        market.insert("users", null, pack);

        Toast.makeText(this, "The user has been registered", Toast.LENGTH_SHORT);

        /* homework
        que nno se repita el email, de lo contrario el sistema debe mostrar el error en un toast y redireccionar al login
        //Completar datos
         */
    }
}
