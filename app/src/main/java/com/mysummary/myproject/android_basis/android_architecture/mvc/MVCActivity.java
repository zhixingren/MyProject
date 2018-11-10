package com.mysummary.myproject.android_basis.android_architecture.mvc;

import android.app.IntentService;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.android_architecture.http.MyInterface;
import com.mysummary.myproject.android_basis.android_architecture.http.Translation;
import com.mysummary.myproject.android_basis.android_architecture.http.Translation1;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//https://www.tianmaying.com/tutorial/AndroidMVC

/*
    真正的mvc:
    http://www.apkbus.com/forum.php?mod=viewthread&tid=242726&highlight=mvc%2Bandroid
 */

public class MVCActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

//        new AsyncTask<>()


//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//
//        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(128);
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        new IntentService()

        request();

        //requstGet();


    }



    public void requstGet(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MyInterface myInterface = retrofit.create(MyInterface.class);

        Call<Translation> call = myInterface.getCall();

        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
//                List<String> translation = response.body().getTranslation();

//                List<Translation.WebBean> web = response.body().getWeb();
//                for (int i = 0; i < web.size(); i++) {
                Log.e("ee", response.body().toString());
//                }

            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Log.e("ee","连接失败！");
            }
        });

    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        MyInterface request = retrofit.create(MyInterface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Translation1> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation1>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());

            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation1> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }



}
