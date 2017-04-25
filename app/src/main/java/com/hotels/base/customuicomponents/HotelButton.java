package com.hotels.base.customuicomponents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.hotels.utils.Fonts;

/**
 * Created by Hazem on 4/24/2017.
 */

public class HotelButton extends android.support.v7.widget.AppCompatButton
{
    private static Typeface typeface;
    public HotelButton(Context context) {
        super(context);
        if (typeface==null)
        {
            typeface=Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }
        setTypeface(typeface);
    }

    public HotelButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (typeface==null)
        {
            typeface=Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }
        setTypeface(typeface);
    }

    public HotelButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (typeface==null)
        {
            typeface=Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }
        setTypeface(typeface);
    }
}
