package com.example.nian.androiddemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.nian.androiddemo.IAdditionService;

public class AdditionService extends Service {

    @Override
    public IBinder onBind(Intent intent) {


        return new IAdditionService.Stub() {
            @Override
            public int add(int value1, int value2) throws RemoteException {
                return value1+value2;
            }
        };
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }



}
