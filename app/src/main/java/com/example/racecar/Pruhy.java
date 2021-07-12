package com.example.racecar;

public class Pruhy {
    private float x,y;
    private int rychlost;

    public Pruhy(float ix,float iy,int irychlost){
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
}
