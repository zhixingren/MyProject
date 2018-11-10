package com.mysummary.myproject.android_basis.net.application;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by xingzhi on 2018/9/19.
 */

public class BaseActivity extends Activity {


    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    //管理RXJava生命周期
    public void addCompositeDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }


    //管理RXJava生命周期
    public void stopCompositeDisposable(Disposable disposable) {
        disposable.dispose();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeDisposable.size()!=0){
            compositeDisposable.dispose();
        }

    }

}
