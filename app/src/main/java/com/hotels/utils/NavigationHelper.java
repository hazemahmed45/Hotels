package com.hotels.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hotels.features.main.activities.Activities.Login.LoginScreen;
import com.hotels.features.main.activities.Activities.Login.SignInScreen;
import com.hotels.features.main.activities.Activities.Login.SignUpScreen;

/**
 * Created by ahmed on 13/04/17.
 */

public class NavigationHelper {
    public static void launchLoginScreen(Activity activity){
        activity.startActivity(new Intent(activity,LoginScreen.class));
    }
    public static void LaunchSignInScreen(Activity activity)
    {
        activity.startActivity(new Intent(activity,SignInScreen.class));
    }
    public static void LaunchSignUpScreen(Activity activity)
    {
        activity.startActivity(new Intent(activity, SignUpScreen.class));
    }
    public static void LaunchFragment(Fragment fragment, FragmentManager fragmentManager, int ResLayout)
    {
        FragmentTransaction FT=fragmentManager.beginTransaction();
        FT.replace(ResLayout,fragment);
        FT.commit();
    }
    public static void LaunchFragment(Fragment fragment, FragmentManager fragmentManager, int ResLayout, Bundle bundle)
    {
        FragmentTransaction FT=fragmentManager.beginTransaction();
        FT.replace(ResLayout,fragment);
        fragment.setArguments(bundle);
        FT.commit();
    }
}
