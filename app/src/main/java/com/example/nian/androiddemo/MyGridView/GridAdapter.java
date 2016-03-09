package com.example.nian.androiddemo.MyGridView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.example.nian.androiddemo.R;

import java.util.List;

/**
 * Created by nian on 01/03/16.
 */
public class GridAdapter extends DrawGridAdapter<ItemModel> {
    // 一些数据常量，注意凡是涉及尺寸的单位都是dp
    /* 名站名称和名站图标之间的间隙 dp */
    private final int BASE_GAP_SIZE = 2;
    /* 名站名称的文本大小 sp */
    private final int BASE_TEXT_SIZE = 14;
    private final int BASE_TEXT_COLOR = 0xFF333333;
    /* 名站图标的大小 dp */
    private final int BASE_ICON_SIZE = 18;
    /* 名站单元格高度 dp */
    private final int BASE_CELL_HEIGHT = 40;
    /* 名站列数 */
    private final int BASE_COLUMN_COUNT = 4;
    /* 选中的背景颜色 */
    private final int BASE_FOCUS_COLOR = 0xFFEAECEE;
    /* 选中区域范围修正值 */
    final int BASE_FOCUS_OFFSET = 2;
    /* 名站个数 最大只有16 */
    private final int SITE_MAX_COUNT = 16;

    /* 名站名称的绘制样式 */
    private Paint mTextPaint = null;
    /* 名站名称基准宽度，动态取数据中名字最长的一个 px */
    private float mBaseTextWidth = -1;

    /* 名站选中的绘制样式 */
    private Paint mFocusPaint = null;

    /* 名站图标的绘制样式 */
    private Paint mIconPaint = null;
    private Drawable mDefaultIcon = null;
    /* 名站图标Bounds， 图标大小是固定的24dp * 24dp， 动态加上偏移量就是范围了 */
    private RectF mIconDstRect = null;


    private Context mContext;

    private float density;
    private List<ItemModel> mItems = null;

    public GridAdapter(Context context) {
        this.mContext = context;


        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(BASE_TEXT_SIZE * density);
        mTextPaint.setTypeface(Typeface.DEFAULT);

        // 暂且将3个中午字符算作基本的文本宽度
        mBaseTextWidth = mTextPaint.measureText("基准串");
        mFocusPaint = new Paint();
        mFocusPaint.setAntiAlias(true);
        mFocusPaint.setStyle(Paint.Style.FILL);

        mIconPaint = new Paint();
        mIconPaint.setAntiAlias(true);
        mIconPaint.setFilterBitmap(true);

        mIconDstRect = new RectF();

        mTextPaint.setColor(mContext.getResources().getColor(R.color.green_300));
        mFocusPaint.setColor(mContext.getResources().getColor(R.color.green_500));
        mDefaultIcon = mContext.getResources().getDrawable(R.mipmap.sites_baidu);

    }


    public void setData(List<ItemModel> items) {
        if (items == null || items.size() == 0)
            return;

        this.mItems = items;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (mItems != null) {
            count = mItems.size();
        }
        if (count > SITE_MAX_COUNT) {
            count = SITE_MAX_COUNT;
        }
        return count;
    }

    @Override
    public ItemModel getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public float getItemHeight() {
        return BASE_CELL_HEIGHT * density;
    }

    /**
     * 列数
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return BASE_COLUMN_COUNT;
    }

    @Override
    public void DrawItem(Canvas canvas, int itemIndex, RectF drawRect) {

        ItemModel item = getItem(itemIndex);
        if(item !=null){

        }


    }

    @Override
    public void DrawFocusItem(Canvas canvas, int itemIndex, RectF drawRect) {

    }
}
