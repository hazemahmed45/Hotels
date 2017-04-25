package com.hotels.features.main.activities.Fragments.ViewPager.Account;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotels.R;
import com.hotels.model.User;
import com.hotels.utils.ColorUtil;
import com.triggertrap.seekarc.SeekArc;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountPointSystemFragment extends Fragment {


    public AccountPointSystemFragment() {
        // Required empty public constructor
    }
    private static AccountPointSystemFragment accountPointSystemFragment;
    public static AccountPointSystemFragment getInstance()
    {
        if(accountPointSystemFragment==null)
        {
            accountPointSystemFragment=new AccountPointSystemFragment();
        }
        return accountPointSystemFragment;
    }
    @BindView(R.id.number_nights)TextView NumberNights;
    @BindView(R.id.number_stays)TextView NumberStays;
    @BindView(R.id.seekbar_perc)TextView SeekBarPerc;
    @BindView(R.id.number_points)TextView NumberPoints;
    @BindView(R.id.points_seekbar)SeekArc PointsSeekArc;
    @BindView(R.id.user_points)TextView PointsMessage;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.account_point_system_fragment, container, false);
        ButterKnife.bind(this,view);
        NumberNights.setText(User.getUser().getNights()+"");
        NumberPoints.setText(User.getUser().getPoints()+"");
        NumberStays.setText(User.getUser().getStays()+"");
        PointsSeekArc.setEnabled(false);
        PointsSeekArc.setProgress((int) User.getUser().getPoints());
        SeekBarPerc.setText(User.getUser().getPoints()+"%");
        PointsMessage.setText("You Have "+User.getUser().getPoints()+" Points");
        return view;
    }

}
