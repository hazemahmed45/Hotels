package com.hotels.features.main.activities.Activities.Login;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.BaseActivity;
import com.hotels.features.main.activities.Fragments.AboutUsFragment;
import com.hotels.features.main.activities.Fragments.BookingScreen;
import com.hotels.features.main.activities.Fragments.ContactUsFragment;
import com.hotels.features.main.activities.Fragments.HotelsScreen;
import com.hotels.features.main.activities.Fragments.ViewPager.Account.AccountViewPagerFragment;
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
    @BindView(R.id.login_toolbar) public Toolbar toolbar;

    @BindView(R.id.toolbar_context_name)TextView ContextName;
    @BindView(R.id.FrameLayoutLoginScreen)FrameLayout frameLayout;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen_activity);
        ButterKnife.bind(LoginScreen.this);
        setSupportActionBar(toolbar);
        CheckForScreen(User.getUser());
        //setupWindowAnimations();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();

        DrawerCreateWithAccount();

        CheckForScreen(User.getUser());

    }
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private void setupWindowAnimations() {
//        Slide slide = new Slide();
//        slide.setDuration(1000);
//        getWindow().setExitTransition(slide);
//    }

    private void CheckForScreen(User user)
    {
        //Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
        if(user.getEmail()==null)
        {
            LoginScreenFragment fm=new LoginScreenFragment();
            NavigationHelper.LaunchFragment(fm,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);

        }
        else if(user.getEmail()!=null)
        {
            HomeScreen HS=new HomeScreen();
            NavigationHelper.LaunchFragment(HS,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
        }
        ContextName.setText("Home");
    }

//    private void DrawerCreate()
//    {
//        drawer=new DrawerBuilder()
//                .withActivity(LoginScreen.this)
//                .withToolbar(toolbar)
//                .addDrawerItems(primaryDrawerItem[0])
//                .addDrawerItems(primaryDrawerItem[1])
//                .addDrawerItems(primaryDrawerItem[2])
//                .addDrawerItems(primaryDrawerItem[3])
//                .addDrawerItems(primaryDrawerItem[4])
//                .addDrawerItems(primaryDrawerItem[5])
//                .addDrawerItems(primaryDrawerItem[6])
//                .addDrawerItems(primaryDrawerItem[7])
//                .addDrawerItems(primaryDrawerItem[8])
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @RequiresApi(api = Build.VERSION_CODES.M)
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//                        boolean check=true;
//                        switch (position)
//                        {
//                            case 0:
//                            {
//                                CheckForScreen(User.getUser());
//                                ContextName.setText("Home");
//                                check= false;
//                                break;
//                            }
//                            case 1:
//                            {
//                                if(User.getUser()==null)
//                                {
//                                    NavigationHelper.LaunchSignInScreen(LoginScreen.this);
//                                }
//                                check=false;
//                                break;
//                            }
//                            case 3:
//                            {
//                                HotelsScreen HS=new HotelsScreen();
//                                LaunchFragment(HS);
//                                ContextName.setText("Hotels");
//                                check=false;
//                                break;
//                            }
//                            case 4:
//                            {
//                                RoomsListView roomsListView=new RoomsListView();
//                                LaunchFragment(roomsListView);
//                                ContextName.setText("Rooms");
//                                check=false;
//                                break;
//                            }
//                            case 6:
//                            {
//                                BookingScreen BS=new BookingScreen();
//                                LaunchFragment(BS);
//                                ContextName.setText("Booking");
//                                check=false;
//                                break;
//                            }
//                            case 7:
//                            {
//                                ContactUsFragment CUF=new ContactUsFragment();
//                                LaunchFragment(CUF);
//                                ContextName.setText("Contact Us");
//                                check=false;
//                                break;
//                            }
//                            case 8:
//                            {
//                                AboutUsFragment AUF=new AboutUsFragment();
//                                LaunchFragment(AUF);
//                                ContextName.setText("About Us");
//                                check=false;
//                                break;
//                            }
//                        }
//
//                        view.setBackgroundColor(ColorUtil.getColor(R.color.MyColor));
//                        return check;
//                    }
//                })
//                .build();
//
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void DrawerCreateWithAccount()
    {
        AccountHeader headerResult;
        if(User.getUser().getEmail()!=null)
        {
            headerResult = new AccountHeaderBuilder()
                    .withActivity(this)
                    .withHeaderBackground(R.drawable.background)
                    .addProfiles(
                            new ProfileDrawerItem().withName(User.getUser().getFirstName()).withEmail(User.getUser().getEmail()).withIcon(R.mipmap.ic_launcher).withTextColor(ColorUtil.getColor(R.color.Black))
                    )
//                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
//                    @Override
//                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
//                        return false;
//                    }
//                })
                    .build();
        }
        else
        {
            headerResult = new AccountHeaderBuilder()
                    .withActivity(this)
                    .withHeaderBackground(R.drawable.background)

//                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
//                    @Override
//                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
//                        return false;
//                    }
//                })
                    .build();
        }
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
                        switch (position)
                        {
                            case 1:
                            {
                                CheckForScreen(User.getUser());
                                ContextName.setText("Home");
                                check= false;
                                break;
                            }
                            case 2:
                            {
                                if(User.getUser().getEmail()==null)
                                {
                                    NavigationHelper.LaunchSignInScreen(LoginScreen.this);

                                }
                                else
                                {
                                    AccountViewPagerFragment AVPF=AccountViewPagerFragment.getInstance();
                                    NavigationHelper.LaunchFragment(AVPF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                }
                                check=false;
                                break;
                            }

                            case 3:
                            {
                                if(User.getUser().getEmail()==null)
                                {
                                    NavigationHelper.LaunchSignInScreen(LoginScreen.this);
                                }
                                else
                                {
                                    AccountViewPagerFragment AVPF=AccountViewPagerFragment.getInstance();
                                    NavigationHelper.LaunchFragment(AVPF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                }
                                check=false;
                                break;
                            }
                            case 4:
                            {
                                HotelsScreen HS=new HotelsScreen();
                                NavigationHelper.LaunchFragment(HS,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                ContextName.setText("Hotels");
                                check=false;
                                //setupWindowAnimations();
                                break;
                            }
                            case 5:
                            {
                                RoomsListView roomsListView=new RoomsListView();
                                NavigationHelper.LaunchFragment(roomsListView,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                ContextName.setText("Rooms");
                                check=false;
                                break;
                            }
                            case 7:
                            {
                                BookingScreen BS=new BookingScreen();
                                NavigationHelper.LaunchFragment(BS,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                ContextName.setText("Booking");
                                check=false;
                                break;
                            }
                            case 8:
                            {
                                ContactUsFragment CUF=new ContactUsFragment();
                                NavigationHelper.LaunchFragment(CUF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                check=false;
                                ContextName.setText("Contact Us");
                                break;
                            }
                            case 9:
                            {
                                AboutUsFragment AUF=new AboutUsFragment();
                                NavigationHelper.LaunchFragment(AUF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                ContextName.setText("About Us");
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void LaunchFragment(Fragment fragment)
    {
        FragmentTransaction FT=getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.FrameLayoutLoginScreen,fragment);
        FT.addToBackStack(null);
        FT.commit();
    }

}
