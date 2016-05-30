package com.example.nian.androiddemo.mvptest;

import android.text.TextUtils;

/**
 * Created by niangang on 2016/5/30.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginContractView;

    public LoginPresenter(LoginContract.View mLoginContractView) {
        this.mLoginContractView = mLoginContractView;
        this.mLoginContractView.setPresenter(this);
    }

    @Override
    public void isLoginResult(String name, String pwd) {

        mLoginContractView.showProgressDialog();
        if (name != null && pwd != null && name.equals("ng") && pwd.equals("ng")) {
            mLoginContractView.showSuccessToast();

        } else {
            mLoginContractView.showErrorToast();
        }
//        mLoginContractView.hideProgressDialog();


    }

    @Override
    public void start() {

    }
}
