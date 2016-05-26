package com.example.nian.androiddemo.dispatchView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.nian.androiddemo.R;

/**
 * Created by nian on 23/02/16.
 */
public class DispatchTouchActivity extends Activity {

    private MyLayout myLayout;
    private Button button1, button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dispatch);


        myLayout = (MyLayout) findViewById(R.id.my_layout);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.d("TAG", "button1 on touch");
                return true;
            }
        });

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "myLayout on touch");
                return false;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "You clicked button1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "You clicked button2");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("TAG", "Activity  onTouchEvent  " + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.d("TAG", " DispatchTouchActivity  dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }

}
