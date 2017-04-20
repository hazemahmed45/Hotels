package com.hotels.features.main.activities.Fragments.ViewPager.Account;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.hotels.R;
import com.hotels.model.User;
import com.hotels.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountEditAccountFragment extends Fragment {


    public AccountEditAccountFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.userinfo_firstname)EditText firstname;
    @BindView(R.id.userinfo_lastname)EditText lastname;
    @BindView(R.id.userinfo_phone)EditText phone;
    @BindView(R.id.userpassword_confirmpassword)EditText confirm;
    @BindView(R.id.userpassword_password)EditText password;
    @BindView(R.id.userinfo_firstname_layout)TextInputLayout firstnameLayout;
    @BindView(R.id.userinfo_lastname_layout)TextInputLayout lastnameLayout;
    @BindView(R.id.userinfo_phone_layout)TextInputLayout phoneLayout;
    @BindView(R.id.userpassword_confirmpassword_layout)TextInputLayout confirmLayout;
    @BindView(R.id.userpassword_password_layout)TextInputLayout passwordLayout;

    @OnClick(R.id.account_save_button)void SaveClicked()
    {
        boolean F=isEmptyFirstName(),L=isEmptyLastName(),PH=isEmptyPhone(),P=isEmptyPassword(),C=isEmptyConfirmPassword();
        if(F && L && PH && P && C)
        {
            User.getUser().setPassword(password.getText().toString());
            User.getUser().setPhone(phone.getText().toString());
            User.getUser().setFirstName(firstname.getText().toString());
            User.getUser().setLastName(lastname.getText().toString());
            Toast.makeText(this.getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.account_edit_account_fragment, container, false);
        ButterKnife.bind(this,view);
        firstname.setText(User.getUser().getFirstName());
        lastname.setText(User.getUser().getLastName());
        password.setText(User.getUser().getPassword());
        phone.setText(User.getUser().getPhone());
        return view;
    }
    private boolean isEmptyFirstName()
    {
        if(firstname.getText().toString().trim().isEmpty())
        {
            firstnameLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            firstnameLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isEmptyLastName()
    {
        if(lastname.getText().toString().trim().isEmpty())
        {
            lastnameLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            lastnameLayout.setErrorEnabled(false);
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
        if(confirm.getText().toString().trim().isEmpty())
        {
            confirmLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else if(confirm.getText().toString().trim().equals(password.getText().toString().trim())==false)
        {
            confirmLayout.setError(StringUtil.getStringRes(R.string.error_wrongpass));
            return false;
        }
        else
        {
            confirmLayout.setErrorEnabled(false);
        }
        return true;
    }
}
