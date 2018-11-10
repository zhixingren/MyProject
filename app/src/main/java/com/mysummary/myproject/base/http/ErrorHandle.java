package com.mysummary.myproject.base.http;

import android.util.Log;


import com.mysummary.myproject.utils.ToastUtil;

import java.io.IOException;

import retrofit2.HttpException;


/**
 * Created by xingzhi on 2018/3/31.
 */

public class ErrorHandle {

    private static final String TAG = "ErrorHandle";

    public static void dealWithError(Throwable e){

        try {
            if (e instanceof IOException) {
            ToastUtil.showToast("网络异常！");
            }
        }catch (Exception e1){
            e1.printStackTrace();
            Log.e(TAG,"---->");

        }



        if (e instanceof HttpException) {

            HttpException he = (HttpException)e;
            try {
                String string = he.response().errorBody().string();
                Log.e(TAG,string);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }else {
            ToastUtil.showToast("网络异常！");
        }
    }
}
