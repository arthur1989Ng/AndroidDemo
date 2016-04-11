package com.example.nian.androiddemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by niangang on 2016/3/27.
 */
public class TextViewTest extends TextView {
    public TextViewTest(Context context) {
        super(context);
    }

    public TextViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    //---------------------------
    // getWidth(): View在设定好布局后整个View的宽度。
    //  getMeasuredWidth(): 对View上的内容进行测量后得到的View内容佔据的宽度
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        Log.i("--NG--", "width: " + getWidth() + ",height: " + getHeight());
        Log.i("--NG--", "MeasuredWidth: " + getMeasuredWidth()
                + ",MeasuredHeight: " + getMeasuredHeight());
    }

}
