package com.lcardoso.loginmvvm.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.lcardoso.loginmvvm.Interface.LoginResultCallbacks;
import com.lcardoso.loginmvvm.Model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user = new User();
    }

    //Method (Get email from EditText -> Set to user)
    public TextWatcher getEmailTextWatcher()
    {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    //Method (Get password from EditText -> Set to user)
    public TextWatcher getPasswordTextWatcher()
    {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    //Method for process login
    public void onLoginClicked(View view)
    {
        int errorCode = user.isValidData();
        if(errorCode == 0)
            loginResultCallbacks.onError("Put your email and password!");
        else if (errorCode == 1)
            loginResultCallbacks.onError("Email invalid");
        else if(errorCode == 2)
            loginResultCallbacks.onError("Password length must greater than 6 characters");
        else
            loginResultCallbacks.onSuccess("Login sucess");
    }
}
