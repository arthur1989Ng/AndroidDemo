package com.example.nian.androiddemo.TabsTitleView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Scroller;

import com.example.nian.androiddemo.R;

/**
 * Created by niangang on 2016/5/26.
 */
public class TabTitleView extends ViewGroup {
    private Context mContext;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;





    private DecelerateInterpolator mDecelerateInterpolator;
    private OvershootInterpolator mOvershootInterpolator;
    private PorterDuffXfermode mPorterDuffXfermode; //实现遮罩层


    private Bitmap mCoverLeft;
    private Bitmap mCoverRight;

    private int mTouchSlop = 0;
    private int mMaxVelocityX = 3000;


    public TabTitleView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public TabTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        mScroller = new Scroller(mContext);
        mTouchSlop = ViewConfiguration.get(mContext).getScaledTouchSlop();
        mMaxVelocityX = ViewConfiguration.get(mContext).getScaledMaximumFlingVelocity() / 3;

        mDecelerateInterpolator = new DecelerateInterpolator();
        mOvershootInterpolator = new OvershootInterpolator();
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);//多种模式


        mCoverLeft = BitmapFactory.decodeResource(getResources(), R.drawable.news_tabs_title_cover_left);
        mCoverRight = BitmapFactory.decodeResource(getResources(), R.drawable.news_tabs_title_cover_right);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
