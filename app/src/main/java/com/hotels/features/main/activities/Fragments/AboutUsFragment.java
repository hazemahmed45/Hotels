package com.hotels.features.main.activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.about_us_paragraph)TextView paragraph;
    @OnClick(R.id.about_us_facebook)void FacebookButtonCliked()
    {

    }
    @OnClick(R.id.about_us_twitter)void TwitterButtonCliked()
    {

    }
    @OnClick(R.id.about_us_instgram)void InstgramButtonCliked()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.about_us_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        YoYo.with(Techniques.SlideInLeft).duration(500).playOn(this.getView());
    }
}
