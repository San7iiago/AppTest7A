package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para pasar a otra ventana
    public void Login(View V){

        String user = "santiago";
        String pass = "hola";

        String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
        String contrasena = ((EditText) findViewById(R.id.contrasena)).getText().toString();

        if (user == usuario) {
            if (pass == contrasena) {
                Intent login;
                login = new Intent(this, Menu.class);
                startActivity(login);
            } else {
                Toast.makeText(getApplicationContext(), "Acceso Incorrecto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Acceso Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    public void Registro(View V){
        Intent registro;
        registro = new Intent(this, Registro.class);
        startActivity(registro);
    }

}
