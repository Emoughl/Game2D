package com.example.game2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.game2d.GameView.screenRatioX;
import static com.example.game2d.GameView.screenRatioY;

public class Walk {

    public boolean isGoingUp;
    public int toShoot;
    int x, y, width, height, wingCounter = 0;
    Bitmap walk0, walk1, walk2, walk3, walk4, walk5, walk6 ,walk7;
    Walk (int screenY, Resources res ) {
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
        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }
        Bitmap getWalk (){
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


