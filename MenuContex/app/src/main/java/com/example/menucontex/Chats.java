package com.example.menucontex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Chats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
    }


    //Mostrar menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater InFlater = getMenuInflater():
        InFlater.inflate(R.menu.colors2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.op_1:
                Toast.makeText(this, "Has seleccionado Opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_2:
                Toast.makeText(this, "Has seleccionado Opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_one:
                Toast.makeText(this, "Has seleccionado submenu 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_two:
                Toast.makeText(this, "Has seleccionado submenu 2", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
