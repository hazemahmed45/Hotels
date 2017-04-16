package com.hotels.features.main.activities.Activities.Splash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hotels.R;
import com.hotels.base.NavigationHelper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                NavigationHelper.launchLoginScreen(SplashScreen.this);
                finish();
            }
        },2000);
    }
}
