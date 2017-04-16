package com.hotels.features.main.activities.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotels.R;
import com.hotels.base.NavigationHelper;
import com.hotels.features.main.activities.Login.LoginScreen;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginScreenFragment extends Fragment {

    public LoginScreenFragment() {
        // Required empty public constructor
    }
//    public LoginScreenFragment(Activity activity) {
//        ac=activity;
//    }
    @OnClick(R.id.user_login_signin_button)void SignInButtonClicked()
    {
        NavigationHelper.LaunchSignInScreen(this.getActivity());
    }
    @OnClick(R.id.user_login_signup_button)void SignUpButtonClicked()
    {
        NavigationHelper.LaunchSignUpScreen(this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.login_screen_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

}
