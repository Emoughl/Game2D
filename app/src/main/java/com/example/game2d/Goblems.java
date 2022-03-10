package com.example.game2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.game2d.GameView.screenRatioX;
import static com.example.game2d.GameView.screenRatioY;

public class Goblems {
     public static int speed = 20;
     public boolean wasShot = true;
     int x = 0,y,width,height,GoblemCounter=1;
     Bitmap golem1,golem2,golem3,golem4,golem5,golem6,
     golem7,golem8,golem9,golem10,golem11,golem12,golem13,
             golem14,golem15,golem16,golem17,golem18,golem19,
     golem20,golem21,golem22,golem23;

     Goblems (Resources res) {
          golem1 = BitmapFactory.decodeResource(res, R.drawable.golem1);
          golem2 = BitmapFactory.decodeResource(res, R.drawable.golem2);
          golem3 = BitmapFactory.decodeResource(res, R.drawable.golem3);
          golem4 = BitmapFactory.decodeResource(res, R.drawable.golem4);
          golem5 = BitmapFactory.decodeResource(res, R.drawable.golem5);
          golem6 = BitmapFactory.decodeResource(res, R.drawable.golem6);
          golem7 = BitmapFactory.decodeResource(res, R.drawable.golem7);
          golem8 = BitmapFactory.decodeResource(res, R.drawable.golem8);
          golem9 = BitmapFactory.decodeResource(res, R.drawable.golem9);
          golem10 = BitmapFactory.decodeResource(res, R.drawable.golem10);
          golem11 = BitmapFactory.decodeResource(res, R.drawable.golem11);
          golem12 = BitmapFactory.decodeResource(res, R.drawable.golem12);
          golem13 = BitmapFactory.decodeResource(res, R.drawable.golem13);
          golem14 = BitmapFactory.decodeResource(res, R.drawable.golem14);
          golem15 = BitmapFactory.decodeResource(res, R.drawable.golem15);
          golem16 = BitmapFactory.decodeResource(res, R.drawable.golem16);
          golem17 = BitmapFactory.decodeResource(res, R.drawable.golem17);
          golem18 = BitmapFactory.decodeResource(res, R.drawable.golem18);
          golem19 = BitmapFactory.decodeResource(res, R.drawable.golem19);
          golem20 = BitmapFactory.decodeResource(res, R.drawable.golem20);
          golem21 = BitmapFactory.decodeResource(res, R.drawable.golem21);
          golem22 = BitmapFactory.decodeResource(res, R.drawable.golem22);
          golem23 = BitmapFactory.decodeResource(res, R.drawable.golem23);

          width = golem1.getWidth();
          height = golem1.getHeight();

          width /= 11;
          height /= 11;

          width = (int) (width * screenRatioX);
          height = (int) (height * screenRatioY);

          golem1 = Bitmap.createScaledBitmap(golem1, width, height, false);
          golem2 = Bitmap.createScaledBitmap(golem2, width, height, false);
          golem3 = Bitmap.createScaledBitmap(golem3, width, height, false);
          golem4 = Bitmap.createScaledBitmap(golem4, width, height, false);
          golem5 = Bitmap.createScaledBitmap(golem5, width, height, false);
          golem6 = Bitmap.createScaledBitmap(golem6, width, height, false);
          golem7 = Bitmap.createScaledBitmap(golem7, width, height, false);
          golem8 = Bitmap.createScaledBitmap(golem8, width, height, false);
          golem9 = Bitmap.createScaledBitmap(golem9, width, height, false);
          golem10 = Bitmap.createScaledBitmap(golem10, width, height, false);
          golem11 = Bitmap.createScaledBitmap(golem11, width, height, false);
          golem12 = Bitmap.createScaledBitmap(golem12, width, height, false);
          golem13 = Bitmap.createScaledBitmap(golem13, width, height, false);
          golem14 = Bitmap.createScaledBitmap(golem14, width, height, false);
          golem15 = Bitmap.createScaledBitmap(golem15, width, height, false);
          golem16 = Bitmap.createScaledBitmap(golem16, width, height, false);
          golem17 = Bitmap.createScaledBitmap(golem17, width, height, false);
          golem18 = Bitmap.createScaledBitmap(golem18, width, height, false);
          golem19 = Bitmap.createScaledBitmap(golem19, width, height, false);
          golem20 = Bitmap.createScaledBitmap(golem20, width, height, false);
          golem21 = Bitmap.createScaledBitmap(golem21, width, height, false);
          golem22 = Bitmap.createScaledBitmap(golem22, width, height, false);
          golem23 = Bitmap.createScaledBitmap(golem23, width, height, false);

          y = -height;
     }

          Bitmap getGoblem () {
               if (GoblemCounter ==1){
                    GoblemCounter++;
                    return golem1;
               }
               if (GoblemCounter ==2) {
                    GoblemCounter++;
                    return golem2;
               }
               if (GoblemCounter ==3) {
                    GoblemCounter++;
                    return golem3;
               }
               if (GoblemCounter ==4) {
                    GoblemCounter++;
                    return golem4;
               }
               if (GoblemCounter ==5) {
                    GoblemCounter++;
                    return golem5;
               }
               if (GoblemCounter ==6) {
                    GoblemCounter++;
                    return golem6;
               } if (GoblemCounter ==7) {
                    GoblemCounter++;
                    return golem7;
               }
               if (GoblemCounter ==8) {
                    GoblemCounter++;
                    return golem8;
               }
               if (GoblemCounter ==9) {
                    GoblemCounter++;
                    return golem9;
               }
               if (GoblemCounter ==10) {
                    GoblemCounter++;
                    return golem10;
               } if (GoblemCounter ==11) {
                    GoblemCounter++;
                    return golem11;
               }
               if (GoblemCounter ==12) {
                    GoblemCounter++;
                    return golem12;
               }
               if (GoblemCounter ==13) {
                    GoblemCounter++;
                    return golem13;
               }
               if (GoblemCounter ==14) {
                    GoblemCounter++;
                    return golem14;
               }
               if (GoblemCounter ==15) {
                    GoblemCounter++;
                    return golem15;
               }
               if (GoblemCounter ==16) {
                    GoblemCounter++;
                    return golem16;
               }
               if (GoblemCounter ==17) {
                    GoblemCounter++;
                    return golem17;
               }
               if (GoblemCounter ==18) {
                    GoblemCounter++;
                    return golem18;
               }
               if (GoblemCounter ==19) {
                    GoblemCounter++;
                    return golem19;
               }
               if (GoblemCounter == 20) {
                    GoblemCounter++;
                    return golem20;
               }
               if (GoblemCounter ==21) {
                    GoblemCounter++;
                    return golem21;
               }
               if (GoblemCounter == 22) {
                    GoblemCounter++;
                    return golem22;
               }

               GoblemCounter = 1;
               return golem23;
               }
     Rect getCollisionShape (){

          return new Rect(x,y, x + width, y + height);
     }
}
