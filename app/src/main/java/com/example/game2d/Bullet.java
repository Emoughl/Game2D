package com.example.game2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import static com.example.game2d.GameView.screenRatioX;
import static com.example.game2d.GameView.screenRatioY;

public class Bullet {
    int x,y;
    Bitmap bullet;
    Bullet (Resources res){

        bullet = BitmapFactory.decodeResource(res,R.drawable.bullet);

        int width = bullet.getWidth();
        int height = bullet.getHeight();

        width /=8;
        height /=8;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);

    }
}