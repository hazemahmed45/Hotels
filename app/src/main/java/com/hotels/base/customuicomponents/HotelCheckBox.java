package com.hotels.base.customuicomponents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.hotels.utils.Fonts;

/**
 * Created by Hazem on 4/24/2017.
 */

public class HotelCheckBox extends android.support.v7.widget.AppCompatCheckBox {
    private static Typeface typeface;
    public HotelCheckBox(Context context) {
        super(context);
        if(typeface==null)
        {
            typeface=Typeface.createFromAsset(context.getAssets(), Fonts.RegularGothic);
        }
        setTypeface(typeface);
    }

    public HotelCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(typeface==null)
        {
            typeface=Typeface.createFromAsset(context.getAssets(), Fonts.RegularGothic);
        }
        setTypeface(typeface);
    }

    public HotelCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(typeface==null)
        {
            typeface=Typeface.createFromAsset(context.getAssets(), Fonts.RegularGothic);
        }
        setTypeface(typeface);
    }
}
