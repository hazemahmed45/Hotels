package com.hotels.base;

import android.app.Application;

/**
 * Created by ahmed on 12/04/17.
 */

public class HotelsApplication extends Application {


    private static HotelsApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static HotelsApplication get() {
        if (mInstance == null)
            // This should never happen, but just in case
            throw new IllegalStateException("Application instance has not been initialized!");
        return mInstance;
    }



}
