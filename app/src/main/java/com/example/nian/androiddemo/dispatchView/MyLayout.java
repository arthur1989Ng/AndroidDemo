package com.example.nian.androiddemo.dispatchView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by nian on 23/02/16.
 */
public class MyLayout extends LinearLayout {
    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

  /*  @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("TAG", "MyLayout  onInterceptTouchEvent");

        return super.onInterceptTouchEvent(ev);
    }
*/

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.d("TAG", "MyLayout  dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }
}
