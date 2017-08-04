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
        adapter=new AccountViewPagerAdapter(this.getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    @BindView(R.id.account_tablayout)TabLayout tabLayout;
    @BindView(R.id.account_viewpager)ViewPager viewPager;
    private static AccountViewPagerFragment accountViewPagerFragment;
    public static AccountViewPagerFragment getInstance()
    {
        if(accountViewPagerFragment==null)
        {
            accountViewPagerFragment=new AccountViewPagerFragment();
        }
        return accountViewPagerFragment;
    }
    LayoutInflater inflater;
    public ViewGroup container;
    Bundle SavedInst;
    AccountViewPagerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflater=inflater;
        this.container=container;
        SavedInst=savedInstanceState;
        View view=inflater.inflate(R.layout.account_view_pager_fragment, container, false);
        ButterKnife.bind(this,view);


        //viewPager.setOffscreenPageLimit(2);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
