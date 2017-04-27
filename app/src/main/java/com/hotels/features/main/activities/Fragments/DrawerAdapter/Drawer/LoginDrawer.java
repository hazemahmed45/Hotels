package com.hotels.features.main.activities.Fragments.DrawerAdapter.Drawer;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotels.R;
import com.hotels.base.BaseDrawer;

/**
 * Created by Hazem on 4/26/2017.
 */

public class LoginDrawer extends BaseDrawer {
    LayoutInflater inflater;
    public LoginDrawer(AppCompatActivity activity) {
        super(activity);
        inflater=LayoutInflater.from(activity);
    }

    @Override
    public Viewholder getViewHolder(ViewGroup parent) {

        View view=inflater.inflate(R.layout.drawer_logout,parent,false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }
}
