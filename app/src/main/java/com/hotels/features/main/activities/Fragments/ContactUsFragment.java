package com.hotels.features.main.activities.Fragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hotels.R;
import com.hotels.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {


    public ContactUsFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.contact_us_email)EditText email;
    @BindView(R.id.contact_us_username)EditText username;
    @BindView(R.id.contact_us_code)EditText code;
    @BindView(R.id.contact_us_subject)EditText subject;
    @BindView(R.id.contact_us_comment)EditText comment;

    @BindView(R.id.contact_us_email_layout)TextInputLayout emailLayout;
    @BindView(R.id.contact_us_username_layout)TextInputLayout usernameLayout;
    @BindView(R.id.contact_us_code_layout)TextInputLayout codeLayout;
    @BindView(R.id.contact_us_subject_layout)TextInputLayout subjectLayout;
    @BindView(R.id.contact_us_comment_layout)TextInputLayout commentLayout;
    @OnClick(R.id.contact_us_button)void ContactUsButtonClicked()
    {
        if(isValidCode()||isValidComment()||isValidEmail()||isValidSubject()||isValidUsername())
        {
            Toast.makeText(ContactUsFragment.this.getContext(), "all Valid", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.contact_us_fragment, container, false);
        ButterKnife.bind(this,v);
        return v;
    }
    private boolean isValidUsername()
    {
        if(username.getText().toString().trim().isEmpty())
        {
            usernameLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            usernameLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isValidCode()
    {
        if(code.getText().toString().trim().isEmpty())
        {
            codeLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            codeLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isValidEmail()
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
    private boolean isValidSubject()
    {
        if(subject.getText().toString().trim().isEmpty())
        {
            subjectLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            subjectLayout.setErrorEnabled(false);
        }
        return true;
    }
    private boolean isValidComment()
    {
        if(comment.getText().toString().trim().isEmpty())
        {
            commentLayout.setError(StringUtil.getStringRes(R.string.error_msgs));
            return false;
        }
        else
        {
            commentLayout.setErrorEnabled(false);
        }
        return true;
    }
    @Override
    public void onResume() {
        super.onResume();
        YoYo.with(Techniques.SlideInLeft).duration(500).playOn(this.getView());
    }
}
