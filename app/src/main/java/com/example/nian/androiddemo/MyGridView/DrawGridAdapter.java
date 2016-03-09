package com.example.nian.androiddemo.MyGridView;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by nian on 01/03/16.
 */
public abstract class DrawGridAdapter<T> {

    private DirectDrawObserver mDrawObserver;


    public abstract int getCount();

    public abstract T getItem(int position);

    public abstract float getItemHeight();

    public abstract int getColumnCount();

    public abstract void DrawItem(Canvas canvas, int itemIndex, RectF drawRect);

    public abstract void DrawFocusItem(Canvas canvas, int itemIndex, RectF drawRect);


    public void registerDataSetObserver(DirectDrawObserver observer) {
        mDrawObserver = observer;
    }

    public void unregisterDataSetObserver() {
        mDrawObserver = null;
    }

    public void notifyDataChanged() {
        if (mDrawObserver != null) {
            mDrawObserver.onDataChanged();
        }
    }

    /**
     * need to reDraw
     */
    public void notifyDataInvalidate() {
        if (mDrawObserver != null) {
            mDrawObserver.onDataInvalidate();
        }
    }

}
