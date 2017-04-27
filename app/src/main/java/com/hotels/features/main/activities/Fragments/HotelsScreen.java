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
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.features.main.activities.Fragments.ViewPager.Hotel.HotelViewPagerAdapter;
import com.hotels.features.main.activities.Fragments.ViewPager.Hotel.HotelViewPagerFragment;
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

    @BindView(R.id.hotels_slider)SliderLayout viewPager;
    @BindView(R.id.hotels_text)TextView hotelDesc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.hotels_screen_fragment, container, false);
        ButterKnife.bind(this,view);
        hotelDesc.setText(StringUtil.getStringRes(R.string.paragraph));
        ArrayList<Integer> bitmaps=new ArrayList<>();
        bitmaps.add(R.drawable.progressbar);
        bitmaps.add(R.drawable.listviewwithimage);
        bitmaps.add(R.mipmap.ic_launcher);
        ArrayList<String> Names=new ArrayList<>();
        Names.add("Hotel 1");
        Names.add("Hotel 2");
        Names.add("Hotel 3");
        for (int i=0;i<bitmaps.size();i++)
        {
            TextSliderView textSliderView = new TextSliderView(this.getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(Names.get(i))
                    .image(bitmaps.get(i))
                    .setScaleType(BaseSliderView.ScaleType.Fit);


            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",Names.get(i));

            viewPager.addSlider(textSliderView);
        }

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        YoYo.with(Techniques.SlideInLeft).duration(500).playOn(this.getView());
    }
}
