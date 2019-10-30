package com.lcardoso.loginmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.lcardoso.loginmvvm.Interface.LoginResultCallbacks;
import com.lcardoso.loginmvvm.databinding.ActivityMainBinding;
import com.lcardoso.loginmvvm.viewmodel.LoginViewModel;
import com.lcardoso.loginmvvm.viewmodel.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(
                this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class)
        );
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, message, Toast.LENGTH_LONG)
                .show();
    }
}
