package com.example.nian.androiddemo.scroller;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by niangang on 2016/4/13.
 */
public class MyScrollView extends ScrollView {

    private View inner;//子View
    private Rect normal = new Rect();// 矩形(这里只是个形式，只是用于判断是否需要动画.)
    private float mLastPosition;
    private boolean isDragged;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {

        if (getChildCount() > 0) {
            inner = getChildAt(0);
        }
        super.onFinishInflate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {


        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastPosition = ev.getY();
                isDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float nowY = ev.getY();//实时按下Y轴坐标
                int distance = (int) (mLastPosition - nowY);
                if (!isDragged)
                    distance = 0;

                mLastPosition = nowY;
                // 当滚动到最上或者最下时就不会再滚动，这时移动布局
                if (isNeedMove()) {
                    // 初始化头部矩形
                    if (normal.isEmpty()) {
                        // 保存正常的布局位置
                        normal.set(inner.getLeft(), inner.getTop(),
                                inner.getRight(), inner.getBottom());
                    }
                    Log.e("jj", "矩形：" + inner.getLeft() + "," + inner.getTop()
                            + "," + inner.getRight() + "," + inner.getBottom());
                    // 移动布局
                    inner.layout(inner.getLeft(), inner.getTop() - distance / 2,
                            inner.getRight(), inner.getBottom() - distance / 2);
                }
                isDragged = true;
                break;
            case MotionEvent.ACTION_UP:
                // 手指松开.
                if (isNeedAnimation()) {
                    animation();
                    isDragged = false;
                }

                break;
        }


        return super.onTouchEvent(ev);
    }

    //getHeight()返回的是在屏幕上显示的高度
    private boolean isNeedMove() {
        int offset = inner.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();

        Log.e("jj", "scrolly=" + scrollY);
        // 0是顶部，后面那个是底部
        if (scrollY == 0 || scrollY == offset) {
            return true;
        }
        return false;
    }

    /***
     * 回缩动画
     */
    public void animation() {
        // 开启移动动画
        TranslateAnimation ta = new TranslateAnimation(0, 0, inner.getTop(),
                normal.top);
        ta.setDuration(200);
        inner.startAnimation(ta);
        // 设置回到正常的布局位置
        inner.layout(normal.left, normal.top, normal.right, normal.bottom);

        Log.e("jj", "回归：" + normal.left + "," + normal.top + "," + normal.right
                + "," + normal.bottom);

        normal.setEmpty();

    }

    // 是否需要开启动画
    public boolean isNeedAnimation() {
        return !normal.isEmpty();
    }
}
