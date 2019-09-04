package com.example.aplicacionandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    private EditText a, b, c, d, e;
    private TextView a1, b1, c1, d1, e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        a = findViewById(R.id.idnombre);
        b = findViewById(R.id.idapellido);
        c = findViewById(R.id.idcorreo);
        d = findViewById(R.id.idtelefono);
        e = findViewById(R.id.idcontrasena);

        a1 = findViewById(R.id.idnombre2);
        b1 = findViewById(R.id.idapellido2);
        c1 = findViewById(R.id.idcorreo2);
        d1 = findViewById(R.id.idtelefono2);
        e1 = findViewById(R.id.idcontrasena2);
    }

    public void enviar(View view){
        String name = a.getText().toString();
        a1.setText(name);
        String lastname = b.getText().toString();
        b1.setText(lastname);
        String email = c.getText().toString();
        c1.setText(email);
        String phone = d.getText().toString();
        d1.setText(phone);
        String pwd = e.getText().toString();
        e1.setText(pwd);
    }
}
