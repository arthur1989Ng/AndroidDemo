package com.example.nian.androiddemo.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.example.nian.androiddemo.R;
import com.example.nian.androiddemo.util.DensityUtils;

/**
 * Created by niangang on 2016/3/22.
 */
public class ImageTextView extends ImageView {
    private String mNumber = "";
    private Paint mPaint;
    private int width;
    private int height;
    private int padding;
    private int textPaddingTop;

    public ImageTextView(Context context) {
        super(context);
        init();
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.black));
        mPaint.setTextSize(DensityUtils.dip2px((Activity) getContext(), 9));
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mPaint.setTextAlign(Paint.Align.CENTER);//居中对齐

        textPaddingTop = DensityUtils.dip2px((Activity) getContext(), 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        Log.d("--NG--", "drawText");
        width = getWidth();
        height = getHeight();
        Log.d("--NG--", "drawText  width " + width + "  height  " + height);

        Log.d("--NG--", "drawText  Canvas_width " + canvas.getWidth() + "  Canvas_height  " + canvas.getWidth());


        Rect textBounds = new Rect();//一个矩形
        mPaint.getTextBounds(mNumber, 0, mNumber == null ? 0 : mNumber.length(), textBounds);// get text bounds, that can get the text width and height

        int textWidth = textBounds.right - textBounds.left;
        int textHeight = textBounds.bottom - textBounds.top;
        Log.d("--NG--", "drawText  textWidth " + textWidth + "  textHeight  " + textHeight);
        int color = R.color.black;
        if (!isPressed() && isSelected()) {
            color = R.color.green;
        }
        mPaint.setColor(getResources().getColor(color));
        canvas.drawText(mNumber, (width - textWidth) / 2 + padding,  height / 2 + textHeight / 2 + textPaddingTop , mPaint);
    }

    public void setText(int number) {
        if (number >= 10) {
            padding = DensityUtils.dip2px((Activity) getContext(), 2.5f);
        } else {
            padding = DensityUtils.dip2px((Activity) getContext(), 0.5f);
        }
        mNumber = String.valueOf(number);
        invalidate();
    }
}
