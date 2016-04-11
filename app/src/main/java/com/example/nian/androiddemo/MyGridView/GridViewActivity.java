package com.example.nian.androiddemo.MyGridView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.example.nian.androiddemo.R;

/**
 * Created by nian on 01/03/16.
 */
public class GridViewActivity extends Activity {

    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gridview);


        DisplayMetrics displayMetrics = getResources()
                .getDisplayMetrics();
        float density = displayMetrics.density;
    }
}
