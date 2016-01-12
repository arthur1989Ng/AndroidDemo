package com.example.nian.androiddemo.view;

/**
 * Created by nian on 15-12-30.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class View1 extends LinearLayout {

    public View1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的onLayout");
        super.onLayout(changed, l, t, r, b);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的onLayout##############");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure");
        int specModeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int specModeHight = MeasureSpec.getMode(heightMeasureSpec);

        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure--AT_MOST:" + MeasureSpec.AT_MOST);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure--EXACTLY:" + MeasureSpec.EXACTLY);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure--UNSPECIFIED:" + MeasureSpec.UNSPECIFIED);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure--specModeWidth:" + specModeWidth);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure--specModeHight:" + specModeHight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的ononMeasure##############");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的onDraw:");
        super.dispatchDraw(canvas);
        Log.e("view", "@@@@@@@@@@@@view1:调用view1的onDraw@@@@@@@@@");
    }

}