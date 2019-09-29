package com.mysummary.myproject.android_basis.android_architecture.mvc;

import android.os.AsyncTask;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.android_architecture.http.MyInterface;
import com.mysummary.myproject.android_basis.android_architecture.http.Translation;
import com.mysummary.myproject.android_basis.android_architecture.http.Translation1;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
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

    SparseArray array = new SparseArray();
    ArrayMap map = new ArrayMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

//       array.put(1,"");
//
//       map.put("","");


//        new AsyncTask<>();


//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//
//        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(128);
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        new IntentService()


//        OkHttpClient client = new OkHttpClient.Builder().build();
//
//        Request request = new Request.Builder().get().url("").build();
//
//        okhttp3.Call call = client.newCall(request);
//
//        try {
//            okhttp3.Response response = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        call.enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//
//            }
//        });



//        request();

        requstGet();


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
                Log.e("ee", Thread.currentThread().getName());
//                }

            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Log.e("ee","连接失败！");
                Log.e("ee",Thread.currentThread().getName());
            }
        });

    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        MyInterface request = retrofit.create(MyInterface.class);


        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Translation1> call = request.getCall("I love you");

        try {
            Log.e("TAG",
            Class.forName("com.mysummary.myproject.android_basis.android_architecture.mvc.MVCActivity").getMethod("requstGet").getGenericReturnType().toString());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


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
