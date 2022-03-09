package com.example.game2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.game2d.GameView.screenRatioX;
import static com.example.game2d.GameView.screenRatioY;

public class Walk {

    public boolean isGoingUp;
    int toShoot = 0;
    int x, y, width, height, wingCounter = 0, shootCounter=1;
    Bitmap walk0, walk1, walk2, walk3, walk4, walk5, walk6 ,walk7, shoot1,shoot2,shoot3,shoot4,shoot5,shoot6 ;
    private GameView gameView;
    Walk(GameView gameView,int screenY, Resources res) {
        this.gameView = gameView;
        walk0 = BitmapFactory.decodeResource(res, R.drawable.walk_000);
        walk1 = BitmapFactory.decodeResource(res, R.drawable.walk_001);
        walk2 = BitmapFactory.decodeResource(res, R.drawable.walk2);
        walk3 = BitmapFactory.decodeResource(res, R.drawable.walk3);
        walk4 = BitmapFactory.decodeResource(res, R.drawable.walk4);
        walk5 = BitmapFactory.decodeResource(res, R.drawable.walk5);
        walk6 = BitmapFactory.decodeResource(res, R.drawable.walk6);
        walk7 = BitmapFactory.decodeResource(res, R.drawable.walk7);
        width = walk0.getWidth();
        height = walk0.getHeight();

        width /= 9;
        height /= 9;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        walk0 = Bitmap.createScaledBitmap(walk0, width, height, false);
        walk1 = Bitmap.createScaledBitmap(walk1, width, height, false);
        walk2 = Bitmap.createScaledBitmap(walk2, width, height, false);
        walk3 = Bitmap.createScaledBitmap(walk3, width, height, false);
        walk4 = Bitmap.createScaledBitmap(walk4, width, height, false);
        walk5 = Bitmap.createScaledBitmap(walk5, width, height, false);
        walk6 = Bitmap.createScaledBitmap(walk6, width, height, false);
        walk7 = Bitmap.createScaledBitmap(walk7, width, height, false);

        shoot1 = BitmapFactory.decodeResource(res, R.drawable.shoot1);
        shoot2 = BitmapFactory.decodeResource(res, R.drawable.shoot2);
        shoot3 = BitmapFactory.decodeResource(res, R.drawable.shoot3);
        shoot4 = BitmapFactory.decodeResource(res, R.drawable.shoot4);
        shoot5 = BitmapFactory.decodeResource(res, R.drawable.shoot5);
        shoot6 = BitmapFactory.decodeResource(res, R.drawable.shoot6);

        shoot1 = Bitmap.createScaledBitmap(shoot1, width,height, false);
        shoot2 = Bitmap.createScaledBitmap(shoot2, width,height, false);
        shoot3 = Bitmap.createScaledBitmap(shoot3, width,height, false);
        shoot4 = Bitmap.createScaledBitmap(shoot4, width,height, false);
        shoot5 = Bitmap.createScaledBitmap(shoot5, width,height, false);
        shoot6 = Bitmap.createScaledBitmap(shoot6, width,height, false);

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
            shootCounter=1;
            toShoot--;
            gameView.newBullet();
            return shoot6;
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

                wingCounter=0;
            return walk7;
        }

}




