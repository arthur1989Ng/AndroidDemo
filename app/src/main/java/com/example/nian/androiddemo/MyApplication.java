package com.example.nian.androiddemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;

/**
 * Created by nian on 01/03/16.
 */
public class MyApplication extends Application {

    private float density;

    @Override
    public void onCreate() {
        super.onCreate();
        DisplayMetrics displayMetrics = getResources()
                .getDisplayMetrics();
        density = displayMetrics.density;


        SharedPreferences sharedPreferences = getSharedPreferences("Demo", Context.MODE_PRIVATE); //私有数据
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        editor.putFloat(PreferenceKeys.SCREEN_DENSITY, density);
        editor.commit();
    }


}
