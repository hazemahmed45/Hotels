package com.hotels.features.main.activities.Activities.Splash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.utils.NavigationHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.saeid.fabloading.LoadingView;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.loading_view)LoadingView loadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        ButterKnife.bind(this);
        loadingView.addAnimation(R.color.MyColor,R.color.bg_login,LoadingView.FROM_TOP);
        loadingView.addAnimation(R.color.bg_login,R.color.btn_logut_bg,LoadingView.FROM_LEFT);
        loadingView.addAnimation(R.color.btn_logut_bg,R.color.cocktail,LoadingView.FROM_BOTTOM);
        loadingView.addAnimation(R.color.cocktail,R.color.MyColor,LoadingView.FROM_RIGHT);

        loadingView.addListener(new LoadingView.LoadingListener() {
            @Override
            public void onAnimationStart(int currentItemPosition) {
            }

            @Override
            public void onAnimationRepeat(int nextItemPosition) {
            }

            @Override
            public void onAnimationEnd(int nextItemPosition) {

            }
        });

        loadingView.startAnimation();
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                NavigationHelper.launchLoginScreen(SplashScreen.this);
                finish();
            }
        },5000);
    }
}
