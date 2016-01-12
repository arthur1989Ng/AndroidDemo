package com.example.nian.androiddemo.view;

/**
 * Created by nian on 15-12-30.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class View2 extends LinearLayout {

    public View2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的onLayout");
        super.onLayout(changed, l, t, r, b);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的onLayout############");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure");
        int specModeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int specModeHight = MeasureSpec.getMode(heightMeasureSpec);

        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure--AT_MOST:" + MeasureSpec.AT_MOST);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure--EXACTLY:" + MeasureSpec.EXACTLY);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure--UNSPECIFIED:" + MeasureSpec.UNSPECIFIED);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure--specModeWidth:" + specModeWidth);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure--specModeHight:" + specModeHight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的ononMeasure#########");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的onDraw:");
        super.dispatchDraw(canvas);
        Log.e("view", "@@@@@@@@@@@@view2:调用view2的onDraw@@@@@@@@@");
    }
}