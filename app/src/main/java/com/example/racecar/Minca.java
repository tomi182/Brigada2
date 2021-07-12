package com.example.racecar;

import java.util.ArrayList;

public class Minca {
    private float x,y;
    private int rychlost;

    public Minca(float ix,float iy,int irychlost){
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


    public boolean MincaNaraz(ArrayList<Prekazka> zoznam){
        for(int i =0; i< zoznam.size(); i++){
            Prekazka prekazka = (Prekazka) (zoznam.get(i));
            if(jeBlizko(getX(),getY(),prekazka.getX(),prekazka.getY())){
                prekazka.pohniX();
                return true;
            }
        }
        return false;
    }


    public boolean MincaNaraz3(ArrayList<Zivot> zoznam3){
        for(int i =0; i< zoznam3.size(); i++){
            Zivot lajf = (Zivot) (zoznam3.get(i));
            if(jeBlizko3(getX(),getY(),lajf.getX(),lajf.getY())){
                lajf.pohniX();
                return true;
            }
        }
        return false;
    }

    private boolean jeBlizko(float ax, float ay, float bx, float by){
        return (Math.sqrt((ax - bx)*(ax - bx) + (ay - by)*(ay - by)))<100;
    }


    private boolean jeBlizko3(float ax, float ay, float bx, float by){
        return (Math.sqrt((ax - bx)*(ax - bx) + (ay - by)*(ay - by)))<35;
    }
}
