package com.example.nian.androiddemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by niangang on 2016/3/24.
 */
public class RadarView extends View {

    private int count = 6;                //数据个数
    private float angle = (float) (Math.PI * 2 / count);
    private float radius;                   //网格最大半径
    private int centerX;                  //中心X
    private int centerY;                  //中心Y
    private String[] titles = {"a", "b", "c", "d", "e", "f"};
    private double[] data = {100, 60, 20, 60, 100, 100}; //各维度分值
    private float maxValue = 100;             //数据最大值
    private Paint mainPaint;                //雷达区画笔
    private Paint valuePaint;               //数据区画笔
    private Paint textPaint;                //文本画笔

    public RadarView(Context context) {
        super(context);
        init();
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mainPaint = new Paint();
        mainPaint.setAntiAlias(true);
        mainPaint.setColor(Color.RED);
        mainPaint.setStyle(Paint.Style.STROKE);

        valuePaint = new Paint();
        valuePaint.setAntiAlias(true);
        valuePaint.setColor(Color.BLUE);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint = new Paint();
        textPaint.setTextSize(50);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h, w) / 2 * 0.7f;
        //中心坐标
        centerX = w / 2;
        centerY = h / 2;

        Log.d("--NG--", "onSizeChanged  " + "w  " + w + "  h" + w + "  oldw " + oldw + "  oldh  " + oldh);
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

        drawPolygon(canvas);
        drawLine(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

    private void drawPolygon(Canvas canvas) {
        float r = radius / (count - 1);
        Path path = new Path();
        for (int j = 1; j < count; j++) {
            float curRadius = r * j;
            path.reset();
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    path.moveTo(centerX + curRadius, centerY);
                } else {
                    float rx = (float) (centerX + curRadius * Math.cos(angle * i));
                    float ry = (float) (centerY + curRadius * Math.sin(angle * i));
                    path.lineTo(rx, ry);
                }
            }
            path.close();
            canvas.drawPath(path, mainPaint);
        }
    }

    private void drawLine(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            float rx = (float) (centerX + radius * Math.cos(angle * i));
            float ry = (float) (centerY + radius * Math.sin(angle * i));
            path.lineTo(rx, ry);
            canvas.drawPath(path, mainPaint);
        }
    }

    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;

        for (int i = 0; i < count; i++) {

            float curAngle = angle * i;
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));

            if (curAngle >= 0 && curAngle <= Math.PI / 2) {
                //第一象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (curAngle > Math.PI / 2 && curAngle <= Math.PI) {
                //第二象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x, y + dis, textPaint);
            } else if (curAngle > Math.PI && curAngle <= Math.PI * 3 / 2) {
                //第三象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (curAngle > Math.PI * 3 / 2 && curAngle <= Math.PI * 2) {
                //第四象限
                canvas.drawText(titles[i], x, y, textPaint);
            }
        }
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(255);

        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);
            } else {
                path.lineTo(x, y);
            }

            //绘制小圆点
            canvas.drawCircle(x, y, 10, valuePaint);
        }

        path.close();
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }
}
