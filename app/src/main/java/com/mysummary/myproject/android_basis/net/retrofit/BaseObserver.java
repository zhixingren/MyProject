package com.mysummary.myproject.android_basis.net.retrofit;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.mysummary.myproject.android_basis.net.exception.ApiException;
import com.mysummary.myproject.android_basis.net.exception.ErrorHandle;
import com.mysummary.myproject.android_basis.net.exception.NetException;
import com.mysummary.myproject.utils.ToastUtil;

import java.io.IOException;
import java.util.logging.Handler;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by xingzhi on 2018/9/19.
 */

public class BaseObserver<T> implements Observer<T> {


    private SubscriberOnListener listener ;

    public BaseObserver(SubscriberOnListener subscriberOnListener){
        this.listener = subscriberOnListener ;

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        listener.onNext(t);

    }

    @Override
    public void onError(Throwable e) {
        String string = null;
        if (e instanceof IOException) {
            string = "网络异常！";
            Log.e("onError",string);
        }
        if (e instanceof HttpException) {
            HttpException he = (HttpException)e;
            try {
                string = he.response().errorBody().string();
                Log.e("onError",string);
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
        listener.onError(string);

    }

    @Override
    public void onComplete() {


    }


}
