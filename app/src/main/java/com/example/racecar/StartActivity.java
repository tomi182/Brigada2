package com.example.racecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class StartActivity extends AppCompatActivity {

    UpdateThread myThread;
    Handler handler;
    Game g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        g = new Game(this);
        setContentView(g);
        VytvorHandler();
        myThread = new UpdateThread(handler);
        myThread.start();
    }

    private void VytvorHandler() {
        handler = new Handler() {
            public void handleMessage(Message msg) {
                g.update();
                g.invalidate();
                super.handleMessage(msg);
            }
        };
    }


    
}