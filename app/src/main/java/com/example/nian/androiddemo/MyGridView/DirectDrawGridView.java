package com.example.nian.androiddemo.MyGridView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nian on 01/03/16.
 */
public class DirectDrawGridView extends View implements DirectDrawObserver {


    public DirectDrawGridView(Context context) {
        super(context);
    }

    public DirectDrawGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public DirectDrawGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {


    }

    @Override
    public void onDataChanged() {

    }

    @Override
    public void onDataInvalidate() {

    }
}
