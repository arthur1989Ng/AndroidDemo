package com.example.nian.androiddemo.handlerThread;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nian.androiddemo.R;


public class ThreadDemoActivity extends AppCompatActivity {
    private static final String TAG = "bb";
    private int count = 0;
    private Handler mHandler;

    private Runnable mRunnable = new Runnable() {

        public void run() {
            //为了方便 查看，我们用Log打印出来
            Log.e(TAG, Thread.currentThread().getId() + " " + count);
            count++;
            setTitle("" + count);
            //每2秒执行一次
            mHandler.postDelayed(mRunnable, 2000);
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "Main id    " + Thread.currentThread().getId() + " " + count);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        //通过Handler启动线程
        mHandler = new Handler();
        mHandler.post(mRunnable);
    }

    @Override
    protected void onDestroy() {
        //将线程与当前handler解除绑定
        //mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }


}
