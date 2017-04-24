package com.hotels.features.main.activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotels.R;
import com.hotels.base.BaseFragment;
import com.hotels.model.User;
import com.hotels.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeScreen extends BaseFragment {

    public HomeScreen() {
        // Required empty public constructor
    }
    @BindView(R.id.welcom_text)TextView welcomeText;
    @BindView(R.id.points_text)TextView MyPoints;
    @OnClick(R.id.home_search_button)void SearchRoomsButtonClicked()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.home_screen_fragment, container, false);
        ButterKnife.bind(this,view);
        welcomeText.setText(StringUtil.getStringRes(R.string.welcome_text)+" "+User.getUser().getFirstName());
        MyPoints.setText(StringUtil.getStringRes(R.string.my_points)+": "+User.getUser().getPoints());
        return view;
    }

}
