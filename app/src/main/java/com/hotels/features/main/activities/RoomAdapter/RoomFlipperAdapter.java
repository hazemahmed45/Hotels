package com.hotels.features.main.activities.RoomAdapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.model.Rooms;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Hazem on 4/18/2017.
 */

public class RoomFlipperAdapter extends BaseAdapter {
    ArrayList<Bitmap> RoomImages;
    Context context;
    LayoutInflater inflater;
    Activity activity;
    public RoomFlipperAdapter(ArrayList<Bitmap> rooms, Context c, Activity a) {
        this.RoomImages = rooms;
        context=c;
        activity=a;
        inflater=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return RoomImages.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView RoomView=new ImageView(context);
        RoomView.setScaleType(ImageView.ScaleType.FIT_XY);
        RoomView.setLayoutParams(new ImageSwitcher.LayoutParams(activity.getWindowManager().getDefaultDisplay().getWidth(), ViewGroup.LayoutParams.MATCH_PARENT));
        RoomView.setImageBitmap(RoomImages.get(i));

        return RoomView;

    }
}
