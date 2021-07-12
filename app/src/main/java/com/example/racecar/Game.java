package com.example.racecar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Game extends View {
    Paint paint;
    Hero ja;
    ArrayList<Prekazka> zoznam;
    ArrayList<Minca> zoznam2;
    ArrayList<Zivot> zoznam3;
    ArrayList<Pruhy> zoznam4;
    Bitmap cesta, road, auto, car, prekazka, problem, minca, coin, health, life, pruh, pruhh;
    public int zivot = 3;
    int score;
    int rychlost = 4;
    int q;
    int p = 0;

    public Game(Context context) {
        super(context);
        paint = new Paint();
        cesta = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cesta2));
        road = Bitmap.createScaledBitmap(cesta, 480, 800, false);

        auto = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.auto2));
        car = Bitmap.createScaledBitmap(auto, 55, 105, false);

        prekazka = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.prekazkaa));
        problem = Bitmap.createScaledBitmap(prekazka, 120, 60, false);

        minca = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.mincaa));
        coin = Bitmap.createScaledBitmap(minca, 35, 35, false);

        health = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.health));
        life = Bitmap.createScaledBitmap(health, 60, 60, false);

        pruh = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.pruhy4));
        pruhh = Bitmap.createScaledBitmap(pruh, 500, 350, false);

        ja = new Hero();
        zoznam = new ArrayList<Prekazka>();
        zoznam2 = new ArrayList<Minca>();
        zoznam3 = new ArrayList<Zivot>();
        zoznam4 = new ArrayList<Pruhy>();
        q = 0;
    }

    public void onDraw(Canvas canvas) {
        Prekazka pr;
        Minca minc;
        Zivot lajf;
        Pruhy pruh;
        canvas.drawBitmap(road, 0, 0, paint);
        paint.setColor(Color.YELLOW);
        paint.setTextSize(20);
        canvas.drawText("Body: " + score, 10, 20, paint);
        canvas.drawText("Life: " + zivot, 10, 40, paint);

        for (int i = 0; i < zoznam.size(); i++) {
            pr = (Prekazka) (zoznam.get(i));
            canvas.drawBitmap(problem, pr.getX(), pr.getY(), paint);
        }
        for (int i = 0; i < zoznam2.size(); i++) {
            minc = (Minca) (zoznam2.get(i));
            canvas.drawBitmap(coin, minc.getX(), minc.getY(), paint);
        }
        for (int i = 0; i < zoznam3.size(); i++) {
            lajf = (Zivot) (zoznam3.get(i));
            canvas.drawBitmap(life, lajf.getX(), lajf.getY(), paint);
        }
        for (int i = 0; i < zoznam4.size(); i++) {
            pruh = (Pruhy) (zoznam4.get(i));
            canvas.drawBitmap(pruhh, pruh.getX(), pruh.getY(), paint);
        }
        canvas.drawBitmap(car, ja.getX(), ja.getY(), paint);

        if (zivot == 0 ){
            paint.setColor(Color.RED);
            paint.setTextSize(35);
            canvas.drawText("Stratil si všetky životy!", 70, 300, paint);
            canvas.drawText("Klikni pre nový štart", 90, 330, paint);
        }
    }

    public void update() {
        if (score == 3 && q == 0) {
            rychlost = rychlost + 2;
            q++;
        }
        if (score == 6 && q == 1) {
            rychlost = rychlost + 2;
            q++;
        }
        if (score == 9 && q == 2) {
            rychlost = rychlost + 2;
            q++;
        }
        if (score == 12 && q == 3) {
            rychlost = rychlost + 2;
            q++;
        }
        if (score == 15 && q == 4) {
            rychlost = rychlost + 2;
            q++;
        }
        if (score == 18 && q == 5) {
            rychlost = rychlost + 2;
            q++;
        }

        Prekazka prekazka;
        if (zivot > 0) {
            if (zoznam.size() < 2) {
                zoznam.add(new Prekazka((1 + (int) (Math.random() * 360)), 0, rychlost));

            }

            for (int i = zoznam.size() - 1; i >= 0; i--) {
                prekazka = (Prekazka) (zoznam.get(i));
                prekazka.Pohni();
                if (prekazka.getY() > 800) zoznam.remove(i);
            }
        } else {
            zoznam.clear();
        }

        Minca minc;
        if (zivot > 0) {
            if (zoznam2.size() < 2) {
                zoznam2.add(new Minca((1 + (int) (Math.random() * 440)), 0, rychlost));

            }

            for (int i = zoznam2.size() - 1; i >= 0; i--) {
                minc = (Minca) (zoznam2.get(i));
                minc.Pohni();
                if (minc.getY() > 800) zoznam2.remove(i);
            }
        } else {
            zoznam2.clear();
        }

        Zivot lajf;
        if (zivot > 0) {
            if (zoznam3.size() < 1) {
                if (zivot < 3) {
                    if (Math.random() > 0.99) {
                        zoznam3.add(new Zivot((1 + (int) (Math.random() * 440)), 0, rychlost));
                    }
                }
            }

            for (int i = zoznam3.size() - 1; i >= 0; i--) {
                lajf = (Zivot) (zoznam3.get(i));
                lajf.Pohni();
                if (lajf.getY() > 800) zoznam3.remove(i);
            }
        } else {
            zoznam3.clear();
        }

        Pruhy pruh;
            if (zoznam4.size() <= 7) {
                zoznam4.add(new Pruhy(0, 0, rychlost));
                zoznam4.add(new Pruhy(0, 100, rychlost));
                zoznam4.add(new Pruhy(0, 200, rychlost));
                zoznam4.add(new Pruhy(0, 300, rychlost));
                zoznam4.add(new Pruhy(0, 400, rychlost));
                zoznam4.add(new Pruhy(0, 500, rychlost));
                zoznam4.add(new Pruhy(0, 600, rychlost));
            }

            for (int i = zoznam4.size() - 1; i >= 0; i--) {
                pruh = (Pruhy) (zoznam4.get(i));
                pruh.Pohni();
                if (pruh.getY() > 570) zoznam4.remove(i);
            }

        if (ja.Naraz(zoznam)) {
            zivot--;
            Context context = this.getContext();
            Toast.makeText(context, "-1 life", Toast.LENGTH_SHORT).show();
        }

        if (ja.Naraz2(zoznam2)) {
            score++;
        }

        if (ja.Naraz3(zoznam3)) {
            zivot++;
        }

        Minca min;
        for (int i = zoznam2.size() - 1; i >= 0; i--) {
            min = (Minca) (zoznam2.get(i));

            if (min.MincaNaraz(zoznam)) {
                p++;
            }
            if (min.MincaNaraz3(zoznam3)) {
                p++;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int e = event.getAction();
        if (zivot > 0) {
            if (e == MotionEvent.ACTION_DOWN) {
                float xx = event.getX();
                if (xx > ja.getX()) ja.Doprava();
                if (xx < ja.getX()) ja.Dolava();
            }
            invalidate();
            return true;
        } else {
            if (e == MotionEvent.ACTION_DOWN) {
                zivot = 3;
            }
            invalidate();
            return true;
        }
    }

}
