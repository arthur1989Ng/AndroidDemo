package com.example.nian.androiddemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by niangang on 2016/3/23.
 */
public class DrawView extends View {

    private Paint mPaint;
    //一般在直接New一个View的时候调用。
    public DrawView(Context context) {
        super(context);
        init();
    }
    //一般在layout文件中使用的时候会调用，关于它的所有属性(包括自定义属性)都会包含在attrs中传递进来。
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);//设置画笔模式为填充
        mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
        mPaint.setAntiAlias(true);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //先画矩形
        mPaint.setColor(Color.WHITE);
        RectF rectF = new RectF(100,100,900,900);
        canvas.drawRect(rectF, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(500, 500, 400, mPaint);
        //画圆弧
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF, -100, 180, true, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawArc(rectF, 80, 70, true, mPaint);

    }
}
