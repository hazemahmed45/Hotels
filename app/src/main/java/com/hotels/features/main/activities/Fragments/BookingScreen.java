package com.hotels.features.main.activities.Fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.constants.NavConstants;
import com.hotels.model.Rooms;
import com.hotels.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingScreen extends Fragment {


    public BookingScreen() {
        // Required empty public constructor
    }

    @BindView(R.id.booking_adult_spinner)Spinner AdultSpinner;
    @BindView(R.id.booking_child_spinner)Spinner ChildSpinner;
    @BindView(R.id.booking_room_spinner)Spinner RoomSpinner;
    @BindView(R.id.booking_using_points)CheckBox UsingPointsCheckBox;
    @BindView(R.id.booking_points_system)TextView UserPoints;
    @BindView(R.id.booking_checkout_edittext)EditText CheckOut;
    @BindView(R.id.booking_checkin_edittext)EditText CheckIn;
    @OnClick(R.id.booking_checkin_edittext)void CheckInClicked()
    {
        Data=SetDataPickerDialog(CheckIn);
        new DatePickerDialog(BookingScreen.this.getContext(), Data, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
//        String myFormat = "MM/dd/yy"; //In which you need put here
//        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//
//        CheckIn.setText(sdf.format(calendar.getTime()));
    }
    @OnClick(R.id.booking_checkout_edittext)void CheckOutClicked()
    {
        Data=SetDataPickerDialog(CheckOut);
        new DatePickerDialog(BookingScreen.this.getContext(), Data, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();


    }
    @OnClick(R.id.booking_button)void BookingRoom()
    {

    }
    DatePickerDialog.OnDateSetListener Data;
    Calendar calendar;
    Rooms room;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.booking_screen_fragment, container, false);
        ButterKnife.bind(this,v);
        calendar=Calendar.getInstance();
        if(User.getUser().getEmail()!=null)
        {
            UserPoints.setText("You have "+ User.getUser().getPoints()+" points");
        }
        else
        {
            UserPoints.setText("Sign up to use points and to book a room");
        }
        Bundle bundle=this.getArguments();
        if(bundle!=null)
        {
            room= (Rooms) bundle.getSerializable(NavConstants.RoomsBundleKey);
        }
        AdultSpinner.setAdapter(CreatingAdapter(R.array.adult_array));
        ChildSpinner.setAdapter(CreatingAdapter(R.array.child_array));
        RoomSpinner.setAdapter(CreatingAdapter(R.array.rooms_array));

        return v;
    }
    private ArrayAdapter<CharSequence> CreatingAdapter(int StringArray)
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), StringArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    private DatePickerDialog.OnDateSetListener SetDataPickerDialog(final EditText editText)
    {
        Data=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editText.setText(sdf.format(calendar.getTime()));
            }

        };
        return Data;
    }
}
