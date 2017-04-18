package com.hotels.utils;

import android.app.Activity;
import android.content.Intent;

import com.hotels.features.main.activities.Login.LoginScreen;
import com.hotels.features.main.activities.Login.SignInScreen;
import com.hotels.features.main.activities.Login.SignUpScreen;

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

}
