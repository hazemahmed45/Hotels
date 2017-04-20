package com.hotels.features.main.activities.Fragments.ViewPager.Account;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotels.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountPointSystemFragment extends Fragment {


    public AccountPointSystemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.account_point_system_fragment, container, false);
        return view;
    }

}
