package com.mysummary.myproject.base.http;


import com.mysummary.myproject.android_basis.recyclerview.GpBean;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.entity.SwipeRefreshRfEntity;
import com.mysummary.myproject.base.entity.FirstEntity;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * Created by xingzhi on 2017/11/26.
 */

public class ServersMethod {



    private <T>void toSubscribe(Observable<T> o, Observer<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);

    }


    //
    public void getBannerData(Observer<FirstEntity> observer){
        Observable<FirstEntity> mUpdateObservable = HttpMethod.getInstance().httpServices.getData();
        toSubscribe(mUpdateObservable, observer);

    }

//    //基本信息
//    public void getBaseInfoData(Observer<Response<BaseInfoEntity>> observer, Map<String, Object> map){
//        Observable<Response<BaseInfoEntity>> mUpdateObservable = HttpMethod.getInstance().httpServices.getBaseInfo(map);
//        toSubscribe(mUpdateObservable, observer);
//
//    }

    //基本信息
//    public void getBaseInfoData(Observer<BaseInfoEntity> observer, Map<String, Object> map){
//        Observable<BaseInfoEntity> mUpdateObservable = HttpMethod.getInstance().httpServices.getBaseInfo(map);
//        toSubscribe(mUpdateObservable, observer);
//
//    }
//
//    //反馈
//    public void postFeedBackData(Observer<FeedBackEntity> observer, FeedBackBody body, Map<String, Object> map){
//        Observable<FeedBackEntity> mUpdateObservable = HttpMethod.getInstance().httpServices.postFeedBackData(body,map);
//        toSubscribe(mUpdateObservable, observer);
//
//    }
//
//    //反馈
//    public void putRiskTestData(Observer<RiskTestEntity> observer, RequestBody body, Map<String, Object> map){
//        Observable<RiskTestEntity> mUpdateObservable = HttpMethod.getInstance().httpServices.putRiskTestData(body,map);
//        toSubscribe(mUpdateObservable, observer);
//
//    }
//
//    //
////    public void delete(Observer<String> observer, String id ,Map<String, Object> map){
////        Observable<String> mUpdateObservable = HttpMethod.getInstance().httpServices.delete(id,map);
////        toSubscribe(mUpdateObservable, observer);
////
////    }
//
//    //
//    public void delete(Observer<Response<Void>> observer, String id ,String token){
//        Observable<Response<Void>> mUpdateObservable = HttpMethod.getInstance().httpServices.delete(id,token);
//        toSubscribe(mUpdateObservable, observer);
//
//    }
//    //Gp项目
    public void getGpData(Observer<GpBean> observer, String map){
        Observable<GpBean> mUpdateObservable = HttpMethod.getInstance().httpServices.getGpData(map);
        toSubscribe(mUpdateObservable, observer);
    }

    //swiperefresh 练习
    public void getSwipeData(Observer<SwipeRefreshRfEntity> observer, String map){
        Observable<SwipeRefreshRfEntity> mUpdateObservable = HttpMethod.getInstance().httpServices.getSwipeRefeshData(map);
        toSubscribe(mUpdateObservable, observer);
    }
//    //Gp新闻
//    public void getGpNewsData(Observer<NewsBean> observer, Map<String, Object> map){
//        Observable<NewsBean> mUpdateObservable = HttpMethod.getInstance().httpServices.getGpNewsData(map);
//        toSubscribe(mUpdateObservable, observer);
//    }
//
//    //产品信息
//    public void getProductInformationData(Observer<ProductInformationBean> observer, Map<String, Object> map){
//        Observable<ProductInformationBean> mProductInformationObservable = HttpMethod.getInstance().httpServices.getProductInformation();
//        toSubscribe(mProductInformationObservable, observer);
//    }
//    //信息披露
//    public void getInfoShowData(Observer<InfoShowBean> observer, Map<String, Object> map){
//        Observable<InfoShowBean> mInfoShowObservable = HttpMethod.getInstance().httpServices.getInfoShow(map);
//        toSubscribe(mInfoShowObservable, observer);
//    }
//
//    //全部已投项目
//    public void getAllHasProjectData(Observer<AllHasCastActivityBean> observer, String id , Map<String, Object> map){
//        Observable<AllHasCastActivityBean> mAllHasCastProjectObservable = HttpMethod.getInstance().httpServices.getAllHasCastProjectData(id,map);
//        toSubscribe(mAllHasCastProjectObservable, observer);
//    }
//
//    //Gp新闻
//    public void getProjectDetailData(Observer<ProjectDetailsBean> observer, String  id){
//        Observable<ProjectDetailsBean> mProjectDetailObservable = HttpMethod.getInstance().httpServices.getProjectDetail(id);
//        toSubscribe(mProjectDetailObservable, observer);
//    }
//
//    //pd融资
//    public void getPdFinaceData(Observer<PdFinaceBean> observer, String  id){
//        Observable<PdFinaceBean> mProjectDetailObservable = HttpMethod.getInstance().httpServices.getPdFinace(id);
//        toSubscribe(mProjectDetailObservable, observer);
//    }
//
//
//    //Pd新闻
//    public void getPdNewsData(Observer<PdNewsBean> observer, Map<String, Object> map){
//        Observable<PdNewsBean> mUpdateObservable = HttpMethod.getInstance().httpServices.getPdNewsData(map);
//        toSubscribe(mUpdateObservable, observer);
//    }

}
