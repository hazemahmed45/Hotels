package com.hotels.features.main.activities.Fragments.ViewPager.Hotel;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotels.R;
import com.hotels.base.constants.PrefConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelViewPagerFragment extends Fragment {


    public HotelViewPagerFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.hotel_image)public ImageView HotelImage;
    @BindView(R.id.hotel_name)public TextView HotelName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.view_pager_fragment, container, false);
        ButterKnife.bind(this,view);
        Bundle bundle=this.getArguments();
        if(bundle!=null)
        {
            byte[] bytes=bundle.getByteArray(PrefConstants.ViewPagerImageKey);
            Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            HotelImage.setImageBitmap(bitmap);
            HotelName.setText(bundle.getString(PrefConstants.ViewPagerStringKey));
        }
        return view;
    }

}
