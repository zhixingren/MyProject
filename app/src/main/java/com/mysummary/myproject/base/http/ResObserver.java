package com.mysummary.myproject.base.http;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by xingzhi on 2017/11/26.
 */

public class ResObserver<T> implements Observer<T>{

    private SubscriberOnListener mSubscriberOnListener ;

    public ResObserver(SubscriberOnListener mSubscriberOnListener){
        this.mSubscriberOnListener = mSubscriberOnListener;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(@NonNull T t) {
        if (mSubscriberOnListener!=null){
            mSubscriberOnListener.onNext(t);
        }
    }
    /**
     * 将onError方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param e 异常参数
     */
    @Override
    public void onError(@NonNull Throwable e) {
        if (mSubscriberOnListener!=null){
            mSubscriberOnListener.onError(e);
        }
    }

    @Override
    public void onComplete() {

    }



}
