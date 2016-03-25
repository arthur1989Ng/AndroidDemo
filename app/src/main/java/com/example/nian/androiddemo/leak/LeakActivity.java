package com.example.nian.androiddemo.leak;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niangang on 2016/3/25.
 */
public class LeakActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //模拟Activity一些其他的对象
        for (int i = 0; i < 10000; i++) {
            list.add("Memory Leak!");
        }

        //开启线程
        new MyThread(this).start();
    }


    public static class MyThread extends Thread {
        private WeakReference<LeakActivity> mLeakActivityRef;

        public MyThread(LeakActivity activity) {
            mLeakActivityRef = new WeakReference<LeakActivity>(activity);
        }

        @Override
        public void run() {
            super.run();


            //如果需要使用LeakActivity，我们需要添加一个判断
            LeakActivity activity = mLeakActivityRef.get();
            if (activity != null) {
                //do something
                //模拟耗时操作
                try {
                    Thread.sleep(10 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
