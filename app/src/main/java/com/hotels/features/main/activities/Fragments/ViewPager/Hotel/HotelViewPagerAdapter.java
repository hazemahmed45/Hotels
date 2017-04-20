package com.hotels.features.main.activities.Fragments.ViewPager.Hotel;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hotels.base.constants.PrefConstants;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by Hazem on 4/20/2017.
 */

public class HotelViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Bitmap> Bit;
    ArrayList<String> Names;
    public HotelViewPagerAdapter(FragmentManager fm, ArrayList<Bitmap> bitmaps, ArrayList<String> names) {
        super(fm);
        Bit=bitmaps;
        Names=names;
    }

    @Override
    public Fragment getItem(int i) {
        for (int index=0;index<Bit.size();index++)
        {
            if(i==index)
            {
                HotelViewPagerFragment VPF=new HotelViewPagerFragment();
                Bundle bundle=new Bundle();
                ByteArrayOutputStream baos=new  ByteArrayOutputStream();
                Bit.get(index).compress(Bitmap.CompressFormat.PNG,100, baos);
                byte [] b=baos.toByteArray();
//                int bytesNumber=Bit.get(index).getAllocationByteCount();
//                ByteBuffer buffer=ByteBuffer.allocate(bytesNumber);
//                Bit.get(index).copyPixelsFromBuffer(buffer);
//                byte[] bytes=buffer.array();
                bundle.putByteArray(PrefConstants.ViewPagerImageKey,b);
                bundle.putString(PrefConstants.ViewPagerStringKey,Names.get(index));
                VPF.setArguments(bundle);
                return VPF;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return Bit.size();
    }
}
