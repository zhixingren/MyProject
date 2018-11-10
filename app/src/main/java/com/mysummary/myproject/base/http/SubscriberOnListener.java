package com.mysummary.myproject.base.http;

/**
 * Created by xingzhi on 2017/11/26.
 */

public interface SubscriberOnListener<T> {

    void onNext(T t);
    void onError(Throwable e);

}
