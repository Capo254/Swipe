package com.example.emobilis.swipe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat movement;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(MainActivity.this,R.raw.bfyv);
        movement = new GestureDetectorCompat(this,new LearnGesture());

    }
    public boolean onTouchEvent(MotionEvent event){
        this.movement.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX()>e1.getX()){
                if (music.isPlaying()){
                    music.pause();
                    Intent hh = new Intent(getApplicationContext(),Main2.class);
                    startActivity(hh);
                }
            }else if (e2.getX()<e1.getX())
                music.start();
            return true;
        }
    }
}
