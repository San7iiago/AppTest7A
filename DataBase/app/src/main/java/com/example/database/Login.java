package com.example.database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.Base.connectionDB;
import com.example.database.utilidades.Utilidades;

public class Login extends AppCompatActivity {
    /*private static final Pas =
            Pattern.compile("^"+
            "(?=.*[0-9])"+
            "(?=.*[a-z])"+
            "(?=.*[A-Z])"+
            "(?=.*[@#$%^&+=])+" +
            "(?=\\S+$)"+
            ".{6,}"+
            "$");*/

    connectionDB conn;
    EditText semail, spassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        semail= findViewById(R.id.semail);
        spassword = findViewById(R.id.spassword);
    }

    public void Register(View v) {
        startActivity(new Intent(Login.this, SingUp.class));
    }

    private boolean validateEmail() {
        String emailInput = semail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            semail.setError("Debe escribir un correo");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            semail.setError("El correo no es valido");
            return false;
        } else {
            semail.setError(null);
            return true;
        }
    }

    public void LogInS (View view){
        conn=new connectionDB(this,"bd_users",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();
        String[] parametros = {semail.getText().toString()};

        try {
            if (!validateEmail()) {
                return;
            }
            Cursor cursor=market.rawQuery("SELECT "+Utilidades.CAMPO_EMAIL+
                    " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_EMAIL+"=? ",parametros);
            if (cursor.getCount()>0){
                String[] parametros2 = {spassword.getText().toString()};

                try {
                    Cursor cursor2=market.rawQuery("SELECT "+Utilidades.CAMPO_CONTRASENA+
                            " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_CONTRASENA+"=? ",parametros2);
                    if (cursor2.getCount()>0){

                        iniciar();
                    } else {
                        Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){

                }
            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e){

        }
    }

    private void iniciar() {
        startActivity(new Intent(Login.this, MainActivity.class));
    }

}
