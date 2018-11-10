package com.mysummary.myproject.android_basis.multi_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mysummary.myproject.R;

/**
 * Created by xingzhi on 2018/7/12.
 */
//是一种主线程通知子线程，要做什么的thread，run方法中有synchronized，说明是排队的，线程安全的
//
public class HandlerThreadDemo extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建
        HandlerThread mHandlerThread = new HandlerThread("handlerThread");
        //启动
        mHandlerThread.start();


        Handler handler = new Handler(mHandlerThread.getLooper()){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.e("TAG",Thread.currentThread().getName());//得到的名字就是上面设置的handlerThread

            }
        };

        Message message = handler.obtainMessage();
        message.arg1 = 1;
        handler.sendMessage(message);


        mHandlerThread.quit();


    }





}
