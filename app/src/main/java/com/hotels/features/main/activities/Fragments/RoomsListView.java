package com.hotels.features.main.activities.Fragments;


import android.animation.Animator;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.ksoichiro.android.observablescrollview.ObservableGridView;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.base.constants.NavConstants;
import com.hotels.features.main.activities.Activities.Login.LoginScreen;
import com.hotels.features.main.activities.RoomAdapter.RoomAdapter;
import com.hotels.model.Rooms;
import com.hotels.utils.NavigationHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomsListView extends Fragment {


    public RoomsListView() {
        rooms=new ArrayList<>();
        rooms.add(new Rooms("Deluxe Double Bedroom","145",2,"Apartment Size: 24 m²\n" +
                "\n" +
                "Decorated in elegant tones, this air-conditioned apartment offers free Wi-Fi, a living room with a flat-screen TV and a kitchen complete with a microwave and an oven. The bathroom is fitted with a bath and a shower.\n" +
                "\n" +
                "Apartment Facilities: Safe, Air conditioning, Iron, Sitting area, Sofa, Tile/Marble floor, Wardrobe/Closet, Shower, Hairdryer, Toilet, Bathroom, Telephone, Satellite channels, Flat-screen TV, Refrigerator, Microwave, Kitchen, Electric kettle, Oven\n" +
                "\n" +
                "Free WiFi is available in all \n","Breakfast included"));

        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/37/twin-room.jpg");
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/44/snam-double-room-1.jpg");
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/45/snam-royal-suit-4.jpg");
        rooms.add(new Rooms("Luxury suite","390 ",5,"Private bathroom\n" +
                "Apartment Size: 38 m²\n" +
                "\n" +
                "Decorated in elegant tones, this air-conditioned apartment offers free Wi-Fi, a living room with a flat-screen TV and a kitchen complete with a microwave and an oven. The bathroom is fitted with a bath and a shower.\n" +
                "\n" +
                "Apartment Facilities: Safe, Air conditioning, Iron, Sitting area, Sofa, Tile/Marble floor, Wardrobe/Closet, Shower, Hairdryer, Toilet, Bathroom, Telephone, Satellite channels, Flat-screen TV, Refrigerator, Microwave, Kitchen, Electric kettle, Oven\n" +
                "\n" +
                "Free WiFi is available in all \n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/38/luxury-suite.jpg");
//        rooms.get(rooms.size()-1).getRoomImage().add();
//        rooms.get(rooms.size()-1).getRoomImage().add();

        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");
        rooms.add(new Rooms("Royal suite","1,500",5,"Private bathroom\n" +
                "\n" +
                "Room Size: 60 m²\n" +
                "\n" +
                "Featuring a modern design and free Wi-Fi, this spacious, air-conditioned suite has a bedroom and 2 flat-screen satellite TVs. It offers a kitchenette, dining area and living room. A bath and shower are fitted in the private bathroom.\n" +
                "\n" +
                "Room Facilities: Safe, Air conditioning, Iron, Ironing facilities, Sitting area, Walk-in closet, Carpeted, Sofa, Hardwood/Parquet floors, Wardrobe/Closet, Shower, Bathtub, Hairdryer, Bathrobe, Free toiletries, Toilet, Bathroom, Slippers, TV, Telephone, Satellite channels, Cable channels, Minibar, Refrigerator, Microwave, Kitchen, Dining area, Electric kettle, Kitchenware, Oven, Stovetop, Wake-up service, Alarm clock\n" +
                "\n" +
                "Free WiFi is available in all rooms.\n","Pool & Jacuzzi Suite"));
        rooms.get(rooms.size()-1).getRoomImage().add("http://hotelzzz.oneclick-sa.com/medias/room/big/39/royal-sonesta-new-orleans-bourbon-balcony-hospitality-suite.jpg");


    }

    private static RoomsListView mInsatance;
    public static RoomsListView getInsatance()
    {
        if(mInsatance==null)
        {
            mInsatance=new RoomsListView();
        }
        return mInsatance;
    }
    @BindView(R.id.rooms_listview)GridView listView;
    RoomAdapter adapter;
    ArrayList<Rooms>rooms;
    Toolbar toolbar;
    int first=0,now=0;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rooms_list_view_fragment, container, false);
        ButterKnife.bind(this,view);
        toolbar= (Toolbar) this.getActivity().findViewById(R.id.login_toolbar);

        adapter=new RoomAdapter(rooms,(AppCompatActivity)RoomsListView.this.getActivity(),this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle=new Bundle();
                bundle.putSerializable(NavConstants.RoomsBundleKey,rooms.get(i));
                NavigationHelper.LaunchFragment(new RoomScreenFragment(),((AppCompatActivity)RoomsListView.this.getActivity()).getSupportFragmentManager(),R.id.FrameLayoutLoginScreen,bundle);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //YoYo.with(Techniques.FadeIn).duration(1000).playOn(RoomsListView.this.getActivity().findViewById(R.id.rooms_listview));
    }

    @Override
    public void onPause() {
        super.onPause();
        if(toolbar.getVisibility()==View.GONE)
        {
            toolbar.setVisibility(View.VISIBLE);
            toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

}
