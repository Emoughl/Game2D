package com.example.game2d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying, GameEnd = false;
    private int screenX, screenY, score = 0;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private Goblems[] goblems;
    private SharedPreferences prefs;
    private Random random;
    private SoundPool soundPool;
    private int sound;
    private List<Bullet> bullets;
    private GameActivity activity;
    private Walk walk;
    private BackGround backGround1, backGround2;

    public GameView(GameActivity activity, int screenX, int screenY) {
        super(activity);
        this.activity = activity;
        prefs = activity.getSharedPreferences("game", Context.MODE_PRIVATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(activity, R.raw.kiem, 1);


        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;
        backGround1 = new BackGround(screenX, screenY, getResources());
        backGround2 = new BackGround(screenX, screenY, getResources());
        walk = new Walk(this, screenY, getResources());
        bullets = new ArrayList<>();
        backGround2.x = screenX;
        paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.RED);
        goblems = new Goblems[4];


        for (int i = 0; i < 4; i++) {

            Goblems goblem = new Goblems(getResources());
            goblems[i] = goblem;

        }
        random = new Random();
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
        backGround1.x -= 20 * screenRatioX;
        backGround2.x -= 20 * screenRatioX;

        if (backGround1.x + backGround1.background.getWidth() < 0) {
            backGround1.x = screenX;
        }
        if (backGround2.x + backGround2.background.getWidth() < 0) {
            backGround2.x = screenX;
        }
        if (walk.isGoingUp)
            walk.y -= 5 * screenRatioY;
        else walk.y += 5 * screenRatioY;
        if (walk.y < 0)
            walk.y = 0;
        if (walk.y >= screenY - walk.height)
            walk.y = screenY - walk.height;
        List<Bullet> trash = new ArrayList<>();
        for (Bullet bullet : bullets) {
            if (bullet.x > screenX)
                trash.add(bullet);

            bullet.x += 20 * screenRatioX;

            for (Goblems goblem : goblems) {
                if (Rect.intersects(goblem.getCollisionShape(),
                        bullet.getCollisionShape())) {

                    score++;
                    goblem.x = -500;
                    bullet.x = screenX + 500;
                    goblem.wasShot = true;
                }
            }
        }
        for (Bullet bullet : trash)
            bullets.remove(bullet);
        for (Goblems goblem : goblems) {
            goblem.x -= goblem.speed;
            if (goblem.x + goblem.width < 0) {

                if (!goblem.wasShot) {
                    GameEnd = true;
                    return;
                }
                int bound = (int) (30 * screenRatioX);
                goblem.speed = random.nextInt(bound);
                if (Goblems.speed < 10 * screenRatioX) ;
                goblem.speed = (int) (10 * screenRatioX);
                goblem.x = screenX;
                goblem.y = random.nextInt(screenY - goblem.height);

                goblem.wasShot = false;

            }
            if (Rect.intersects(goblem.getCollisionShape(), walk.getCollisionShape())) {
                GameEnd = true;
                return;
            }
        }
    }

    private void draw() {

        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(backGround1.background, backGround1.x, backGround1.y, paint);
            canvas.drawBitmap(backGround2.background, backGround2.x, backGround2.y, paint);

            for (Goblems goblem : goblems)
                canvas.drawBitmap(goblem.getGoblem(), goblem.x, goblem.y, paint);

            canvas.drawText(score + "", screenX / 2f, 164, paint);
            if (GameEnd) {
                isPlaying = false;
                canvas.drawBitmap(walk.getDead(), walk.x, walk.y, paint);
                getHolder().unlockCanvasAndPost(canvas);
                saveIfHighScore();
                waitBeforeExitting();
                return;
            }

            canvas.drawBitmap(walk.getWalk(), walk.x, walk.y, paint);
            for (Bullet bullet : bullets)
                canvas.drawBitmap(bullet.bullet, bullet.x, bullet.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    private void waitBeforeExitting() {
        try {
            Thread.sleep(3000);
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saveIfHighScore() {
        if (prefs.getInt("highscore", 0) < score) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("highscore", score);
            editor.apply();
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

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    walk.isGoingUp = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                walk.isGoingUp = false;
                if (event.getX() > screenX / 2)
                    walk.toShoot++;
                break;
        }
        return true;
    }

    public void newBullet() {


        if (!prefs.getBoolean("isMute", false))
            soundPool.play(sound, 1, 1, 0, 0, 1);
        Bullet bullet = new Bullet(getResources());
        bullet.x = walk.x + walk.width;
        bullet.y = walk.y + (walk.height / 2);
        bullets.add(bullet);
    }
}


