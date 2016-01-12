package com.example.nian.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.nian.androiddemo.handlerThread.HandlerThreadDActivity;
import com.example.nian.androiddemo.view.ViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1 = (Button) findViewById(R.id.button);

        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:
                Intent itent = new Intent(this, HandlerThreadDActivity.class);
                startActivity(itent);

                break;
            case R.id.button2:

                Intent vIntent = new Intent(this, ViewActivity.class);
                startActivity(vIntent);
                break;

            case R.id.button3:
                ThreadA t1 = new ThreadA("t1");

                synchronized (t1) {
                    try {
                        // 启动“线程t1”
                        System.out.println(Thread.currentThread().getName() + " start t1");
                        t1.start();

                        // 主线程等待t1通过notify()唤醒。
                        System.out.println(Thread.currentThread().getName() + " wait()");
                        t1.wait();

                        System.out.println(Thread.currentThread().getName() + " continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
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
}
