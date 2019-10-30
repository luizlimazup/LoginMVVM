package com.lcardoso.loginmvvm.Interface;

public interface LoginResultCallbacks {
    void onSuccess(String message);
    void onError(String message);
}
