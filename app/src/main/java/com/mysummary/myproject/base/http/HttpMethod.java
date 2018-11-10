package com.mysummary.myproject.base.http;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xingzhi on 2017/11/25.
 */

public class HttpMethod {

    //主机地址
//    public static final String BASE_URL = "https://techapp.unifgroup.com/techappApiV1/";
    public static final String BASE_URL = "https://testtechapp.unifgroup.com:39880/";

    //请求超时时间
    public static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    public HttpServices httpServices;


    public HttpMethod(){

        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("zcb","OkHttp====Message:"+message);
            }
        });
        loggingInterceptor.setLevel(level);

        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)

                .connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        httpServices = retrofit.create(HttpServices.class);


    }

    public static class SingletonHolder{
        public static final  HttpMethod INSTANCE = new HttpMethod();
    }

    //获取单例
    public static HttpMethod getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public class ToStringConverterFactory extends Converter.Factory {
        private final MediaType MEDIA_TYPE = MediaType.parse("text/html;charset=utf-8");


        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            if (String.class.equals(type)) {
                return new Converter<ResponseBody, String>() {
                    @Override
                    public String convert(ResponseBody value) throws IOException {
                        return value.string();
                    }
                };
            }
            return null;
        }

        @Override public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                                        Annotation[] methodAnnotations, Retrofit retrofit) {
            if (String.class.equals(type)) {
                return new Converter<String, RequestBody>() {
                    @Override
                    public RequestBody convert(String value) throws IOException {
                        return RequestBody.create(MEDIA_TYPE, value);
                    }
                };
            }
            return null;
        }
    }

}
