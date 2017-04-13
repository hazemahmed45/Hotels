package com.hotels.features.main.activities.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.utils.StringUtil;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginScreen extends AppCompatActivity {

    Drawer drawer;
    @BindView(R.id.login_toolbar) Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen_activity);
        ButterKnife.bind(this);
        PrimaryDrawerItem[] primaryDrawerItem=
                {
                        new PrimaryDrawerItem().withIdentifier(1).withName(StringUtil.getStringRes(R.string.home)),
                        new PrimaryDrawerItem().withIdentifier(2).withName(StringUtil.getStringRes(R.string.my_points)),
                        new PrimaryDrawerItem().withIdentifier(3).withName(StringUtil.getStringRes(R.string.account)),
                        new PrimaryDrawerItem().withIdentifier(4).withName(StringUtil.getStringRes(R.string.hotel)),
                        new PrimaryDrawerItem().withIdentifier(5).withName(StringUtil.getStringRes(R.string.rooms)),
                        new PrimaryDrawerItem().withIdentifier(6).withName(StringUtil.getStringRes(R.string.gallery)),
                        new PrimaryDrawerItem().withIdentifier(7).withName(StringUtil.getStringRes(R.string.booking)),
                        new PrimaryDrawerItem().withIdentifier(8).withName(StringUtil.getStringRes(R.string.about_us))
                };

        drawer=new DrawerBuilder()
                .withActivity(LoginScreen.this)
                .withToolbar(toolbar)
                .addDrawerItems(primaryDrawerItem[0])
                .addDrawerItems(primaryDrawerItem[1])
                .addDrawerItems(primaryDrawerItem[2])
                .addDrawerItems(primaryDrawerItem[3])
                .addDrawerItems(primaryDrawerItem[4])
                .addDrawerItems(primaryDrawerItem[5])
                .addDrawerItems(primaryDrawerItem[6])
                .addDrawerItems(primaryDrawerItem[7])
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Toast.makeText(LoginScreen.this, position+"", Toast.LENGTH_SHORT).show();
                        return true ;
                    }
                })
                .build();
    }
}
