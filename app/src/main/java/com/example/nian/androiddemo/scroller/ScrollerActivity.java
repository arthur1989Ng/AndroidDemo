package com.example.nian.androiddemo.scroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.nian.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nian on 22/02/16.
 */
public class ScrollerActivity extends AppCompatActivity implements SlideCutListView.RemoveListener {

    private SlideCutListView slideCutListView;
    private ArrayAdapter<String> adapter;
    private List<String> dataSourceList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);
//        init();
    }

    private void init() {
//        slideCutListView = (SlideCutListView) findViewById(R.id.slideCutListView);
//        slideCutListView.setRemoveListener(this);
//
//        for (int i = 0; i < 20; i++) {
//            dataSourceList.add("滑动删除" + i);
//        }
//
//        adapter = new ArrayAdapter<String>(this, R.layout.scroller_item, R.id.list_item, dataSourceList);
//        slideCutListView.setAdapter(adapter);
//
//        slideCutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Toast.makeText(ScrollerActivity.this, dataSourceList.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //滑动删除之后的回调方法
    @Override
    public void removeItem(SlideCutListView.RemoveDirection direction, int position) {
//        adapter.remove(adapter.getItem(position));
//        switch (direction) {
//            case RIGHT:
//                Toast.makeText(this, "向右删除  " + position, Toast.LENGTH_SHORT).show();
//                break;
//            case LEFT:
//                Toast.makeText(this, "向左删除  " + position, Toast.LENGTH_SHORT).show();
//                break;
//
//            default:
//                break;
//        }
    }
}
