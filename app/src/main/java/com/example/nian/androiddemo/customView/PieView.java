package com.example.nian.androiddemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niangang on 2016/3/23.
 */
public class PieView extends View {
    // 颜色表
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private List<PieData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint;

    public PieView(Context context) {
        super(context);
        init();
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        mPaint = new Paint();
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        mWidth = w;
//        mHeight = h;
//        Log.d("--NG--", "onSizeChanged   width  " + mWidth + "  height  " + mHeight);
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (null == mData)
            return;
        mWidth = getWidth();
        mHeight = getHeight();

        Log.d("--NG--", "onDraw   width  " + mWidth + "  height  " + mHeight);

        float currentStartAngle = mStartAngle;        // 当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2);  // 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8); // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);                       // 饼状图绘制区域

        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }


    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    // 设置数据
    public void setData(List<PieData> mData) {
        this.mData = mData;
        initDate(mData);
        invalidate();   // 刷新
    }

    // 初始化数据
    private void initDate(List<PieData> mData) {
        if (null == mData || mData.size() == 0)   // 数据有问题 直接返回
            return;

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            sumValue += pie.getValue();       //计算数值和

            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            float percentage = pie.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.setPercentage(percentage);                  // 记录百分比
            pie.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pie.getAngle());
        }
    }
}
