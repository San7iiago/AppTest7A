package com.example.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
//import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.Base.connectionDB;
import com.example.database.utilidades.Utilidades;

public class SingUp extends AppCompatActivity {

    connectionDB conn;
    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText password;
    private EditText rpassword;
    //private Spinner sGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        rpassword = findViewById(R.id.rpassword);
        //Spinner sGenero = (Spinner) findViewById(R.id.sGender);
    }

    public void SignUp (View view){
        conn=new connectionDB(this,"bd_users",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();
        String[] parametros={email.getText().toString()};

        String nombre = fname.getText().toString();
        String apellido = lname.getText().toString();
        String correo = email.getText().toString();
        String contrasena = password.getText().toString();
        String contrasena2 = rpassword.getText().toString();
        //String size = sGender.getSelectedItem().toString();

        if (nombre.length() == 0){
            fname.setError("Debe escribir un nombre");
        } else if (apellido.length() == 0){
            lname.setError("Debe escribir apellido");
        } else if (correo.length() == 0){
            email.setError("Debe escribir correo");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            email.setError("El correo no es valido");
        } else if (contrasena.length() == 0){
            Toast.makeText(this, "Debe escribir una contraseña", Toast.LENGTH_SHORT).show();
        } else if (contrasena.length() < 8){
            Toast.makeText(this, "La contraseña debe tener almenos 8 caracteres", Toast.LENGTH_SHORT).show();
        } else if (contrasena2.length() == 0){
            Toast.makeText(this, "Debe confirmar una contraseña", Toast.LENGTH_SHORT).show();
        } else if (nombre.length() != 0 && apellido.length() != 0 && email.length() != 0 && contrasena.length() != 0 && contrasena2.equals(contrasena)){
            try{
                //select email, nombre from usuario where codigo=?
                Cursor cursor=market.rawQuery("SELECT "+Utilidades.CAMPO_EMAIL+
                        " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_EMAIL+"=? ",parametros);
                cursor.moveToFirst();
                Toast.makeText(this, "El correo "+cursor.getString(0)+" ya existe", Toast.LENGTH_SHORT).show();
                cursor.close();
                //Toast.makeText(this, "El correo "+size+" ya existe", Toast.LENGTH_SHORT).show();
                limpiar();

            }catch (Exception e) {
                registrarUsuarios();
            }
        } else {
            Toast.makeText(this, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show();
        }

    }

    private void registrarUsuarios() {
        connectionDB conn=new connectionDB(this,"bd_users",null,1);

        SQLiteDatabase market=conn.getWritableDatabase();

        //Traer datos
        String nombre = fname.getText().toString();
        String apellido = lname.getText().toString();
        String correo = email.getText().toString();
        String contrasena = password.getText().toString();

        //Llenar datos en BD
        ContentValues pack=new ContentValues();
        pack.put(Utilidades.CAMPO_NOMBRE, nombre);
        pack.put(Utilidades.CAMPO_APELLIDO, apellido);
        pack.put(Utilidades.CAMPO_EMAIL, correo);
        pack.put(Utilidades.CAMPO_CONTRASENA, contrasena);

        //insertar datos
        long insert = market.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, pack);

        Toast.makeText(this, "The user has been registered", Toast.LENGTH_SHORT).show();
        market.close();
    }

    private void limpiar() {
        email.setText("");
    }
}
