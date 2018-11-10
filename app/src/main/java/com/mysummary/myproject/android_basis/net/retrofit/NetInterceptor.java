package com.mysummary.myproject.android_basis.net.retrofit;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;

import com.mysummary.myproject.android_basis.net.config.NetConfig;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NetInterceptor implements Interceptor {

    private Map<String, String> map ;

    public NetInterceptor(Map<String, String> map) {
        this.map = map ;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

//        builder.addHeader("devicetype", "device_type_pad");
//        builder.addHeader("deviceid", getAndroidID(mContext.getApplicationContext()));
//        builder.addHeader("appversion", getVersionName(mContext.getApplicationContext()) + "");
        if (map != null) {
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                builder.addHeader(next.getKey(),next.getValue());

            }

        }

        //Log.i("Request==>", request.toString());

        Response response = chain.proceed(builder.build());

        Headers requestHeaders = response.networkResponse().request().headers();
        int requestHeadersLength = requestHeaders.size();

        for (int i = 0; i < requestHeadersLength; i++) {
            String headerName = requestHeaders.name(i);
            String headerValue = requestHeaders.get(headerName);
           // Log.i("Response==>", "Name:" + headerName + "-->Value:" + headerValue);
        }
        if (true) {
            if (response != null) {
                    ResponseBody responseBodyCopy = response.peekBody(Long.MAX_VALUE);
                    String body = responseBodyCopy.string();
                  //  Log.i("服务器返回数据==>", body);
            }
        }
        return response;
    }




}
