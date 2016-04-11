package com.example.nian.androiddemo.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.example.nian.androiddemo.R;


/**
 * Created by niangang on 2016/4/6.
 */
public class CustomView extends View {
    /**
     * 控件的宽
     */
    private int mWidth;
    /**
     * 控件的高
     */
    private int mHeight;
    /**
     * 控件中的图片
     */
    private Bitmap mImage;
    /**
     * 图片的缩放模式
     */
    private int mImageScale;
    private static final int IMAGE_SCALE_FITXY = 0;
    private static final int IMAGE_SCALE_CENTER = 1;
    /**
     * 图片的介绍
     */
    private String mTitle;
    /**
     * 字体的颜色
     */
    private int mTextColor;
    /**
     * 字体的大小
     */
    private int mTextSize;

    private Paint mPaint;
    /**
     * 对文本的约束
     */
    private Rect mTextBound;
    /**
     * 控制整体布局
     */
    private Rect rect;


    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 初始化所特有自定义类型
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        int n = a.getIndexCount();

        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);

            switch (attr) {
                case R.styleable.CustomView_image:
                    mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
                    break;
                case R.styleable.CustomView_imageScaleType:
                    mImageScale = a.getInt(attr, 0);
                    break;
                case R.styleable.CustomView_titleText:
                    mTitle = a.getString(attr);
                    break;
                case R.styleable.CustomView_titleTxtColor:
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomView_titleTextSize:
                    mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            16, getResources().getDisplayMetrics()));
                    break;

            }
        }
        a.recycle();
        rect = new Rect();
        mPaint = new Paint();
        mTextBound = new Rect();
        mPaint.setTextSize(mTextSize);
        // 计算了描绘字体需要的范围
        mPaint.getTextBounds(mTitle, 0, mTitle.length(), mTextBound);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 设置宽度
         */
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        /***
         * 设置高度
         */
        int specHeighSize = MeasureSpec.getSize(heightMeasureSpec);

        // match_parent , accurate
        if (specMode == MeasureSpec.EXACTLY) {
            mWidth = specWidthSize;
            mHeight = specHeighSize;
        } else {
            // 由图片决定的宽
            int desireByImg = getPaddingLeft() + getPaddingRight() + mImage.getWidth();
            // 由字体决定的宽
            int desireByTitle = getPaddingLeft() + getPaddingRight() + mTextBound.width();
            int desireHeight = getPaddingTop() + getPaddingBottom() + mImage.getHeight() + mTextBound.height();
            if (specMode == MeasureSpec.AT_MOST) {
                // wrap_content
                int desire = Math.max(desireByImg, desireByTitle);
                mWidth = Math.min(desire, specWidthSize);
                mHeight = Math.max(desireHeight, specHeighSize);
            }
        }
        Log.d("--CustomView--", "CustomView  " + "mWidth  " + mWidth + "  mHeight  " + mHeight);
        setMeasuredDimension(mWidth, mHeight);
    }

    private int measureWidth(int pWidthMeasureSpec) {
        int result = 0;
        int widthMode = MeasureSpec.getMode(pWidthMeasureSpec);// 得到模式
        int widthSize = MeasureSpec.getSize(pWidthMeasureSpec);// 得到尺寸

        switch (widthMode) {
            /**
             * mode共有三种情况，取值分别为MeasureSpec.UNSPECIFIED, MeasureSpec.EXACTLY,
             * MeasureSpec.AT_MOST。
             *
             *
             * MeasureSpec.EXACTLY是精确尺寸，
             * 当我们将控件的layout_width或layout_height指定为具体数值时如andorid
             * :layout_width=50dip，或者为FILL_PARENT是，都是控件大小已经确定的情况，都是精确尺寸。
             *
             *
             * MeasureSpec.AT_MOST是最大尺寸，
             * 当控件的layout_width或layout_height指定为WRAP_CONTENT时
             * ，控件大小一般随着控件的子空间或内容进行变化，此时控件尺寸只要不超过父控件允许的最大尺寸即可
             * 。因此，此时的mode是AT_MOST，size给出了父控件允许的最大尺寸。
             *
             *
             * MeasureSpec.UNSPECIFIED是未指定尺寸，这种情况不多，一般都是父控件是AdapterView，
             * 通过measure方法传入的模式。
             */
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = widthSize;
                break;
        }
        return result;
    }


    private int measureHeight(int pHeightMeasureSpec) {
        int result = 0;

        int heightMode = MeasureSpec.getMode(pHeightMeasureSpec);
        int heightSize = MeasureSpec.getSize(pHeightMeasureSpec);

        switch (heightMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = heightSize;
                break;
        }
        return result;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        Log.d("--CustomView--", "CustomView  " + "mWidth  " + getMeasuredWidth() + "  mHeight  " + getMeasuredHeight());

        rect.left = getPaddingLeft();
        rect.right = mWidth - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = mHeight - getPaddingBottom();

//        mPaint.setColor(mTextColor);
//        mPaint.setStyle(Paint.Style.FILL);
        /**
         * 当前设置的宽度小于字体需要的宽度，将字体改为xxx...
         */
        canvas.drawText("1111", mWidth / 2, mHeight / 2, mPaint);


//        if (mTextBound.width() > mWidth) {
//            TextPaint paint = new TextPaint(mPaint);
//            String msg = TextUtils.ellipsize(mTitle, paint, (float) mWidth - getPaddingLeft() - getPaddingRight(),
//                    TextUtils.TruncateAt.END).toString();
//            canvas.drawText(msg, getPaddingLeft(), mHeight - getPaddingBottom(), mPaint);
//
//        } else {
//            //正常情况，将字体居中
//            mTitle = "111";
//            canvas.drawText(mTitle, mWidth / 2 - mTextBound.width() * 1.0f / 2, mHeight - getPaddingBottom(), mPaint);
//        }

//        //取消使用掉的快
//        rect.bottom -= mTextBound.height();
//
//        if (mImageScale == IMAGE_SCALE_FITXY) {
//            canvas.drawBitmap(mImage, null, rect, mPaint);
//        } else {
//            //计算居中的矩形范围
//            rect.left = mWidth / 2 - mImage.getWidth() / 2;
//            rect.right = mWidth / 2 + mImage.getWidth() / 2;
//            rect.top = (mHeight - mTextBound.height()) / 2 - mImage.getHeight() / 2;
//            rect.bottom = (mHeight - mTextBound.height()) / 2 + mImage.getHeight() / 2;
//
//            canvas.drawBitmap(mImage, null, rect, mPaint);
//        }


    }
}
