package com.example.racecar;

import android.os.Handler;

public class UpdateThread extends Thread{
    Handler myHandler;
    StartActivity sa;

    public UpdateThread(Handler handler) {
        super();
        myHandler = handler;
    }

    @Override
    public void run(){
        while(true){
            try{
                this.sleep(20);
            }catch (Exception e){}
            myHandler.sendEmptyMessage(0);

        }
    }

}
