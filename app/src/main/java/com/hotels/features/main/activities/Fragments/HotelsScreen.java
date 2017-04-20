package com.hotels.features.main.activities.Fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.features.main.activities.Fragments.ViewPager.Hotel.HotelViewPagerAdapter;
import com.hotels.utils.StringUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsScreen extends Fragment {


    public HotelsScreen() {
        // Required empty public constructor
    }

    @BindView(R.id.hotels_slider)ViewPager viewPager;
    @BindView(R.id.hotels_text)TextView hotelDesc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.hotels_screen_fragment, container, false);
        ButterKnife.bind(this,view);
        hotelDesc.setText(StringUtil.getStringRes(R.string.paragraph));
        ArrayList<Bitmap> bitmaps=new ArrayList<>();
        bitmaps.add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.progressbar));
        bitmaps.add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.listviewwithimage));
        bitmaps.add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.mipmap.ic_launcher));
        ArrayList<String> Names=new ArrayList<>();
        Names.add("Hotel 1");
        Names.add("Hotel 2");
        Names.add("Hotel 3");

        HotelViewPagerAdapter adapter=new HotelViewPagerAdapter(this.getFragmentManager(), bitmaps , Names );
        viewPager.setAdapter(adapter);
        return view;
    }

}
