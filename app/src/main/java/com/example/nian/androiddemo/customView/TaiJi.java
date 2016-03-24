package com.example.nian.androiddemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by niangang on 2016/3/22.
 */
public class TaiJi extends View {

    private Paint whitePaint;
    private Paint blackPaint;
    private float degrees = 0;          //旋转角度


    //用户直接new一个View时会被调用
    public TaiJi(Context context) {
        super(context);
        initPaints();
    }

    //用户在Layout文件中使用这个View时会被调用
    public TaiJi(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    private void initPaints() {

        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint();
        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);
    }

    public void setRotate(float degrees) {
        this.degrees = degrees;
        invalidate();   //重绘界面
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();                          //画布宽度
        int height = canvas.getHeight();                        //画布高度


        Log.d("--NG--", "TaiJi  width  " + width + "  height  " + height);
        Point centerPoint = new Point(width / 2, height / 2);   //画布中心点
        canvas.translate(centerPoint.x, centerPoint.y); //将画布移动到中心
        //绘制两个半圆
        int radius = Math.min(width, height) / 2 - 100;             //太极半径


        RectF rectF = new RectF(-radius, -radius, radius, radius);
        canvas.drawColor(Color.GRAY);
        canvas.drawArc(rectF, 90, 180, true, blackPaint);
        canvas.drawArc(rectF, -90, 180, true, whitePaint);

        //绘制两个小圆
        int smallRadius = radius / 2;   //小圆半径为大圆的一般
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //眼睛
        int fishRadius = smallRadius/4;
        canvas.drawCircle(0,-smallRadius,fishRadius,whitePaint);
        canvas.drawCircle(0,smallRadius,fishRadius,blackPaint);

    }
}
