package com.hotels.features.main.activities.Activities.Login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.hotels.utils.NavigationHelper;
import com.hotels.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInScreen extends AppCompatActivity {

    @BindView(R.id.user_signin_emaillayout_edittext)TextInputLayout EmailTextInputLayout;
    @BindView(R.id.user_signin_passwordlayout_edittext)TextInputLayout PasswordTextInputLayout;
    @BindView(R.id.user_signin_password_edittext)EditText EmailEditText;
    @BindView(R.id.user_signin_email_edittext)EditText PasswordEditText;
    @OnClick(R.id.user_signin_signup_button)void SignUpButtonClickedTwo()
    {
        NavigationHelper.LaunchSignUpScreen(SignInScreen.this);
        finish();

    }
    @OnClick(R.id.user_signin_signin_button)void SigninButtonClickedTwo()
    {
        if(isValidEmail() || isValidPassword())
        {
            NavigationHelper.launchLoginScreen(SignInScreen.this);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_screen_activity);
        ButterKnife.bind(SignInScreen.this);
    }
    private boolean isValidEmail()
    {
        if(EmailEditText.getText().toString().trim().isEmpty())
        {
            EmailTextInputLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            EmailTextInputLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isValidPassword()
    {
        if(PasswordEditText.getText().toString().trim().isEmpty())
        {
            PasswordTextInputLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            PasswordTextInputLayout.setErrorEnabled(false);
        }
        return true;
    }
}
