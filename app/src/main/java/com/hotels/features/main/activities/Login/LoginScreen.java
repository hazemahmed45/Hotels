package com.hotels.features.main.activities.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.BaseActivity;
import com.hotels.base.HotelsApplication;
import com.hotels.base.NavigationHelper;
import com.hotels.utils.StringUtil;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginScreen extends BaseActivity {

    Drawer drawer;
    @BindView(R.id.login_toolbar) Toolbar toolbar;
    @OnClick(R.id.user_login_signin_button)void SignInButtonClicked()
    {
        NavigationHelper.LaunchSignInScreen(LoginScreen.this);
    }
    @OnClick(R.id.user_login_signup_button)void SignUpButtonClicked()
    {
        NavigationHelper.LaunchSignUpScreen(LoginScreen.this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen_activity);
        ButterKnife.bind(LoginScreen.this);


        drawer=new DrawerBuilder()
                .withActivity(LoginScreen.this)
                .withToolbar(toolbar)
                .addDrawerItems(primaryDrawerItem[0])
                .addDrawerItems(primaryDrawerItem[1])
                .addDrawerItems(primaryDrawerItem[2])
                .addDrawerItems(primaryDrawerItem[3])
                .addDrawerItems(primaryDrawerItem[4])
                .addDrawerItems(primaryDrawerItem[5])
                .addDrawerItems(primaryDrawerItem[6])
                .addDrawerItems(primaryDrawerItem[7])
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Toast.makeText(LoginScreen.this, position+"", Toast.LENGTH_SHORT).show();
                        return true ;
                    }
                })
                .build();
    }
}
