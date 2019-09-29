package com.mysummary.myproject.android_basis;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.android_architecture.mvc.MVCActivity;
import com.mysummary.myproject.android_basis.android_architecture.mvp.view.MVPActivity;
import com.mysummary.myproject.android_basis.constraint_Layout.ConstraintLayoutActivity;
import com.mysummary.myproject.android_basis.dagger.DaggerActivity;
import com.mysummary.myproject.android_basis.databinding.DataBindingActivity;
import com.mysummary.myproject.android_basis.databingding2.DataBingPracticeActivity;
import com.mysummary.myproject.android_basis.donghua.AnimationActivity;
import com.mysummary.myproject.android_basis.event_bus.EventBusActivity;
import com.mysummary.myproject.android_basis.event_dispatch.EventActivity;
import com.mysummary.myproject.android_basis.greendao.GreenDaoActivity;
import com.mysummary.myproject.android_basis.lottie.LottieActivity;
import com.mysummary.myproject.android_basis.multi_thread.HandlerThreadDemo;
import com.mysummary.myproject.android_basis.net.application.BaseActivity;
import com.mysummary.myproject.android_basis.net.entity.BaseEntity;
import com.mysummary.myproject.android_basis.net.retrofit.BaseObserver;
import com.mysummary.myproject.android_basis.net.retrofit.NetService;
import com.mysummary.myproject.android_basis.net.retrofit.RxServiceMethods;
import com.mysummary.myproject.android_basis.net.retrofit.SubscriberOnListener;
import com.mysummary.myproject.android_basis.progressbar.ProgressBarActivity;
import com.mysummary.myproject.android_basis.recyclerview.RecylcerViewActivity;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.SwipeRefreshActivity;
import com.mysummary.myproject.android_basis.recyclerview1.lemon.ui.RecyclerViewActivityDemo;
import com.mysummary.myproject.android_basis.recyclerview1.recyclerview.ui.RecyclerViewMainActivity;
import com.mysummary.myproject.android_basis.rxjava2.Rxjava2Activity;
import com.mysummary.myproject.android_basis.sqlite.SqliteActivity;
import com.mysummary.myproject.android_basis.ui_optimization.UIActivity;
import com.mysummary.myproject.android_basis.web_view.WebViewActivity;
import com.mysummary.myproject.android_basis.zidingyi_view.CustomViewActivity;

import io.reactivex.disposables.Disposable;


public class AndroidBasisActivity extends BaseActivity implements View.OnClickListener {

