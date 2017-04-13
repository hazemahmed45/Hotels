package com.hotels.features.main.activities.Splash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hotels.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },2000);
    }
}
