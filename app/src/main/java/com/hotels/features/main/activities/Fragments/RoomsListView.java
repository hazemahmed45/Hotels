package com.hotels.features.main.activities.Fragments;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.base.constants.NavConstants;
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

    @BindView(R.id.rooms_listview)ListView listView;
    RoomAdapter adapter;
    ArrayList<Rooms>rooms;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rooms_list_view_fragment, container, false);
        ButterKnife.bind(this,view);

        rooms=new ArrayList<>();
        rooms.add(new Rooms("hazem","120",2,"this room is spacious","comes with a pool"));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.mipmap.ic_launcher));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.listviewwithimage));
        rooms.get(rooms.size()-1).getRoomImage().add(BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.drawable.progressbar));
        rooms.add(new Rooms("hazem","120",2,"this room is spacious","comes with a pool"));
        rooms.add(new Rooms("hazem","120",2,"this room is spacious","comes with a pool"));
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

}
