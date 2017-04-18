package com.hotels.features.main.activities.Login;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.BaseActivity;
import com.hotels.features.main.activities.Fragments.ContactUsFragment;
import com.hotels.utils.NavigationHelper;
import com.hotels.features.main.activities.Fragments.HomeScreen;
import com.hotels.features.main.activities.Fragments.LoginScreenFragment;
import com.hotels.features.main.activities.Fragments.RoomsListView;
import com.hotels.model.User;
import com.hotels.utils.ColorUtil;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

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


    }


    @Override
    protected void onResume() {
        super.onResume();
        if(User.getUser().getEmail()==null)
        {
            DrawerCreate();
        }
        else
        {
            DrawerCreateWithAccount();
        }
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
                .addDrawerItems(primaryDrawerItem[8])
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
                                break;
                            }
                            case 1:
                            {
                                if(User.getUser()==null)
                                {
                                    NavigationHelper.LaunchSignInScreen(LoginScreen.this);
                                }
                                check=false;
                                break;
                            }
                            case 4:
                            {
                                RoomsListView roomsListView=new RoomsListView();
                                FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
                                FT.replace(R.id.FrameLayoutLoginScreen,roomsListView);
                                FT.commit();
                                check=false;
                                break;
                            }
                            case 7:
                            {
                                ContactUsFragment CUF=new ContactUsFragment();
                                FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
                                FT.replace(R.id.FrameLayoutLoginScreen,CUF);
                                FT.commit();
                                check=false;
                                break;
                            }
                        }

                        view.setBackgroundColor(ColorUtil.getColor(R.color.MyColor));
                        return check;
                    }
                })
                .build();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void DrawerCreateWithAccount()
    {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .addProfiles(
                        new ProfileDrawerItem().withName(User.getUser().getEmail()).withEmail(User.getUser().getEmail()).withIcon(R.mipmap.ic_launcher).withTextColor(ColorUtil.getColor(R.color.Black))
                )
//                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
//                    @Override
//                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
//                        return false;
//                    }
//                })
                .build();
        drawer=new DrawerBuilder()
                .withActivity(LoginScreen.this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(primaryDrawerItem[0])
                .addDrawerItems(primaryDrawerItem[1])
                .addDrawerItems(primaryDrawerItem[2])
                .addDrawerItems(primaryDrawerItem[3])
                .addDrawerItems(primaryDrawerItem[4])
                .addDrawerItems(primaryDrawerItem[5])
                .addDrawerItems(primaryDrawerItem[6])
                .addDrawerItems(primaryDrawerItem[7])
                .addDrawerItems(primaryDrawerItem[8])
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        boolean check=true;
                        Toast.makeText(LoginScreen.this, position+"", Toast.LENGTH_SHORT).show();
                        switch (position)
                        {
                            case 1:
                            {
                                CheckForScreen(User.getUser());

                                check= false;
                                break;
                            }
                            case 2:
                            {
                                if(User.getUser()==null)
                                {
                                    NavigationHelper.LaunchSignInScreen(LoginScreen.this);
                                }
                                check=false;
                                break;
                            }
                            case 5:
                            {
                                RoomsListView roomsListView=new RoomsListView();
                                FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
                                FT.replace(R.id.FrameLayoutLoginScreen,roomsListView);
                                FT.commit();
                                check=false;
                                break;
                            }
                            case 8:
                            {
                                ContactUsFragment CUF=new ContactUsFragment();
                                FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
                                FT.replace(R.id.FrameLayoutLoginScreen,CUF);
                                FT.commit();
                                check=false;
                                break;
                            }
                        }

                        view.setBackgroundColor(ColorUtil.getColor(R.color.MyColor));
                        return check;
                    }
                })
                .build();

    }
}
