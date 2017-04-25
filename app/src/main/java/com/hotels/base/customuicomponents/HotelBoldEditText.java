package com.hotels.base.customuicomponents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.hotels.utils.Fonts;

/**
 * Created by Hazem on 4/24/2017.
 */

public class HotelBoldEditText extends android.support.v7.widget.AppCompatEditText {

    private static Typeface mTypeface;
    public HotelBoldEditText(Context context) {
        super(context);
        if(mTypeface==null)
        {
            mTypeface=Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }

        setTypeface(mTypeface);
    }

    public HotelBoldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(mTypeface==null)
        {
            mTypeface=Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }

        setTypeface(mTypeface);
    }

    public HotelBoldEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(mTypeface==null)
        {
            mTypeface=Typeface.createFromAsset(context.getAssets(), Fonts.BoldGothic);
        }

        setTypeface(mTypeface);
    }
}
