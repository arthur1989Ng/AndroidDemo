package com.example.nian.androiddemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nian on 15-12-30.
 */
public class SimpleLayout extends ViewGroup {
    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (getChildCount() > 0) {
            View childCount = getChildAt(0);
            measureChild(childCount, widthMeasureSpec, heightMeasureSpec);
            Log.e("--NG--", "onMeasure --  Child Height  " + childCount.getHeight() + "   Width  " + childCount.getWidth());

        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        if (getChildCount() > 0) {

            View childView = getChildAt(0);

            Log.e("--NG--", "onLayout   Child Height  " + childView.getHeight() + "   Width  " + childView.getWidth());

//            childView.layout(0, 0, 200, 200);

            childView.layout(0, 0, childView.getMeasuredWidth(), childView.getMeasuredHeight());

        }


    }
}
