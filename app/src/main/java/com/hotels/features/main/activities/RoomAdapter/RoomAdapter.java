package com.hotels.features.main.activities.RoomAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotels.R;
import com.hotels.model.Rooms;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hazem on 4/17/2017.
 */

public class RoomAdapter extends BaseAdapter {
    ArrayList<Rooms> rooms;
    LayoutInflater inflater;
    Context context;
    Object object;
    ImageView RoomImage;
    TextView RoomName;
    TextView RoomPrice;

    public RoomAdapter(ArrayList<Rooms> rooms,Context c,Object o) {
        this.rooms = rooms;
        context=c;
        inflater=LayoutInflater.from(c);
        object=o;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int i) {
        return rooms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.custom_listview_rooms,viewGroup,false);
        RoomImage= (ImageView) view.findViewById(R.id.room_main_image);
        RoomPrice= (TextView) view.findViewById(R.id.room_main_price);
        RoomName= (TextView) view.findViewById(R.id.room_main_name);
//        if(rooms.get(i).getRoomImage()==null)
//        {
            RoomImage.setImageResource(R.mipmap.ic_launcher);
//        }
//        else
//        {
//            RoomImage.setImageBitmap(rooms.get(i).getRoomImage().get(0));
//        }
        RoomName.setText(rooms.get(i).getName());
        RoomPrice.setText("$ "+rooms.get(i).getPrice()+" / night");
        return view;
    }
}
