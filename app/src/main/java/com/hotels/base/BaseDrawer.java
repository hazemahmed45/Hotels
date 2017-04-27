package com.hotels.base;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.customuicomponents.HotelButton;
import com.hotels.model.User;
import com.hotels.utils.NavigationHelper;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.materialdrawer.model.BaseDrawerItem;
import com.mikepenz.materialdrawer.model.BaseViewHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Hazem on 4/26/2017.
 */

public class BaseDrawer implements IDrawerItem<RecyclerView, BaseDrawer.Viewholder> {

    Context context;
    LayoutInflater inflater;
    Activity activity;
    public BaseDrawer(AppCompatActivity activity) {
        context=activity;

        inflater=LayoutInflater.from(activity);
        this.activity=activity;
    }

    @Override
    public Object getTag() {
        return null;
    }
    @Override
    public RecyclerView withTag(Object tag) {
        return null;
    }
    @Override
    public boolean isEnabled() {
        return false;
    }
    @Override
    public RecyclerView withEnabled(boolean enabled) {
        return null;
    }
    @Override
    public boolean isSelected() {
        return false;
    }
    @Override
    public RecyclerView withSetSelected(boolean selected) {
        return null;
    }
    @Override
    public boolean isSelectable() {
        return false;
    }
    @Override
    public RecyclerView withSelectable(boolean selectable) {
        return null;
    }
    @Override
    public int getType() {
        return 0;
    }
    @Override
    public int getLayoutRes() {
        return 0;
    }
    @Override
    public View generateView(Context ctx) {
        return null;
    }
    @Override
    public View generateView(Context ctx, ViewGroup parent) {
        return null;
    }



    @Override
    public Viewholder getViewHolder(ViewGroup parent) {

        return null;
    }




    @Override
    public void unbindView(Viewholder holder) {

    }
    @Override
    public void attachToWindow(Viewholder holder) {

    }
    @Override
    public void detachFromWindow(Viewholder holder) {

    }
    @Override
    public void bindView(Viewholder holder, List<Object> payloads) {

    }
    @Override
    public boolean equals(int id) {
        return false;
    }
    @Override
    public boolean equals(long id) {
        return false;
    }
    @Override
    public boolean isExpanded() {
        return false;
    }
    @Override
    public RecyclerView withIsExpanded(boolean collapsed) {
        return null;
    }
    @Override
    public RecyclerView withSubItems(List<IDrawerItem> subItems) {
        return null;
    }
    @Override
    public List getSubItems() {
        return null;
    }
    @Override
    public boolean isAutoExpanding() {
        return false;
    }
    @Override
    public RecyclerView withIdentifier(long identifier) {
        return null;
    }
    @Override
    public long getIdentifier() {
        return 0;
    }

    @Override
    public IDrawerItem getParent() {
        return null;
    }
    @Override
    public IDrawerItem withParent(IDrawerItem parent) {
        return null;
    }



    public class Viewholder extends BaseViewHolder
    {
        HotelButton SignIn;
        HotelButton SignUp;
        Button LogOut;
        public Viewholder(View view) {
            super(view);
            if(User.getUser().getEmail()==null)
            {
                SignIn= (HotelButton) view.findViewById(R.id.drawer_sign_in);
                SignUp= (HotelButton) view.findViewById(R.id.drawer_sign_up);
                SignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NavigationHelper.LaunchSignInScreen(activity);

                    }
                });
                SignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NavigationHelper.LaunchSignUpScreen(activity);
                    }
                });
            }
            else
            {
                LogOut= (Button) view.findViewById(R.id.drawer_logout_button);

                LogOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "this", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    }

}
