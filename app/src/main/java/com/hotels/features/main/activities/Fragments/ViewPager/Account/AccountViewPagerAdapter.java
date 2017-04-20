package com.hotels.features.main.activities.Fragments.ViewPager.Account;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Hazem on 4/20/2017.
 */

public class AccountViewPagerAdapter extends FragmentPagerAdapter {

    public AccountViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
            {
                return new AccountPointSystemFragment();
            }
            case 1:
            {
                return new AccountEditAccountFragment();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
            {
                return "My Status";
            }
            case 1:
            {
                return "My Account";
            }
        }
        return super.getPageTitle(position);
    }
}
