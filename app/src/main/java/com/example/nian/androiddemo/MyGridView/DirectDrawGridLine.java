package com.example.nian.androiddemo.MyGridView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import com.example.nian.androiddemo.PreferenceKeys;

/**
 * 全绘制网格分割线样式类
 *
 * @author yaoyuanhe
 */
public class DirectDrawGridLine {

    public static final int NULL = 0x1;
    public static final int DIVIDER = 0x2;
    public static final int DIVIDERANDBORDER = 0x3;

    public static final int LINE = 0x1;
    public static final int DRAWABLE = 0x2;

    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;

    // 内容左右边距，这个依据GridView的背景图片阴影有关系
    private int mLeftOffset = 2;
    int mRightOffset = 2;

    private Paint mDividerLinePaint = null;

    private int mColumnDividerType = DIVIDER;
    private int mRawDividerType = DIVIDER;

    private int mColumnDividerContentType = LINE;
    private int mRawDividerContentType = LINE;

    // 表格分割线资源
    private Bitmap mColumnDrawable = null;
    private Bitmap mRawDrawable = null;

    private float density;
    private Context mContext;

    public DirectDrawGridLine(Context context) {
        this.mContext = context;
        mDividerLinePaint = new Paint();
        mDividerLinePaint.setAntiAlias(true);
        mDividerLinePaint.setStrokeWidth(1);

        SharedPreferences sp = mContext.getSharedPreferences("Demo", Context.MODE_PRIVATE); //私有数据
        density = sp.getFloat(PreferenceKeys.SCREEN_DENSITY, 0);

    }

    public float getRawDividerSize() {
        float divideSize = mDividerLinePaint.getStrokeWidth();
        if (mRawDividerContentType == DRAWABLE && mRawDrawable != null) {
            divideSize = mRawDrawable.getHeight();
        }

        return divideSize;
    }

    public float getColumnDividerSize() {
        float divideSize = mDividerLinePaint.getStrokeWidth();
        if (mColumnDividerContentType == DRAWABLE && mColumnDrawable != null) {
            divideSize = mColumnDrawable.getWidth();
        }

        return divideSize;
    }

    public float getRawDividerHeight(int rawIndex) {
        float divideSize = getRawDividerSize();

        float dividerHeight = rawIndex * divideSize;
        if (mRawDividerType == DIVIDERANDBORDER) {
            dividerHeight = (rawIndex + 1) * divideSize;
        }

        return dividerHeight;
    }

    public float getRawDividerTotalHeight(int rawCount) {
        float divideSize = getRawDividerSize();

        float dividerHeight = (rawCount - 1) * divideSize;
        if (mRawDividerType == DIVIDERANDBORDER) {
            dividerHeight = (rawCount + 1) * divideSize;
        }

        return dividerHeight;
    }

    public float getColumnDividerWidth(int columnIndex) {
        float divideSize = getColumnDividerSize();

        float dividerWidth = columnIndex * divideSize;
        if (mColumnDividerType == DIVIDERANDBORDER) {
            dividerWidth = (columnIndex + 1) * divideSize;
        }

        return dividerWidth;
    }

    public float getColumnDividerTotalWidth(int columnCount) {
        float divideSize = getColumnDividerSize();

        float dividerWidth = (columnCount - 1) * divideSize;
        if (mColumnDividerType == DIVIDERANDBORDER) {
            dividerWidth = (columnCount + 1) * divideSize;
        }

        return dividerWidth;
    }

    public void setRawPadding(int left, int right) {
        mPaddingLeft = left;
        mPaddingRight = right;
    }

    public void setVolumnPadding(int top, int bottom) {
        mPaddingTop = top;
        mPaddingBottom = bottom;
    }

    public void setHorizatalOffset(int leftOffset, int rightOffset) {
        mLeftOffset = leftOffset;
        mRightOffset = rightOffset;
    }


    public void drawRawDivider(Canvas canvas, float rawGap, int rawCount, int gridWidth) {
        if (mRawDividerType != NULL) {
            int i = 1;
            int j = i - 1;
            int length = rawCount;
            if (mRawDividerType == DIVIDERANDBORDER) {
                i = 0;
                j = i;
                length += 1;
            }

            float startX = 0;
            float startY = 0;
            float stopX = 0;
            float stopY = 0;

            float dividerSize = mDividerLinePaint.getStrokeWidth();
            for (; i < length; i++) {
                if (mRawDividerContentType == LINE) {
                    startX = mPaddingLeft * density;
                    startY = i * rawGap + (j) * dividerSize;

                    stopX = gridWidth - mPaddingRight * density;
                    stopY = startY;

                    canvas.drawLine(startX, startY, stopX, stopY, mDividerLinePaint);
                } else if (mRawDividerContentType == DRAWABLE) {
                    if (mRawDrawable != null) {
                        dividerSize = mRawDrawable.getHeight();
                        startX = (gridWidth - mRawDrawable.getWidth()) / 2;
                        startY = i * rawGap + (j) * dividerSize;

                        canvas.drawBitmap(mRawDrawable, startX, startY, mDividerLinePaint);
                    }
                }

                j++;
            }
        }
    }

    public void drawColumnDivider(Canvas canvas, float columnGap, int columnCount, int gridHeight) {
        if (mColumnDividerType != NULL) {
            int i = 1;
            int j = i - 1;
            int length = columnCount;
            if (mColumnDividerType == DIVIDERANDBORDER) {
                i = 0;
                j = i;
                length += 1;
            }

            float startX = 0;
            float startY = 0;
            float stopX = 0;
            float stopY = 0;

            float dividerSize = mDividerLinePaint.getStrokeWidth();
            for (; i < length; i++) {
                if (mColumnDividerContentType == LINE) {
                    startX = i * columnGap + dividerSize * (j) + mLeftOffset * density;
                    startY = mPaddingTop * density;

                    stopX = startX;
                    stopY = gridHeight - mPaddingBottom * density;

                    canvas.drawLine(startX, startY, stopX, stopY, mDividerLinePaint);
                } else if (mColumnDividerContentType == DRAWABLE) {
                    if (mColumnDrawable != null) {
                        dividerSize = mColumnDrawable.getWidth();

                        startX = i * columnGap + dividerSize * (j);
                        startY = (gridHeight - mColumnDrawable.getHeight()) / 2;

                        canvas.drawBitmap(mColumnDrawable, startX, startY, mDividerLinePaint);
                    }
                }

                j++;
            }
        }
    }

}
