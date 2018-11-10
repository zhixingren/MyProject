package com.mysummary.myproject.android_basis.service.startservice;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mysummary.myproject.R;
import com.mysummary.myproject.utils.CommonUtil;

/**
 * Created by xingzhi on 2018/4/21.
 *
 *  以 startService()，开启的service其实就是启动service,然后一切操作都在service里面完成。
 *  onCreate只调用一次,onStartCommand多次调用。
 *
 */

public class ServiceStart extends Service {

    private String TAG = "ServiceStart";
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }


    @Override
    public void onCreate() {
        super.onCreate();
        CommonUtil.LogUtil(TAG,"onCreate");
        player = MediaPlayer.create(this, R.raw.birds);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            int type = intent.getIntExtra("type", -1);
            switch (type) {
                case 0:// 播放
                    play();
                    break;
                case 1:// 暂停
                    pause();
                    break;
                case 2:// 停止
                    stop();
                    // 停止播放时，销毁Service
                    stopSelf();

                    break;
            }
        }
        return super.onStartCommand(intent, flags, startId);

    }

    private void stop() {
        if (player != null) {
            player.stop();
        }
    }

    private void pause() {
        if (player!=null&&player.isPlaying()) {
            player.pause();
        }
    }

    private void play() {
        if (player!=null&&!player.isPlaying()){
            player.start();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        CommonUtil.LogUtil(TAG,"onDestroy");

    }
}
