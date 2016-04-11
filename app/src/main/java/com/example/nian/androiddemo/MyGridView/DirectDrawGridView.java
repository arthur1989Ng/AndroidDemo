package com.example.nian.androiddemo.MyGridView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nian on 01/03/16.
 */
public class DirectDrawGridView extends View {

    private Paint linePaint;

    private int width, height;

    private int cellWidth, cellHeight;

    private int raw = 1;//行数
    private int column = 4; //列数

    private float divider;

    public DirectDrawGridView(Context context) {
        super(context);
        init();
    }

    public DirectDrawGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setColor(Color.GRAY);
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth(2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
        height = getHeight();

        cellHeight = cellWidth = width / (column + 1);


        for (int i = 0; i <= column; i++) {
            //画列的线
            canvas.drawLine(cellWidth / 2 + i * cellWidth, cellWidth / 2, cellWidth / 2 + i * cellWidth, cellHeight + cellWidth / 2, linePaint);

        }
        // 画行
        for (int j = 0; j <= raw; j++) {
            canvas.drawLine(cellWidth / 2, cellWidth / 2 + j * cellHeight, cellWidth / 2 + cellWidth * column, j * cellHeight + cellWidth / 2, linePaint);
        }


        for (int i = 0; i < raw; i++) {

            for (int j = 0; j < column; j++) {

            }

        }
    }


    private void drawItem(Canvas canvas, int index, RectF bound) {






    }
}
