package com.example.racecar;

import java.util.ArrayList;

public class Hero {
    private float x,y;

    public Hero(){
        Startuj();
    }

    public void Startuj() {
        x=220;
        y=550;
    }

    public float getX(){return x;}
    public float getY(){return y;}

    public void Dolava(){
        if(x>10) x= x -25;
    }

    public void Doprava(){
        if(x<470) x= x + 25;
    }

    public boolean Naraz(ArrayList<Prekazka> zoznam){
        for(int i =0; i< zoznam.size(); i++){
            Prekazka prekazka = (Prekazka) (zoznam.get(i));
            if(jeBlizko(getX(),getY(),prekazka.getX(),prekazka.getY())){
                zoznam.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean Naraz2(ArrayList<Minca> zoznam2){
        for(int i =0; i< zoznam2.size(); i++){
            Minca minc = (Minca) (zoznam2.get(i));
            if(jeBlizko2(getX(),getY(),minc.getX(),minc.getY())){
                zoznam2.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean Naraz3(ArrayList<Zivot> zoznam3){
        for(int i =0; i< zoznam3.size(); i++){
            Zivot lajf = (Zivot) (zoznam3.get(i));
            if(jeBlizko3(getX(),getY(),lajf.getX(),lajf.getY())){
                zoznam3.remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean jeBlizko(float ax, float ay, float bx, float by){
        return (Math.sqrt((ax - bx)*(ax - bx) + (ay - by)*(ay - by)))<80;
    }

    private boolean jeBlizko2(float ax, float ay, float bx, float by){
        return (Math.sqrt((ax - bx)*(ax - bx) + (ay - by)*(ay - by)))<40;
    }

    private boolean jeBlizko3(float ax, float ay, float bx, float by){
        return (Math.sqrt((ax - bx)*(ax - bx) + (ay - by)*(ay - by)))<40;
    }
}
