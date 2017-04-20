package com.hotels.features.main.activities.Fragments.ViewPager.Account;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountViewPagerFragment extends Fragment {


    public AccountViewPagerFragment() {
        // Required empty public constructor
    }
    @BindView(R.id.account_tablayout)TabLayout tabLayout;
    @BindView(R.id.account_viewpager)ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.account_view_pager_fragment, container, false);
        ButterKnife.bind(this,view);
        AccountViewPagerAdapter adapter=new AccountViewPagerAdapter(this.getFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
