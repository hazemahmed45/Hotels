package com.hotels.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hotels.R;
import com.hotels.utils.StringUtil;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class BaseActivity extends AppCompatActivity {
    public static final PrimaryDrawerItem[] primaryDrawerItem=
            {
                    new PrimaryDrawerItem().withIdentifier(1).withName(StringUtil.getStringRes(R.string.home)),
                    new PrimaryDrawerItem().withIdentifier(2).withName(StringUtil.getStringRes(R.string.my_points)),
                    new PrimaryDrawerItem().withIdentifier(3).withName(StringUtil.getStringRes(R.string.account)),
                    new PrimaryDrawerItem().withIdentifier(4).withName(StringUtil.getStringRes(R.string.hotel)),
                    new PrimaryDrawerItem().withIdentifier(5).withName(StringUtil.getStringRes(R.string.rooms)),
                    new PrimaryDrawerItem().withIdentifier(6).withName(StringUtil.getStringRes(R.string.gallery)),
                    new PrimaryDrawerItem().withIdentifier(7).withName(StringUtil.getStringRes(R.string.booking)),
                    new PrimaryDrawerItem().withIdentifier(8).withName(StringUtil.getStringRes(R.string.contact_us)),
                    new PrimaryDrawerItem().withIdentifier(9).withName(StringUtil.getStringRes(R.string.about_us)),
                    new PrimaryDrawerItem().withIdentifier(10).withName(StringUtil.getStringRes(R.string.sign_in)),
                    new PrimaryDrawerItem().withIdentifier(11).withName(StringUtil.getStringRes(R.string.log_out))
                            .withDescriptionTextColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                            .withDisabledIconColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    .withDisabledTextColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    .withIconColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    .withSelectedColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    .withSelectedIconColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    .withSelectedTextColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    .withTextColor(HotelsApplication.get().getResources().getColor(R.color.MyColor))
                    


            };

}
