package com.example.game2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.game2d.GameView.screenRatioX;
import static com.example.game2d.GameView.screenRatioY;

public class Walk {
    int toShoot = 0;
    boolean isGoingUp = false;
    int x, y, width, height, wingCounter = 0, shootCounter=1;
    Bitmap walk0, walk1, walk2, walk3, walk4, walk5, walk6 ,walk7, walk8,walk9,walk10,walk11,walk12,
            walk13,walk14,walk15,walk16,walk17,walk18,walk19,walk20,walk21,walk22,walk23,shoot1,shoot2,
            shoot3,shoot4,shoot5,shoot6,shoot7,shoot8,shoot9,shoot10,shoot11,shoot12, dead1,dead2,dead3,
            dead4,dead5,dead6,dead7,dead8,dead9,dead10,dead11,dead12;
    private GameView gameView;
    Walk(GameView gameView,int screenY, Resources res) {
        this.gameView = gameView;
        walk0 = BitmapFactory.decodeResource(res, R.drawable.walk1);
        walk1 = BitmapFactory.decodeResource(res, R.drawable.walk2);
        walk2 = BitmapFactory.decodeResource(res, R.drawable.walk2);
        walk3 = BitmapFactory.decodeResource(res, R.drawable.walk3);
        walk4 = BitmapFactory.decodeResource(res, R.drawable.walk4);
        walk5 = BitmapFactory.decodeResource(res, R.drawable.walk5);
        walk6 = BitmapFactory.decodeResource(res, R.drawable.walk6);
        walk7 = BitmapFactory.decodeResource(res, R.drawable.walk7);
        walk8 = BitmapFactory.decodeResource(res, R.drawable.walk8);
        walk9 = BitmapFactory.decodeResource(res, R.drawable.walk9);
        walk10 = BitmapFactory.decodeResource(res, R.drawable.walk10);
        walk11 = BitmapFactory.decodeResource(res, R.drawable.walk11);
        walk12 = BitmapFactory.decodeResource(res, R.drawable.walk12);
        walk13 = BitmapFactory.decodeResource(res, R.drawable.walk13);
        walk14 = BitmapFactory.decodeResource(res, R.drawable.walk14);
        walk15 = BitmapFactory.decodeResource(res, R.drawable.walk15);
        walk16 = BitmapFactory.decodeResource(res, R.drawable.walk16);
        walk17 = BitmapFactory.decodeResource(res, R.drawable.walk17);
        walk18 = BitmapFactory.decodeResource(res, R.drawable.walk18);
        walk19 = BitmapFactory.decodeResource(res, R.drawable.walk19);
        walk20 = BitmapFactory.decodeResource(res, R.drawable.walk20);
        walk21 = BitmapFactory.decodeResource(res, R.drawable.walk21);
        walk22 = BitmapFactory.decodeResource(res, R.drawable.walk22);
        walk23 = BitmapFactory.decodeResource(res, R.drawable.walk23);
        dead1  = BitmapFactory.decodeResource(res, R.drawable.dead1);
        dead2  = BitmapFactory.decodeResource(res, R.drawable.dead2);
        dead3  = BitmapFactory.decodeResource(res, R.drawable.dead3);
        dead4  = BitmapFactory.decodeResource(res, R.drawable.dead4);
        dead5  = BitmapFactory.decodeResource(res, R.drawable.dead5);
        dead6  = BitmapFactory.decodeResource(res, R.drawable.dead6);
        dead7  = BitmapFactory.decodeResource(res, R.drawable.dead7);
        dead8  = BitmapFactory.decodeResource(res, R.drawable.dead8);
        dead9  = BitmapFactory.decodeResource(res, R.drawable.dead9);
        dead10  = BitmapFactory.decodeResource(res, R.drawable.dead10);
        dead11 = BitmapFactory.decodeResource(res, R.drawable.dead11);
        dead12  = BitmapFactory.decodeResource(res, R.drawable.dead12);

        width = walk0.getWidth();
        height = walk0.getHeight();

        width /= 11;
        height /= 11;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        walk0 = Bitmap.createScaledBitmap(walk0, width, height, false);
        walk1 = Bitmap.createScaledBitmap(walk1, width, height, false);
        walk2 = Bitmap.createScaledBitmap(walk2, width, height, false);
        walk3 = Bitmap.createScaledBitmap(walk3, width, height, false);
        walk4 = Bitmap.createScaledBitmap(walk4, width, height, false);
        walk5 = Bitmap.createScaledBitmap(walk5, width, height, false);
        walk6 = Bitmap.createScaledBitmap(walk6, width, height, false);
        walk7 = Bitmap.createScaledBitmap(walk7, width, height, false);
        walk8 = Bitmap.createScaledBitmap(walk8, width, height, false);
        walk9 = Bitmap.createScaledBitmap(walk9, width, height, false);
        walk10 = Bitmap.createScaledBitmap(walk10, width, height, false);
        walk11 = Bitmap.createScaledBitmap(walk11, width, height, false);
        walk12 = Bitmap.createScaledBitmap(walk12, width, height, false);
        walk13 = Bitmap.createScaledBitmap(walk13, width, height, false);
        walk14 = Bitmap.createScaledBitmap(walk14, width, height, false);
        walk15 = Bitmap.createScaledBitmap(walk15, width, height, false);
        walk16 = Bitmap.createScaledBitmap(walk16, width, height, false);
        walk17 = Bitmap.createScaledBitmap(walk17, width, height, false);
        walk18 = Bitmap.createScaledBitmap(walk18, width, height, false);
        walk19 = Bitmap.createScaledBitmap(walk19, width, height, false);
        walk20 = Bitmap.createScaledBitmap(walk20, width, height, false);
        walk21 = Bitmap.createScaledBitmap(walk21, width, height, false);
        walk22 = Bitmap.createScaledBitmap(walk22, width, height, false);
        walk23 = Bitmap.createScaledBitmap(walk23, width, height, false);

        shoot1 = BitmapFactory.decodeResource(res, R.drawable.shoot1);
        shoot2 = BitmapFactory.decodeResource(res, R.drawable.shoot2);
        shoot3 = BitmapFactory.decodeResource(res, R.drawable.shoot3);
        shoot4 = BitmapFactory.decodeResource(res, R.drawable.shoot4);
        shoot5 = BitmapFactory.decodeResource(res, R.drawable.shoot5);
        shoot6 = BitmapFactory.decodeResource(res, R.drawable.shoot6);
        shoot7 = BitmapFactory.decodeResource(res, R.drawable.shoot7);
        shoot8 = BitmapFactory.decodeResource(res, R.drawable.shoot8);
        shoot9 = BitmapFactory.decodeResource(res, R.drawable.shoot9);
        shoot10 = BitmapFactory.decodeResource(res, R.drawable.shoot10);
        shoot11 = BitmapFactory.decodeResource(res, R.drawable.shoot11);
        shoot12 = BitmapFactory.decodeResource(res, R.drawable.shoot12);

        shoot1 = Bitmap.createScaledBitmap(shoot1, width,height, false);
        shoot2 = Bitmap.createScaledBitmap(shoot2, width,height, false);
        shoot3 = Bitmap.createScaledBitmap(shoot3, width,height, false);
        shoot4 = Bitmap.createScaledBitmap(shoot4, width,height, false);
        shoot5 = Bitmap.createScaledBitmap(shoot5, width,height, false);
        shoot6 = Bitmap.createScaledBitmap(shoot6, width,height, false);
        shoot7 = Bitmap.createScaledBitmap(shoot7, width,height, false);
        shoot8 = Bitmap.createScaledBitmap(shoot8, width,height, false);
        shoot9 = Bitmap.createScaledBitmap(shoot9, width,height, false);
        shoot10 = Bitmap.createScaledBitmap(shoot10, width,height, false);
        shoot11= Bitmap.createScaledBitmap(shoot11, width,height, false);
        shoot12 = Bitmap.createScaledBitmap(shoot12, width,height, false);

        dead1  = Bitmap.createScaledBitmap(dead1,width,height, false);
        dead2  = Bitmap.createScaledBitmap(dead2,width,height, false);
        dead3 = Bitmap.createScaledBitmap(dead3,width,height, false);
        dead4  = Bitmap.createScaledBitmap(dead4,width,height, false);
        dead5  = Bitmap.createScaledBitmap(dead5,width,height, false);
        dead6  = Bitmap.createScaledBitmap(dead6,width,height, false);
        dead7  = Bitmap.createScaledBitmap(dead7,width,height, false);
        dead8  = Bitmap.createScaledBitmap(dead8,width,height, false);
        dead9  = Bitmap.createScaledBitmap(dead9,width,height, false);
        dead10  = Bitmap.createScaledBitmap(dead10,width,height, false);
        dead11 = Bitmap.createScaledBitmap(dead11,width,height, false);
        dead12  = Bitmap.createScaledBitmap(dead12,width,height, false);


        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }
        Bitmap getWalk (){
        if (toShoot != 0){
            if (shootCounter == 1){
                shootCounter++;
                return shoot1;
            }
            if (shootCounter == 2){
                shootCounter++;
                return shoot2;
            }
            if (shootCounter == 3){
                shootCounter++;
                return shoot3;
            }
            if (shootCounter == 4){
                shootCounter++;
                return shoot4;
            }
            if (shootCounter == 5){
                shootCounter++;
                return shoot5;
            }
            if (shootCounter == 6){
                shootCounter++;
                return shoot6;
            }
            if (shootCounter == 7){
                shootCounter++;
                return shoot7;
            }
            if (shootCounter == 8){
                shootCounter++;
                return shoot8;
            }
            if (shootCounter == 9){
                shootCounter++;
                return shoot9;
            }
            if (shootCounter == 10){
                shootCounter++;
                return shoot10;
            }
            if (shootCounter == 11){
                shootCounter++;
                return shoot11;
            }
            shootCounter=1;
            toShoot--;
            gameView.newBullet();
            return shoot12;
        }
        if (wingCounter ==0){
            wingCounter++;
            return walk0;
        }
            else if (wingCounter==1) {
            wingCounter++;
            return walk1;
        }
                else if (wingCounter==2) {
            wingCounter++;
            return walk2;
        }
        else if (wingCounter==3){
            wingCounter++;
            return walk3;
        }
        else if (wingCounter==4){
            wingCounter++;
            return walk4;
        }
        else if (wingCounter==5){
            wingCounter++;
            return walk5;
        }
        else if (wingCounter==6){
            wingCounter++;
            return walk6;
        }
        else if (wingCounter==7){
            wingCounter++;
            return walk7;
        }
        else if (wingCounter==8){
            wingCounter++;
            return walk8;
        }
        else if (wingCounter==9){
            wingCounter++;
            return walk9;
        }
        else if (wingCounter==10){
            wingCounter++;
            return walk10;
        }
        else if (wingCounter==11){
            wingCounter++;
            return walk11;
        }
        else if (wingCounter==12){
            wingCounter++;
            return walk12;
        }
        else if (wingCounter==13){
            wingCounter++;
            return walk13;
        }
        else if (wingCounter==14){
            wingCounter++;
            return walk14;
        }
        else if (wingCounter==15){
            wingCounter++;
            return walk15;
        }
        else if (wingCounter==16){
            wingCounter++;
            return walk16;
        }
        else if (wingCounter==17){
            wingCounter++;
            return walk17;
        }
        else if (wingCounter==18){
            wingCounter++;
            return walk18;
        }
        else if (wingCounter==19){
            wingCounter++;
            return walk19;
        }
        else if (wingCounter==20){
            wingCounter++;
            return walk20;
        }
        else if (wingCounter==21){
            wingCounter++;
            return walk21;
        }
        else if (wingCounter==22){
            wingCounter++;
            return walk22;
        }

                wingCounter--;
            return walk23;
        }
    Rect getCollisionShape (){

        return new Rect(x,y, x + width, y+height);
    }
    Bitmap getDead (){
        if (wingCounter ==0){
            wingCounter++;
            return dead1;
        }
        else if (wingCounter==1) {
            wingCounter++;
            return dead2;
        }
        else if (wingCounter==2) {
            wingCounter++;
            return dead3;
        }
        else if (wingCounter==3) {
            wingCounter++;
            return dead4;
        }
        else if (wingCounter==4) {
            wingCounter++;
            return dead5;
        }
        else if (wingCounter==5) {
            wingCounter++;
            return dead6;
        }
        else if (wingCounter==6) {
            wingCounter++;
            return dead7;
        }
        else if (wingCounter==7) {
            wingCounter++;
            return dead8;
        }
        else if (wingCounter==8) {
            wingCounter++;
            return dead9;
        }
        else if (wingCounter==9) {
            wingCounter++;
            return dead10;
        }
        else if (wingCounter==10) {
            wingCounter++;
            return dead11;
        }
        wingCounter--;
        return dead12;
        }
    }





