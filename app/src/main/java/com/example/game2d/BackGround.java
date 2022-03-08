package com.example.game2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BackGround {
    int x,y;
    Bitmap background;

    BackGround(int screenX, int screenY, Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.city1);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }
}
