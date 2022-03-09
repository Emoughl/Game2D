package com.example.game2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private int screenX, screenY;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private List<Bullet>bullets;
    private Walk walk;
    private BackGround backGround1, backGround2;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;
        backGround1 = new BackGround(screenX, screenY, getResources());
        backGround2 = new BackGround(screenX, screenY, getResources());
        walk = new Walk (this, screenY, getResources());
        bullets=new ArrayList<>();
        backGround2.x = screenX;
        paint = new Paint();
    }

    @Override
    public void run() {

        while (isPlaying) {


            update();
            draw();
            sleep();

        }
    }

    private void update() {
        backGround1.x -= 40 * screenRatioX;
        backGround2.x -= 40 * screenRatioX;

        if (backGround1.x + backGround1.background.getWidth() < 0) {
            backGround1.x = screenX;
        }
        if (backGround2.x + backGround2.background.getWidth() < 0) {
            backGround2.x = screenX;
            if (walk.isGoingUp)
                walk.y -= 30 * screenRatioY;
            else walk.y += 30 * screenRatioY;
            if (walk.y < 0)
                walk.y = 0;
            if (walk.y > screenY - walk.height)
                walk.y = screenY - walk.height;
            List<Bullet> trash = new ArrayList<>();
            for (Bullet bullet : bullets) {
                if (bullet.x > screenX)
                    trash.add(bullet);

                bullet.x += 50 * screenRatioX;
            }
            for (Bullet bullet : trash)
                bullets.remove(bullet);
        }
    }

    private void draw() {

        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(backGround1.background, backGround1.x, backGround1.y, paint);
            canvas.drawBitmap(backGround2.background, backGround2.x, backGround2.y, paint);

            canvas.drawBitmap(walk.getWalk(), walk.x, walk.y, paint);
            for (Bullet bullet : bullets)
                canvas.drawBitmap(bullet.bullet, bullet.x, bullet.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {

        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public boolean pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX/2){
                    walk.isGoingUp = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                    walk.isGoingUp=false;
                    if (event.getX()>screenX/2)
                        walk.toShoot++;
                break;
        }
        return true;
    }

    public void newBullet() {
        Bullet bullet = new Bullet(getResources());
        bullet.x = walk.x + walk.width;
        bullet.y = walk.y + (walk.height/2);
        bullets.add(bullet);
    }
}

