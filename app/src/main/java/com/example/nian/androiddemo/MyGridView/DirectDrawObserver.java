package com.example.nian.androiddemo.MyGridView;

/**
 * Created by nian on 01/03/16.
 */
public interface DirectDrawObserver {
    /**
     * 当数据变化时，DirectDrawView重新计算高度，并进行重绘
     * onMesure --> onLayout --> onDraw 都走一遍
     */
    public void onDataChanged();

    /**
     * 当数据变化时，DirectDrawView 重绘
     * onDraw
     */
    public void onDataInvalidate();

}
