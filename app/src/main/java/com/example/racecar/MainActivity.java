package com.example.racecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
        Intent intent = new Intent(MainActivity.this,StartActivity.class);
        startActivity(intent);
    }

    public void ovladanie(View view) {
        Intent intent = new Intent(MainActivity.this,OvladanieActivity2.class);
        startActivity(intent);
    }
}