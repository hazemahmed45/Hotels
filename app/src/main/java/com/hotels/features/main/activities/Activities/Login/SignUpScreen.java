package com.hotels.features.main.activities.Activities.Login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.hotels.R;
import com.hotels.model.User;
import com.hotels.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpScreen extends AppCompatActivity {
    User user;
    //EditTexts
    @BindView(R.id.user_signup_email_editext)EditText email;
    @BindView(R.id.user_signup_confirmpassword_editext)EditText confirmPassword;
    @BindView(R.id.user_signup_firstname_editext)EditText firstName;
    @BindView(R.id.user_signup_lastname_editext)EditText lastName;
    @BindView(R.id.user_signup_password_editext)EditText password;
    @BindView(R.id.user_signup_phone_editext)EditText phone;
    /***********/
    //TextInputLayouts
    @BindView(R.id.user_signup_confirmpasswordlayout_editext)TextInputLayout confirmPasswordLayout;
    @BindView(R.id.user_signup_emaillayout_editext)TextInputLayout emailLayout;
    @BindView(R.id.user_signup_firstnamelayout_editext)TextInputLayout firstNameLayout;
    @BindView(R.id.user_signup_lastnamelayout_editext)TextInputLayout lastNameLayout;
    @BindView(R.id.user_signup_phonelayout_editext)TextInputLayout phoneLayout;
    @BindView(R.id.user_signup_passwordlayout_editext)TextInputLayout passwordLayout;
    /***********/
    @OnClick(R.id.user_signup_signup_button)void SignUpButtonClikcedThree()
    {
        boolean CP=isEmptyConfirmPassword(),E=isEmptyEmail(),FN=isEmptyFirstName(),LN=isEmptyLastName(),P=isEmptyPassword(),PH=isEmptyPhone();
        if(CP && E && FN && LN && P && PH)
        {
            if(password.getText().toString().equals(confirmPassword.getText().toString()))
            {
                User.getUser().setEmail(email.getText().toString());
                User.getUser().setPassword(password.getText().toString());
                User.getUser().setFirstName(firstName.getText().toString());
                User.getUser().setLastName(lastName.getText().toString());
                User.getUser().setPhone(phone.getText().toString());
                finish();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_screen_activity);
        ButterKnife.bind(this);
    }

    private boolean isEmptyFirstName()
    {
        if(firstName.getText().toString().trim().isEmpty())
        {
            firstNameLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            firstNameLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isEmptyLastName()
    {
        if(lastName.getText().toString().trim().isEmpty())
        {
            lastNameLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            lastNameLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isEmptyEmail()
    {
        if(email.getText().toString().trim().isEmpty())
        {
            emailLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            emailLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isEmptyPhone()
    {
        if(phone.getText().toString().trim().isEmpty())
        {
            phoneLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            phoneLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isEmptyPassword()
    {
        if(password.getText().toString().trim().isEmpty())
        {
            passwordLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            passwordLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isEmptyConfirmPassword()
    {
        if(confirmPassword.getText().toString().trim().isEmpty())
        {
            confirmPasswordLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else if(confirmPassword.getText().toString().trim().equals(password.getText().toString().trim())==false)
        {
            confirmPasswordLayout.setError(StringUtil.getStringRes(R.string.error_wrongpass));
            return false;
        }
        else
        {
            confirmPasswordLayout.setErrorEnabled(false);
        }
        return true;
    }

}
