package com.hotels.features.main.activities.Login;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.BaseActivity;
import com.hotels.base.HotelsApplication;
import com.hotels.base.NavigationHelper;
import com.hotels.features.main.activities.Fragments.HomeScreen;
import com.hotels.features.main.activities.Fragments.LoginScreenFragment;
import com.hotels.model.User;
import com.hotels.utils.ColorUtil;
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
    @BindView(R.id.FrameLayoutLoginScreen)FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen_activity);
        ButterKnife.bind(LoginScreen.this);
        CheckForScreen(User.getUser());
        DrawerCreate();

    }

    private void DrawerCreate()
    {
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
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        boolean check=true;
                        switch (position)
                        {
                            case 0:
                            {
                                CheckForScreen(User.getUser());

                                check= false;
                            }
                            case 1:
                            {
                                if(User.getUser()==null)
                                {
                                    NavigationHelper.LaunchSignInScreen(LoginScreen.this);
                                }
                                check=false;
                            }
                        }

                        view.setBackgroundColor(ColorUtil.getColor(R.color.MyColor));
                        return check;
                    }
                })
                .build();

    }
    @Override
    protected void onResume() {
        super.onResume();

        CheckForScreen(User.getUser());
    }

    private void CheckForScreen(User user)
    {
        //Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
        if(user.getEmail()==null)
        {
            LoginScreenFragment fm=new LoginScreenFragment();
            FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
            FT.replace(R.id.FrameLayoutLoginScreen,fm);
            FT.commit();

        }
        else if(user.getEmail()!=null)
        {
            HomeScreen HS=new HomeScreen();
            FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
            FT.replace(R.id.FrameLayoutLoginScreen,HS);
            FT.commit();
        }
    }
}
