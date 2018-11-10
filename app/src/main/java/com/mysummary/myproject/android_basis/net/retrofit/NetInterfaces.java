package com.mysummary.myproject.android_basis.net.retrofit;

import com.mysummary.myproject.android_basis.net.entity.BaseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by xingzhi on 2018/9/19.
 */

public interface NetInterfaces {

    @GET("configs/adverts?spaceId=1011")
    Observable<BaseEntity> getRegist();


    @GET("configs/adverts?spaceId=1021")
    Observable<BaseEntity> getLogin();


}
