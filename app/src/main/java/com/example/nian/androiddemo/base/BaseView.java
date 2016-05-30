package com.example.nian.androiddemo.base;

/**
 * Created by niangang on 2016/5/26.
 */
public interface BaseView<T extends BasePresenter> {

    void setPresenter( T presenter);
}
