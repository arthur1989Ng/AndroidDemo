package com.example.nian.androiddemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by niangang on 2016/3/24.
 */
public class PathView extends View {
    private Paint mPaint;

    public PathView(Context context) {
        super(context);
        init();
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        mPaint = new Paint();             // 创建画笔
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();                          //画布宽度
        int height = canvas.getHeight();                        //画布高度


        canvas.drawColor(Color.GRAY);

        canvas.translate(width / 2, height / 2);  // 移动坐标系到屏幕中心
//        // <-- 注意 scale特殊运用：翻转y坐标轴
//        canvas.scale(1,-1);
//        Path path = new Path();
//        path.addRect(-100, -100, 100, 100, Path.Direction.CCW);
//        path.setLastPoint(-50, 50);                // <-- 重置最后一个点的位置
//        canvas.drawPath(path, mPaint);


        Path path = new Path();
        Path src = new Path();
        canvas.scale(1, -1);//翻转y坐标轴
        path.addRect(-100, -100, 100, 100, Path.Direction.CW);
        src.addCircle(0, 0, 50, Path.Direction.CW);

        path.addPath(src, 0, 100);


        canvas.drawPath(path, mPaint);

    }
}
