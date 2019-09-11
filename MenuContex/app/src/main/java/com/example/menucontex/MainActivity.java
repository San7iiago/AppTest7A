package com.example.menucontex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para mostrar menu


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.colors1, menu);

        TextView hello = findViewById(R.id.idtext);
        registerForContextMenu(hello);
        menu.setHeaderTitle(":: Select Color ::");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Opt1:
                Toast.makeText(this, "You've selected yellow color", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Opt2:
                Toast.makeText(this, "You've selected yellow color", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Opt3:
                Toast.makeText(this, "You've selected yellow color", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
            }
    }
}
