package com.example.nian.androiddemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nian.androiddemo.R;


public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_view);


        // 测试onLayout onMeasure
//        setContentView(R.layout.activity_simple_layout);

    }

}
