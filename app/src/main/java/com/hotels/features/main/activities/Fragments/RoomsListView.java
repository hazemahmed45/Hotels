package com.hotels.features.main.activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hotels.R;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rooms_list_view_fragment, container, false);
        ButterKnife.bind(this,view);

        ArrayList<Rooms> rooms=new ArrayList<>();
        rooms.add(new Rooms("hazem","120",2,"this room is spacious"));
        rooms.add(new Rooms("hazem","120",2,"this room is spacious"));
        rooms.add(new Rooms("hazem","120",2,"this room is spacious"));
        adapter=new RoomAdapter(rooms,this.getContext().getApplicationContext(),this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }

}
