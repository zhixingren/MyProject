package com.mysummary.myproject.app;

import android.app.Application;
import android.content.Context;

import com.mysummary.myproject.android_basis.andfix.AndFixPatchManager;

import org.greenrobot.greendao.database.Database;

import butterknife.internal.Utils;
import greendao.dao.gen.DaoMaster;
import greendao.dao.gen.DaoSession;

/**
 * Created by xingzhi on 2018/7/4.
 */

public class QiandaoApplication extends Application {

    private static Context context;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"notes-db");
        Database readableDb = devOpenHelper.getReadableDb();

        daoSession = new DaoMaster(readableDb).newSession();
        //完成AndFix的初始化
        initAndFix();

    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initManager(this);
    }


    public static Context getContext() {
        return context ;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
