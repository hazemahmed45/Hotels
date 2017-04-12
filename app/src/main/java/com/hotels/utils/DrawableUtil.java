package com.hotels.utils;

import android.graphics.drawable.Drawable;

import com.hotels.base.HotelsApplication;

/**
 * Created by mohamedelkhateeb on 1/16/17.
 */

public class DrawableUtil {

    public static Drawable getProperDrawable(int position) {
        Drawable drawable = HotelsApplication.get().getResources().getDrawable(HotelsApplication.get().getResources()
                .getIdentifier("cat_" + position, "drawable", HotelsApplication.get().getPackageName()));
        return drawable;
    }

}
