package com.example.nian.androiddemo.mvptest;

import com.example.nian.androiddemo.TabsTitleView.TabTitleContract;
import com.example.nian.androiddemo.base.BasePresenter;
import com.example.nian.androiddemo.base.BaseView;

/**
 * Created by niangang on 2016/5/30.
 */
public class LoginContract  {



    interface View extends BaseView<LoginContract.Presenter>{

        void showSuccessToast();
        void showErrorToast();
        void clearInput();
        void showProgressDialog();
        void hideProgressDialog();
    }


    interface Presenter extends BasePresenter{
        void isLoginResult(String name,String pwd);

    }
}
