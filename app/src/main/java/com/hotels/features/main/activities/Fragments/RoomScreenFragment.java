package com.hotels.features.main.activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hotels.R;
import com.hotels.base.constants.NavConstants;
import com.hotels.features.main.activities.RoomAdapter.RoomFlipperAdapter;
import com.hotels.model.Rooms;
import com.hotels.utils.NavigationHelper;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomScreenFragment extends Fragment {

    @BindView(R.id.room_image_flipper)AdapterViewFlipper Flipper;
    @BindView(R.id.room_name)TextView name;
    @BindView(R.id.room_price) TextView price;
    @BindView(R.id.room_desc)TextView desc;
    @BindView(R.id.room_capacity) TextView capacity;
    @BindView(R.id.room_luxory) TextView luxory;
    Rooms room;
    @OnClick(R.id.room_check_in)void CheckInButtonClicked()
    {
        NavigationHelper.LaunchFragment(new BookingScreen(),((AppCompatActivity)RoomScreenFragment.this.getActivity()).getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
    }
    @OnClick(R.id.room_vr)void RoomVRButtonClicked()
    {
        NavigationHelper.LaunchFragment(new VrRoom(),((AppCompatActivity)RoomScreenFragment.this.getActivity()).getSupportFragmentManager(),R.id.FrameLayoutLoginScreen);
    }
    RoomFlipperAdapter adapter;
    public RoomScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.room_screen_fragment,container,false);
        ButterKnife.bind(this,view);

        Bundle bundle=RoomScreenFragment.this.getArguments();
        if(bundle!=null)
        {
            room= (Rooms) bundle.getSerializable(NavConstants.RoomsBundleKey);
            name.setText(room.getName());
            price.setText("From: "+room.getPrice()+" /night");
            desc.setText(room.getDesc());
            capacity.setText("Capacity: "+room.getCapacity());
            luxory.setText(room.getLuxory());
            adapter=new RoomFlipperAdapter(room.getRoomImage(),RoomScreenFragment.this.getContext(),this.getActivity());

        }

        Flipper.setAdapter(adapter);

        Flipper.setFlipInterval(2000);
        Flipper.setAutoStart(true);

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        YoYo.with(Techniques.SlideInLeft).duration(500).playOn(this.getView());
    }
    @Override
    public void onPause() {
        super.onPause();
        Flipper.stopFlipping();
        room=null;
    }
}
