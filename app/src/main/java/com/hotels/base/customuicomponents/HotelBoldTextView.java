package com.hotels.base.customuicomponents;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hotels.utils.Fonts;

/**
 * Created by Hazem on 4/24/2017.
 */

public class HotelBoldTextView extends android.support.v7.widget.AppCompatTextView {

    private static Typeface font;
    public HotelBoldTextView(Context context) {
        super(context);
        if (font == null) {
            font = Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(font);
        }
    }

    public HotelBoldTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (font == null) {
            font = Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(font);
        }
    }

    public HotelBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (font == null) {
            font = Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(font);
        }
    }


}
