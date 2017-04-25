package com.hotels.features.main.activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hotels.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.about_us_paragraph)TextView paragraph;
    @OnClick(R.id.about_us_facebook)void FacebookButtonClikec()
    {

    }
    @OnClick(R.id.about_us_twitter)void TwitterButtonClikec()
    {

    }
    @OnClick(R.id.about_us_instgram)void InstgramButtonClikec()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.about_us_fragment, container, false);
    }

}
