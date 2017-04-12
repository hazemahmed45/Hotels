package com.hotels.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hotels.base.HotelsApplication;


public class NetworkUtil {

    private NetworkUtil() {
    }

    private static ConnectivityManager connectivityManager() {
        return (ConnectivityManager) HotelsApplication.get().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static boolean isConnected() {
        ConnectivityManager connManager = connectivityManager();
        return connManager != null && connManager.getActiveNetworkInfo() != null
                && connManager.getActiveNetworkInfo().isConnected();
    }

    public static boolean isMobileNetworkConnected() {
        ConnectivityManager connManager = connectivityManager();

        if (connManager == null)
            return false;

        NetworkInfo info = connManager.getActiveNetworkInfo();
        return info != null && info.getType() == ConnectivityManager.TYPE_MOBILE
                && info.isConnected();
//        return true;
    }

}
