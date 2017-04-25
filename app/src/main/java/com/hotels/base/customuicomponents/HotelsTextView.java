package com.hotels.base.customuicomponents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hotels.base.HotelsApplication;
import com.hotels.utils.Fonts;


public class HotelsTextView extends android.support.v7.widget.AppCompatTextView {

    /*
     * Caches typefaces based on their file path and name, so that they don't have to be created every time when they are referenced.
     */
    private static Typeface mTypeface;

    public HotelsTextView(final Context context) {
        this(context, null);
    }

    public HotelsTextView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HotelsTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), Fonts.RegularGothic);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(mTypeface);
        }
    }

}