    Button btn_to_webview, btn_to_customview,
            btn_to_animation, btn_to_eventbus,
            btn_to_mvp, btn_to_sqlite, btn_to_constraint_layout,
            btn_to_recycler, btn_to_handlthread, btn_to_event_dispatch,
            btn_to_swipe_refresh, btn_to_mvc, btn_to_data_binding,
            btn_to_rxjava, btn_to_progressbar, btn_to_uiactivity,
            btn_to_swipe_refresh2,btn_to_data_binding_practice,
            btn_ui_youhua,btn_greendao,btn_dagger,btn_lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_basis);
        btn_to_webview = findViewById(R.id.btn_to_webview);
        btn_to_webview.setOnClickListener(this);
        btn_to_customview = findViewById(R.id.btn_to_customview);
        btn_to_customview.setOnClickListener(this);
        btn_to_animation = findViewById(R.id.btn_to_animation);
        btn_to_animation.setOnClickListener(this);
        btn_to_eventbus = findViewById(R.id.btn_to_eventbus);
        btn_to_eventbus.setOnClickListener(this);
        btn_to_mvp = findViewById(R.id.btn_to_mvp);
        btn_to_mvp.setOnClickListener(this);
        btn_to_mvc = findViewById(R.id.btn_to_mvc);
        btn_to_mvc.setOnClickListener(this);
        btn_to_sqlite = findViewById(R.id.btn_to_sqlite);
        btn_to_sqlite.setOnClickListener(this);
        btn_to_constraint_layout = findViewById(R.id.btn_to_constraint_layout);
        btn_to_constraint_layout.setOnClickListener(this);
        btn_to_recycler = findViewById(R.id.btn_to_recycler);
        btn_to_recycler.setOnClickListener(this);
        btn_to_handlthread = findViewById(R.id.btn_to_handlthread);
        btn_to_handlthread.setOnClickListener(this);
        btn_to_event_dispatch = findViewById(R.id.btn_to_event_dispatch);
        btn_to_event_dispatch.setOnClickListener(this);
        btn_to_swipe_refresh = findViewById(R.id.btn_to_swipe_refresh);
        btn_to_swipe_refresh.setOnClickListener(this);
        btn_to_data_binding = findViewById(R.id.btn_to_data_binding);
        btn_to_data_binding.setOnClickListener(this);
        btn_to_rxjava = findViewById(R.id.btn_to_rxjava);
        btn_to_rxjava.setOnClickListener(this);
        btn_to_progressbar = findViewById(R.id.btn_to_progressbar);
        btn_to_progressbar.setOnClickListener(this);
        btn_to_uiactivity = findViewById(R.id.btn_to_uiactivity);
        btn_to_uiactivity.setOnClickListener(this);
        btn_to_swipe_refresh2 = findViewById(R.id.btn_to_swipe_refresh2);
        btn_to_swipe_refresh2.setOnClickListener(this);
        btn_to_data_binding_practice = findViewById(R.id.btn_to_data_binding_practice);
        btn_to_data_binding_practice.setOnClickListener(this);
        btn_ui_youhua = findViewById(R.id.btn_ui_youhua);
        btn_ui_youhua.setOnClickListener(this);
        btn_greendao = findViewById(R.id.btn_greendao);
        btn_greendao.setOnClickListener(this);
        btn_dagger = findViewById(R.id.btn_dagger);
        btn_dagger.setOnClickListener(this);
        btn_lottie = findViewById(R.id.btn_lottie);
        btn_lottie.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_webview:
                startActivity(new Intent(AndroidBasisActivity.this, WebViewActivity.class));
                break;
            case R.id.btn_to_customview:
                startActivity(new Intent(AndroidBasisActivity.this, CustomViewActivity.class));

                break;
            case R.id.btn_to_animation:
                startActivity(new Intent(AndroidBasisActivity.this, AnimationActivity.class));
                break;
            case R.id.btn_to_eventbus:
                startActivity(new Intent(AndroidBasisActivity.this, EventBusActivity.class));
                break;

            case R.id.btn_to_mvp:
                startActivity(new Intent(AndroidBasisActivity.this, MVPActivity.class));
                break;
            case R.id.btn_to_mvc:
                startActivity(new Intent(AndroidBasisActivity.this, MVCActivity.class));
                break;
            case R.id.btn_to_sqlite:
                startActivity(new Intent(AndroidBasisActivity.this, SqliteActivity.class));

                break;

            case R.id.btn_to_constraint_layout:
                startActivity(new Intent(AndroidBasisActivity.this, ConstraintLayoutActivity.class));

                break;
            case R.id.btn_to_recycler:
                startActivity(new Intent(AndroidBasisActivity.this, RecylcerViewActivity.class));

                break;
            case R.id.btn_to_swipe_refresh:
                startActivity(new Intent(AndroidBasisActivity.this, SwipeRefreshActivity.class));
                break;

            case R.id.btn_to_handlthread:
                startActivity(new Intent(AndroidBasisActivity.this, HandlerThreadDemo.class));

                break;
            case R.id.btn_to_event_dispatch:
                startActivity(new Intent(AndroidBasisActivity.this, EventActivity.class));

                break;

            case R.id.btn_to_data_binding:
                startActivity(new Intent(AndroidBasisActivity.this, DataBindingActivity.class));

                break;
            case R.id.btn_to_data_binding_practice:
                startActivity(new Intent(AndroidBasisActivity.this, DataBingPracticeActivity.class));

                break;

            case R.id.btn_to_rxjava:
                startActivity(new Intent(AndroidBasisActivity.this, Rxjava2Activity.class));

                break;
            case R.id.btn_to_progressbar:

                Intent intent = new Intent();
                intent.setClass(AndroidBasisActivity.this, ProgressBarActivity.class);
                //intent.putExtra("entity",(Serializable) new BaseEntity());
                startActivity(intent);

                break;
           case R.id.btn_to_swipe_refresh2:
            Intent intent2 = new Intent();
            intent2.setClass(AndroidBasisActivity.this, RecyclerViewActivityDemo.class);
            startActivity(intent2);

            break ;
            case R.id.btn_to_uiactivity:
