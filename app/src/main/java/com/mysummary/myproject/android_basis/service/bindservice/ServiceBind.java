package com.mysummary.myproject.android_basis.service.bindservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mysummary.myproject.R;
import com.mysummary.myproject.utils.CommonUtil;

/**
 * Created by xingzhi on 2018/4/21.
 */

public class ServiceBind extends Service{

    public static final String TAG = "ServiceBind";
    private MediaPlayer player;


    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.birds);
        play();
        CommonUtil.LogUtil(TAG,"onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        CommonUtil.LogUtil(TAG,"onBind");
        return new MyBinder();
    }

    class MyBinder extends Binder {
        public ServiceBind getServiceBind(){
            CommonUtil.LogUtil(TAG,"getServiceBind");
            return ServiceBind.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        CommonUtil.LogUtil(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        CommonUtil.LogUtil(TAG,"onUnbind");
        stop();

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        CommonUtil.LogUtil(TAG,"onDestroy");
        super.onDestroy();
    }

    public void stop() {
        if (player != null) {
           player.stop();
        }
    }

    public void pause() {
        if (player!=null&&player.isPlaying()) {
            player.pause();
        }
    }

    public void play() {
        if (player!=null&&!player.isPlaying()){
            player.start();
        }
    }


}
