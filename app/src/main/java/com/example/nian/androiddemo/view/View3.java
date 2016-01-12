package com.example.nian.androiddemo.view;

/**
 * Created by nian on 15-12-30.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class View3 extends LinearLayout {
    public View3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("view", "@@@@@@@@@@@@View3:调用View3的onLayout");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("view", "@@@@@@@@@@@@View3:调用View3的ononMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}