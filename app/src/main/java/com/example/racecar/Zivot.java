package com.example.racecar;

public class Zivot {
    private float x,y;
    private int rychlost;

    public Zivot(float ix,float iy,int irychlost){
        x = ix;
        y = iy;
        rychlost = irychlost;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void Pohni(){
        y = y+ rychlost;
    }

    public void pohniX(){
        if(x<360) {
            x = x + 120;
        } else x =x-120;
    }
}
