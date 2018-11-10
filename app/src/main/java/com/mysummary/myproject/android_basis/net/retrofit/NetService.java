package com.mysummary.myproject.android_basis.net.retrofit;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.mysummary.myproject.android_basis.net.config.NetConfig;
import com.mysummary.myproject.android_basis.net.cookie.PersistentCookieStore;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xingzhi on 2018/9/19.
 */

public class NetService {

    private final long connectTimeoutMills = 60 ;
    private final long readTimeoutMills = 60 ;
    private Context context ;
    private NetInterfaces httpService ;


    private static class NetInstance{
        private static NetService netService = new NetService();
    }

    public static NetService getInstance(){
        return NetInstance.netService;
    }


    public Retrofit getRetrofit(Map<String, String> map,Context context){
        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl(NetConfig.ServerRootUrl)
                .client(getClient(map,context))
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return retrofit.build();

    }

    public NetInterfaces getHttpInterface(Map<String, String> header,Context context){
        httpService = getRetrofit(header,context).create(NetInterfaces.class);
       return httpService ;
    }


    private OkHttpClient getClient(Map<String, String> map,Context context) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(connectTimeoutMills, TimeUnit.SECONDS);
        builder.readTimeout(readTimeoutMills,TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        builder.cookieJar(new CookiesManager(context));
        //builder.addInterceptor();
        //添加拦截器
        addInterceptors(builder,map);


        return builder.build();
    }



    private void addInterceptors(OkHttpClient.Builder builder,Map<String, String> map) {

        //请求与相应拦截器
        builder.addInterceptor(new NetInterceptor(map));

        //日志拦截器
        if (true){
            //日志显示级别
            HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
            //新建log拦截器
            HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.d("rxz","OkHttp====Message:"+message);
                }
            });
            loggingInterceptor.setLevel(level);
            builder.addInterceptor(loggingInterceptor);
        }



    }

    /**
     * 自动管理Cookies
     */
    private static class CookiesManager implements CookieJar {
        private PersistentCookieStore cookieStore = null;
        private Context mContext;

        public CookiesManager(Context context) {
            this.mContext = context;
            if (cookieStore == null) {
                cookieStore = PersistentCookieStore.getInstance(mContext);
            }
        }

        public PersistentCookieStore getCookieStore() {
            return cookieStore;
        }

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            if (cookies != null && cookies.size() > 0) {
                for (Cookie item : cookies) {
                    cookieStore.add(url, item);
                }
            }
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url);
            return cookies;
        }
    }

}
