package com.example.mycolorsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    //Instance id's from XML form design
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColors = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the id's from xml form design
        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        vieColors = findViewById(R.id.vieColors);

        //Set Seekbar Change on moving
        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

        // Enable on context Menu on view component
        registerForContextMenu(vieColors);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.opt_1 :
                startActivity(new Intent(MainActivity.this, AboutOf.class));
                return true;
            case R.id.btnRestart :
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(0);

                int color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options1,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.iteTransparent :
                sbrAlpha.setProgress(0);

                int color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteSemitransparent :
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteOpaque :
                sbrAlpha.setProgress(255);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteYellow :
                sbrRed.setProgress(241);
                sbrGreen.setProgress(196);
                sbrBlue.setProgress(15);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteBlue :
                sbrRed.setProgress(52);
                sbrGreen.setProgress(152);
                sbrBlue.setProgress(219);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteRed :
                sbrRed.setProgress(244);
                sbrGreen.setProgress(67);
                sbrBlue.setProgress(54);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteGreen :

                sbrRed.setProgress(46);
                sbrGreen.setProgress(204);
                sbrBlue.setProgress(113);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteBrown :
                sbrRed.setProgress(121);
                sbrGreen.setProgress(85);
                sbrBlue.setProgress(72);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteBlack :
                sbrRed.setProgress(33);
                sbrGreen.setProgress(33);
                sbrBlue.setProgress(33);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.itePink :
                sbrRed.setProgress(245);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(87);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.itePurple :
                sbrRed.setProgress(94);
                sbrGreen.setProgress(53);
                sbrBlue.setProgress(177);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteWhite :
                sbrRed.setProgress(238);
                sbrGreen.setProgress(238);
                sbrBlue.setProgress(238);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            case R.id.iteGray :
                sbrRed.setProgress(158);
                sbrGreen.setProgress(158);
                sbrBlue.setProgress(158);
                sbrAlpha.setProgress(125);

                color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
                vieColors.setBackgroundColor(color);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
