package com.example.nian.androiddemo.customView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.nian.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niangang on 2016/3/22.
 */
public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageTextView mImageTextView;
    private int num = 0;
    private PieView pieView;
    private List<PieData> pieDatas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        mImageTextView = (ImageTextView) findViewById(R.id.imgText);
        mImageTextView.setImageResource(R.mipmap.img_txt);
        mImageTextView.setBackgroundResource(R.color.img_txt_bg);
        mImageTextView.setOnClickListener(this);
        pieView = (PieView) findViewById(R.id.pie_view);

        setPieViewData();

    }

    private void setPieViewData() {

        pieDatas = new ArrayList<PieData>();
        PieData pieData;
        for (int i = 0; i < 5; i++) {
            pieData = new PieData("red" + i, 10);
            pieDatas.add(pieData);
        }

        pieView.setData(pieDatas);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imgText:
                mImageTextView.setText(num);

                num++;
                Log.d("--NG--", " NUM " + num);
                break;
        }

    }
}
