package com.example.nian.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nian.androiddemo.MyGridView.GridViewActivity;
import com.example.nian.androiddemo.customView.CustomViewActivity;
import com.example.nian.androiddemo.dispatchView.DispatchTouchActivity;
import com.example.nian.androiddemo.dynamicloadhost.ProxyActivity;
import com.example.nian.androiddemo.handlerThread.HandlerThreadDActivity;
import com.example.nian.androiddemo.holder.TextViewHolder;
import com.example.nian.androiddemo.intent.IntentActivity;
import com.example.nian.androiddemo.leak.LeakActivity;
import com.example.nian.androiddemo.mvptest.MVPTestActiviy;
import com.example.nian.androiddemo.scroller.ScrollerActivity;
import com.example.nian.androiddemo.service.ServiceActivity;
import com.example.nian.androiddemo.view.ViewActivity;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecylerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Demo[] demos = {
                new Demo(this, HandlerThreadDActivity.class, R.string.activity_handler_thread),
                new Demo(this, ViewActivity.class, R.string.activity_simple_layout),
                new Demo(this, ScrollerActivity.class, R.string.activity_scroller_layout),
                new Demo(this, DispatchTouchActivity.class, R.string.activity_dispatch_layout),
                new Demo(this, IntentActivity.class, R.string.activity_intent_layout),
                new Demo(this, ServiceActivity.class, R.string.activity_service_layout),
                new Demo(this, CustomViewActivity.class, R.string.activity_custom_view),
                new Demo(this, LeakActivity.class, R.string.activity_leak),
                new Demo(this, GridViewActivity.class, R.string.activity_grid_view),
                new Demo(this, ProxyActivity.class, R.string.activity_proxy),
                new Demo(this, MVPTestActiviy.class, R.string.activity_mvp_view),
        };

        mRecylerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecylerView.addItemDecoration(new MarginDecoration(this));
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setAdapter(new MainAdapter(demos));
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;// 屏幕宽度，单位为px
        int screenHeight = dm.heightPixels;// 屏幕高度，单位为px
        int densityDpi = dm.densityDpi;// 屏幕密度，单位为dpi
        float scale = dm.density;// 缩放系数，值为 densityDpi/160
        float fontScale = dm.scaledDensity;// 文字缩放系数，同scale

        Log.d("--NG--", "屏幕宽度  " + screenWidth + "  屏幕高度   " + screenHeight);
        Log.d("--NG--", "屏幕密度  " + densityDpi);
        Log.d("--NG--", "缩放系数  " + scale);
        Log.d("--NG--", "文字缩放系数  " + fontScale);


    }


    public class MainAdapter extends RecyclerView.Adapter<TextViewHolder> {


        private Demo[] demos;


        public MainAdapter(Demo[] d) {
            this.demos = d;
        }

        @Override
        public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new TextViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final TextViewHolder holder, int position) {
            final Demo demo = demos[position];
            holder.mTvActivity.setText(demo.title);
            holder.mTvActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = holder.mTvActivity.getContext();
                    context.startActivity(new Intent(context, demo.activityClass));
                }
            });

        }

        @Override
        public int getItemCount() {
            return demos.length;
        }
    }


    class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " call notify()");
                // 唤醒当前的wait线程
                notify();
            }
        }
    }

    public static class Demo {
        public final Class<?> activityClass;
        public final String title;

        public Demo(Context context, Class<?> activityClass, int titleId) {
            this.activityClass = activityClass;
            this.title = context.getString(titleId);
        }
    }
}
