package com.hotels.features.main.activities.Activities.Login;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hotels.R;
import com.hotels.base.BaseActivity;
import com.hotels.base.BaseDrawer;
import com.hotels.features.main.activities.Fragments.AboutUsFragment;
import com.hotels.features.main.activities.Fragments.BookingScreen;
import com.hotels.features.main.activities.Fragments.ContactUsFragment;
import com.hotels.features.main.activities.Fragments.HotelsScreen;
import com.hotels.features.main.activities.Fragments.ViewPager.Account.AccountViewPagerFragment;
import com.hotels.features.main.activities.Fragments.DrawerAdapter.Drawer.LoginDrawer;
import com.hotels.features.main.activities.Fragments.DrawerAdapter.Drawer.SignInDrawer;
import com.hotels.utils.NavigationHelper;
import com.hotels.features.main.activities.Fragments.RoomsListView;
import com.hotels.model.User;
import com.hotels.utils.ColorUtil;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginScreen extends BaseActivity {

    Drawer drawer;

    @BindView(R.id.login_toolbar) public Toolbar toolbar;
    @BindView(R.id.FrameLayoutLoginScreen)FrameLayout frameLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen_activity);
        ButterKnife.bind(LoginScreen.this);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
    }

    @Override
    protected void onPause() {
        super.onPause();
        drawer.closeDrawer();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();
        //YoYo.with(Techniques.BounceIn).delay(0).duration(1000).playOn(findViewById(R.id.FrameLayoutLoginScreen));
        DrawerCreateWithAccount();
        NavigationHelper.LaunchFragment(new RoomsListView(),getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void DrawerCreateWithAccount()
    {
        BaseDrawer Base;
        if(User.getUser().getEmail()==null)
        {
            Base=new SignInDrawer(LoginScreen.this);
        }
        else
        {
            Base=new LoginDrawer(LoginScreen.this);
        }

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
                .addDrawerItems(primaryDrawerItem[5])
                .addDrawerItems(primaryDrawerItem[6])
                .addDrawerItems(primaryDrawerItem[7])
                .addDrawerItems(primaryDrawerItem[8])
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(Base)


                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        boolean check=true;
                        drawer.closeDrawer();
                        switch (position)
                        {
                            case 1:
                            {
                                NavigationHelper.LaunchFragment(RoomsListView.getInsatance(),getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                getSupportActionBar().setTitle("Home");
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
                                    //AVPF.container.;
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
                                    //AVPF.container.getChildAt(1);
                                    NavigationHelper.LaunchFragment(AVPF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                }
                                check=false;
                                break;
                            }
                            case 4:
                            {
                                HotelsScreen HS=HotelsScreen.GetInstance();
                                NavigationHelper.LaunchFragment(HS,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                getSupportActionBar().setTitle("Hotels");
                                check=false;
                                break;
                            }
                            case 6:
                            {
                                BookingScreen BS=BookingScreen.GetInstance();
                                NavigationHelper.LaunchFragment(BS,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                getSupportActionBar().setTitle("Booking");
                                check=false;
                                break;
                            }
                            case 7:
                            {
                                ContactUsFragment CUF=ContactUsFragment.GetInstance();
                                NavigationHelper.LaunchFragment(CUF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                check=false;
                                getSupportActionBar().setTitle("Contact Us");
                                break;
                            }
                            case 8:
                            {
                                AboutUsFragment AUF=AboutUsFragment.GetInstance();
                                NavigationHelper.LaunchFragment(AUF,getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
                                getSupportActionBar().setTitle("About Us");
                                check=false;
                                break;
                            }
                            case 10:
                            {
                                NavigationHelper.LaunchSignInScreen(LoginScreen.this);
                            }
                        }

                        view.setBackgroundColor(ColorUtil.getColor(R.color.MyColor));
                        return check;
                    }
                })
                .build();

    }

}
