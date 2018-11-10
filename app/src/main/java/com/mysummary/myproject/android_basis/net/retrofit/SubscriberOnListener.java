package com.mysummary.myproject.android_basis.net.retrofit;


import io.reactivex.disposables.Disposable;

/**
 * Created by qiangxu on 2017/7/21.
 */

public interface SubscriberOnListener<T> {

    void onNext(T t);
    void onError(String e);
    void onSubscribe(Disposable d);

}
