package com.mysummary.myproject.base.http;


import com.mysummary.myproject.android_basis.recyclerview.GpBean;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.entity.SwipeRefreshRfEntity;
import com.mysummary.myproject.base.entity.FirstEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by xingzhi on 2017/11/25.
 */

public interface HttpServices {

    //没有map的get
    @GET("configs/adverts?spaceId=1011")
    Observable<FirstEntity> getData();

//    //添加map的get,带token
//    @GET("accounts/baseInfo?")
//    Observable<Response<BaseInfoEntity>> getBaseInfo(@QueryMap Map<String,Object> map);

    //添加map的get,带token
//    @GET("accounts/baseInfo?")
//    Observable<BaseInfoEntity> getBaseInfo(@QueryMap Map<String, Object> map);

    //提交body
//    @POST("accounts/feedbacks?")
//    Observable<FeedBackEntity> postFeedBackData(@Body FeedBackBody data, @QueryMap Map<String, Object> map);

    //用于修改的put
//    @PUT("accounts/riskLevel?")
//    Observable<RiskTestEntity> putRiskTestData(@Body RequestBody body, @QueryMap Map<String, Object> map);


//    @DELETE("favorites/fundFavs/{id}?")
//    Observable<String> delete(@Path("id")String id,@QueryMap Map<String, Object> map);

//    @DELETE("favorites/fundFavs/{id}?")
//    Observable<Response<Void>> delete(@Path("id") String id, @Query("accessToken") String accessToken);


    //Gp项目
    @GET("gps/gps/{id}?")
    Observable<GpBean> getGpData(@Path("id") String id);

    @GET("gps/gps/{id}?")
    Observable<SwipeRefreshRfEntity> getSwipeRefeshData(@Path("id") String id);

    //Gp新闻
//    @GET("gps/news?")
//    Observable<NewsBean> getGpNewsData(@QueryMap Map<String, Object> map);

    //产品
//    @GET("gps/product")
//    Observable<ProductInformationBean> getProductInformation();

//    @GET("gps/product/doc?")
//    Observable<InfoShowBean> getInfoShow(@QueryMap Map<String, Object> map);

    //全部已投项目
//    @GET("gps/gps/{id}/project?")
//    Observable<AllHasCastActivityBean> getAllHasCastProjectData(@Path("id") String id, @QueryMap Map<String, Object> map);

    //项目详情
//    @GET("/gps/projects/{id}")
//    Observable<ProjectDetailsBean> getProjectDetail(@Path("id") String id);

    //项目详情中融资
//    @GET("/gps/projects/{id}")
//    Observable<PdFinaceBean> getPdFinace(@Path("id") String id);

    //Pd新闻
//    @GET("gps/news?")
//    Observable<PdNewsBean> getPdNewsData(@QueryMap Map<String, Object> map);


}

