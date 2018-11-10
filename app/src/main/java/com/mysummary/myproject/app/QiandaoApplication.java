package com.mysummary.myproject.app;

import android.app.Application;
import android.content.Context;

import com.mysummary.myproject.android_basis.andfix.AndFixPatchManager;

/**
 * Created by xingzhi on 2018/7/4.
 */

public class QiandaoApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //完成AndFix的初始化
        initAndFix();

    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initManager(this);
    }


    public static Context getContext() {
        return context ;
    }
}
