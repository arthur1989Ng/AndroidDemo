package com.example.nian.androiddemo.handlerThread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nian.androiddemo.R;


public class HandlerThreadDActivity extends AppCompatActivity {
    private static final String TAG = "bb";
    private int count = 0;
    private Handler mHandler;

    private Runnable mRunnable = new Runnable() {

        public void run() {
            //为了方便 查看，我们用Log打印出来
            Log.e(TAG, Thread.currentThread().getId() + " " + count);
            count++;
//            setTitle("" +count);
            //每2秒执行一次
            mHandler.postDelayed(mRunnable, 2000);
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "Main id    " + Thread.currentThread().getId() + " " + count);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread_d);
        //通过Handler启动线程
        HandlerThread handlerThread = new HandlerThread("threadone");//创建一个handlerThread线程
        handlerThread.start();//启动该线程
        mHandler = new Handler(handlerThread.getLooper());//将子线程的消息循环，赋值给主线程的handler
        mHandler.post(mRunnable); //加入mRunnable线程体到子线程的消息队列


    }

    @Override
    protected void onDestroy() {
        //将线程与当前handler解除
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }
}
