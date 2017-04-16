package com.hotels.utils;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.hotels.R;
import com.hotels.base.HotelsApplication;

/**
 * Created by Hazem on 4/16/2017.
 */

public class ColorUtil {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static int getColor(int Id)
    {
        return HotelsApplication.get().getColor(Id);
    }
}
