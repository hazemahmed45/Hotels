package com.hotels.features.main.activities.RoomAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hotels.R;
import com.hotels.model.Rooms;
import com.squareup.picasso.Picasso;

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

    Activity activity;
    int pos;
    ViewHolder viewHolder;
    public RoomAdapter(ArrayList<Rooms> rooms, AppCompatActivity c, Object o) {
        this.rooms = rooms;
        context=c;
        inflater=LayoutInflater.from(c);
        object=o;
        activity=c;
        pos=0;
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

        if (view == null) {
            view = inflater.inflate(R.layout.custom_listview_rooms, viewGroup, false);
            viewHolder=new ViewHolder();
            viewHolder.RoomImage= (ImageView) view.findViewById(R.id.room_main_image);
            viewHolder.RoomPrice= (TextView) view.findViewById(R.id.room_main_price);
            viewHolder.RoomName= (TextView) view.findViewById(R.id.room_main_name);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) view.getTag();
        }
        if(pos<=i)
        {
            YoYo.with(Techniques.FadeInUp).duration(500).playOn(view);
        }
        else
        {
            if(i%2==0)
            {
                YoYo.with(Techniques.FadeInUp).duration(500).playOn(view);
            }
            else
            {
                YoYo.with(Techniques.FadeInDown).duration(500).playOn(view);
            }

        }
        pos=i;
        Picasso.with(context).load(rooms.get(i).getRoomImage().get(0)).placeholder(R.mipmap.ic_launcher).into(viewHolder.RoomImage);
        viewHolder.RoomName.setText(rooms.get(i).getName());
        viewHolder.RoomPrice.setText("$ "+rooms.get(i).getPrice()+" / night");
        return view;
    }
    public static class ViewHolder
    {
        public ImageView RoomImage;
        public TextView RoomName;
        public TextView RoomPrice;
    }
}
