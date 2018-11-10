package com.mysummary.myproject.android_basis.net.retrofit;


import com.mysummary.myproject.android_basis.net.entity.BaseEntity;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xingzhi on 2018/9/19.
 */

public class RxServiceMethods {

    public void RequestMethod(Observable<BaseEntity> observable, BaseObserver observer){
       observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

//    public void RequestMapMethod(Observable<T> observable, BaseObserver observer){
//        observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<T, E>() {
//                    @Override
//                    public E apply(T t) throws Exception {
//
//                        return ;
//                    }
//                })
//                .subscribe(observer);
//
//    }



}
