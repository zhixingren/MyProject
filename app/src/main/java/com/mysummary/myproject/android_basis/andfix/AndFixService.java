package com.mysummary.myproject.android_basis.andfix;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import java.io.File;

/**
 * Created by xingzhi on 2018/9/30.
 *
 *  1.检查patch文件。2.下载patch文件。3.加载下载好的patch文件
 */

public class AndFixService extends Service{

    private static final String TAG = AndFixService.class.getSimpleName();
    private static final String FILE_END = ".apatch";
    private static final int UPDATE_PATCH = 0x02;
    private static final int DOWNLOAD_PATCH = 0x01;


    private String mPatchFileDir;//文件存放路径
    private String mPatchFile;//存放路径的文件夹
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case UPDATE_PATCH:
                        checkPatchUpdate();
                    break;
                case DOWNLOAD_PATCH:

                    break;

            }

        }
    };

    //检查服务器是否有patch文件
    private void checkPatchUpdate() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.sendEmptyMessage(UPDATE_PATCH);
        return START_NOT_STICKY;
    }

    private void init() {
        mPatchFileDir = getExternalCacheDir().getAbsolutePath()+ "/apatch/";
        File file = new File(mPatchFileDir);

        try {
            if (file != null||!file.exists()) {
                file.mkdir();
            }
        }catch (Exception e){
            e.printStackTrace();
            stopSelf();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }


}
