package com.example.nian.androiddemo.TabsTitleView;

import com.example.nian.androiddemo.base.BasePresenter;
import com.example.nian.androiddemo.base.BaseView;

/**
 * Created by niangang on 2016/5/26.
 */
public interface TabTitleContract {

    interface View extends BaseView<Presenter>{
        void clickTitle(int pisition);
        void showToast();
    }

    interface Presenter extends BasePresenter{

    }


}



