package com.example.splashscreen;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static int MIN_DISTANCE = 150;
    private float x1,x2,y1,y2;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize gesturedetector
        this.gestureDetector = new GestureDetector(MainActivity.this, this);

    }

    //override on touch event


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);

        switch (event.getAction()) {
            //starting to swipe time gesture
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;

                //ending time swipe gesture
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();


                // value for vertical swipe
                float valueY = y2 - y1;

                if (Math.abs(valueY) > MIN_DISTANCE) {

                    //detect top to bottom swipe
                    if (y2 >y1)
                    {
                        Log.d(TAG, "Bottom Swipe");
                        openTextDect();
                    }
                    else
                    {
                        Log.d(TAG, "Top Swipe");
                        openObjectDect();
                    }
                }

        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    public void openTextDect() {
        Intent intent = new Intent(this, TextDetection.class);
        startActivity(intent);
    }

    public void openObjectDect() {
        Intent intent = new Intent(this, ObjectDetection.class);
        startActivity(intent);
    }
}