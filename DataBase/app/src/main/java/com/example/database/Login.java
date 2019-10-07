package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.Base.connectionDB;
import com.example.database.utilidades.Utilidades;

public class Login extends AppCompatActivity {

    connectionDB conn;
    EditText semail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        semail= findViewById(R.id.semail);
    }

    public void Register(View v) {
        startActivity(new Intent(Login.this, SingUp.class));
    }

    public void LogInS (View view){
        connectionDB conn=new connectionDB(this,"bd_users",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();
        String[] parametros={semail.getText().toString()};

        try{

            //select email, nombre from usuario where codigo=?
            Cursor cursor=market.rawQuery("SELECT "+Utilidades.CAMPO_EMAIL+
                    " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_EMAIL+"=? ",parametros);
            cursor.moveToFirst();
            startActivity(new Intent(Login.this, DetalleUsuarioActivity.class));

            cursor.close();


        }catch (Exception e) {
            Toast.makeText(this, "Correo o contraseña Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

}