//                startActivity(new Intent(AndroidBasisActivity.this, UIActivity.class));

                new RxServiceMethods()
                        .RequestMethod(NetService.getInstance().getHttpInterface(null,AndroidBasisActivity.this).getRegist()
                                ,new BaseObserver(new SubscriberOnListener<BaseEntity>() {
                    @Override
                    public void onNext(BaseEntity o) {

                    }

                    @Override
                    public void onError(String e) {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                }

                ));


                /*
                new RxServiceMethods().RequestMethod(new NetService()
                        .getHttpInterface(null, AndroidBasisActivity.this).getRegist(), new BaseObserver(new SubscriberOnListener<BaseEntity>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        addCompositeDisposable(d);
                    }


                    @Override
                    public void onNext(BaseEntity result) {
                        Log.e("result", result.getData().get(0).getImageUrl());
                    }

                    @Override
                    public void onError(String e) {

                        Toast.makeText(AndroidBasisActivity.this, e, Toast.LENGTH_SHORT).show();
                    }


                }));
                */

//                Observable<BaseEntity> result = new NetService().getHttpInterface(null,this).getRegist();
//
//
//
//               final ArrayList<String> list = new ArrayList<>();
               /*
                https://www.jianshu.com/p/128e662906af
                https://segmentfault.com/a/1190000012036180

                模拟先注册，之后登陆过程
                也就是一个请求结束，接着进行下一个请求

                */

//                new NetService()
//                        .getHttpInterface(null,this)
//                        .getRegist()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .doOnNext(new Consumer<BaseEntity>() {
//                            @Override
//                            public void accept(BaseEntity commonResult) throws Exception {
//                                Log.e("doOnnext",commonResult.getData().get(0).getImageUrl()+"--"+
//                                Thread.currentThread().getName());
//
//                            }
//                        })
//                        .doOnError(new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//
//                            }
//                        })
//                        .observeOn(Schedulers.io())
//                        .flatMap(new Function<BaseEntity, ObservableSource<BaseEntity>>() {
//                            @Override
//                            public ObservableSource<BaseEntity> apply(BaseEntity commonResult) throws Exception {
//
//                                Log.e("flatMap",commonResult.getData().get(1).getImageUrl()+"--"+
//                                        Thread.currentThread().getName());
//
//                                //return Observable.fromIterable(commonResult.getData());
//                                return new NetService().getHttpInterface(null,AndroidBasisActivity.this).getLogin();
//                            }
//                        })
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Observer<BaseEntity>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseEntity dataBean) {

//                            Log.e("onnext",dataBean.getImageUrl());
//
//
//                        list.add(dataBean.getImageUrl());
//
//
//                        Log.e("onnext2",list.size()+"");


//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

//                        .map(new Function<BaseEntity, List<BaseEntity.DataBean> >() {
//                            @Override
//                            public List<BaseEntity.DataBean> apply(BaseEntity commonResult) throws Exception {
//
//                                return commonResult.getData();
//                            }
//                        })
//                        .subscribe(
//                                new Observer<List<BaseEntity.DataBean>>() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(List<BaseEntity.DataBean> dataBeans) {
//
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//
//                                    }
//                                }
//                        );


                break;

            case R.id.btn_ui_youhua:

                startActivity(new Intent(this, UIActivity.class));
                break;
            case R.id.btn_greendao:
                startActivity(new Intent(this, GreenDaoActivity.class));
                break;
            case R.id.btn_dagger:
                startActivity(new Intent(this, DaggerActivity.class));
                break;
            case R.id.btn_lottie:
                startActivity(new Intent(this, LottieActivity.class));
                break;

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
