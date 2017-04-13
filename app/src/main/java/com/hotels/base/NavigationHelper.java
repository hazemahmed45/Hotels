package com.hotels.base;

import android.app.Activity;
import android.content.Intent;

import com.hotels.features.main.activities.Login.LoginScreen;

/**
 * Created by ahmed on 13/04/17.
 */

public class NavigationHelper {
    public static void launchLoginScreen(Activity activity){
        activity.startActivity(new Intent(activity,LoginScreen.class));
    }
}
