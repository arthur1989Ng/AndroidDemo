package com.example.nian.androiddemo.MyGridView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by nian on 01/03/16.
 */
public class GridViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DisplayMetrics displayMetrics = getResources()
                .getDisplayMetrics();
        float density = displayMetrics.density;
    }
}
