package com.mysummary.myproject.android_basis.service.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by xingzhi on 2018/6/28.
 */

public class BIndServiceTwo extends Service {





    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder{

        public BIndServiceTwo getService(){

            return BIndServiceTwo.this;
        }

    }
}
