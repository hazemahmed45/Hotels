package com.hotels.features.main.activities.Fragments;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.base.constants.NavConstants;
import com.hotels.features.main.activities.Activities.Login.LoginScreen;
import com.hotels.features.main.activities.RoomAdapter.RoomAdapter;
import com.hotels.model.Rooms;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomsListView extends Fragment {


    public RoomsListView() {
        // Required empty public constructor
    }

    @BindView(R.id.rooms_listview)ObservableListView listView;
    RoomAdapter adapter;
    ArrayList<Rooms>rooms;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rooms_list_view_fragment, container, false);
        ButterKnife.bind(this,view);

        listView.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
            @Override
            public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

            }

            @Override
            public void onDownMotionEvent() {

            }

            @Override
            public void onUpOrCancelMotionEvent(ScrollState scrollState) {

                if (scrollState == ScrollState.UP) {
                    if (((AppCompatActivity)RoomsListView.this.getActivity()).getSupportActionBar().isShowing()) {
                        ((AppCompatActivity)RoomsListView.this.getActivity()).getSupportActionBar().hide();
                    }
                } else if (scrollState == ScrollState.DOWN) {
                    if (!(((AppCompatActivity)RoomsListView.this.getActivity()).getSupportActionBar().isShowing())) {
                        ((AppCompatActivity)RoomsListView.this.getActivity()).getSupportActionBar().show();
                    }
                }
            }
        });
        rooms=new ArrayList<>();
        rooms.add(new Rooms("Deluxe Double Bedroom","145",2,"Apartment Size: 24 m²\n" +
                "\n" +
                "Decorated in elegant tones, this air-conditioned apartment offers free Wi-Fi, a living room with a flat-screen TV and a kitchen complete with a microwave and an oven. The bathroom is fitted with a bath and a shower.\n" +
                "\n" +
                "Apartment Facilities: Safe, Air conditioning, Iron, Sitting area, Sofa, Tile/Marble floor, Wardrobe/Closet, Shower, Hairdryer, Toilet, Bathroom, Telephone, Satellite channels, Flat-screen TV, Refrigerator, Microwave, Kitchen, Electric kettle, Oven\n" +
                "\n" +
                "Free WiFi is available in all \n","Breakfast included"));

        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.mipmap.ic_launcher));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.listviewwithimage));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.progressbar));
        rooms.add(new Rooms("Luxury suite","390 ",5,"Private bathroom\n" +
                "Apartment Size: 38 m²\n" +
                "\n" +
                "Decorated in elegant tones, this air-conditioned apartment offers free Wi-Fi, a living room with a flat-screen TV and a kitchen complete with a microwave and an oven. The bathroom is fitted with a bath and a shower.\n" +
                "\n" +
                "Apartment Facilities: Safe, Air conditioning, Iron, Sitting area, Sofa, Tile/Marble floor, Wardrobe/Closet, Shower, Hairdryer, Toilet, Bathroom, Telephone, Satellite channels, Flat-screen TV, Refrigerator, Microwave, Kitchen, Electric kettle, Oven\n" +
                "\n" +
                "Free WiFi is available in all \n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.mipmap.ic_launcher));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.listviewwithimage));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.progressbar));

        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.mipmap.ic_launcher));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.listviewwithimage));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.progressbar));

        adapter=new RoomAdapter(rooms,this.getContext().getApplicationContext(),this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RoomScreenFragment RS=new RoomScreenFragment();
                Bundle bundle=new Bundle();
                bundle.putSerializable(NavConstants.RoomsBundleKey,rooms.get(i));
                RS.setArguments(bundle);
                FragmentTransaction FT=RoomsListView.this.getActivity().getSupportFragmentManager().beginTransaction();
                FT.replace(R.id.FrameLayoutLoginScreen,RS);
                FT.commit();
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        ((AppCompatActivity)RoomsListView.this.getActivity()).getSupportActionBar().show();
    }
}
