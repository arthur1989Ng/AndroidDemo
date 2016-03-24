package com.example.nian.androiddemo.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nian.androiddemo.IAdditionService;
import com.example.nian.androiddemo.R;

/**
 * Created by niangang on 2016/3/9.
 */
public class ServiceActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private IAdditionService addService;

    private AdditionServiceConnection connection;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        intent = new Intent(this, AdditionService.class);
        connection = new AdditionServiceConnection();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bindService(intent, connection, Context.BIND_AUTO_CREATE);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseService();

            }
        });

    }

    class AdditionServiceConnection implements ServiceConnection {


        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            addService = IAdditionService.Stub.asInterface(service);
            Log.d("--NG--", "AddtionServiceConnection---------- CONNECT");
            int sum = 0;
            try {
                sum = addService.add(1, 2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.d("--NG--", "sum  " + sum);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            addService = null;
            Log.d("--NG--", "AddtionServiceConnection---------- DISCONNECT");

        }
    }

    private void releaseService() {
        if (connection != null) {
            unbindService(connection);
            connection = null;
        }
    }

    @Override
    protected void onDestroy() {
        Log.d("--NG--", "releaseService");

        releaseService();
        super.onDestroy();
    }
}
