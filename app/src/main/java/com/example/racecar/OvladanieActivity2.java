package com.example.racecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OvladanieActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovladanie2);
        TextView edt1 = (TextView) findViewById(R.id.textView);
        TextView edt2 = (TextView) findViewById(R.id.textView2);
        TextView edt3 = (TextView) findViewById(R.id.textView3);

    }

    public void startGame(View view) {
        Intent intent = new Intent(OvladanieActivity2.this,StartActivity.class);
        startActivity(intent);
    }
}