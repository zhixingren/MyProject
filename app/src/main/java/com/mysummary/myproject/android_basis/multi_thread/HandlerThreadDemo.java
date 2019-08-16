package com.mysummary.myproject.android_basis.multi_thread;

import android.app.IntentService;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mysummary.myproject.R;

import java.lang.ref.WeakReference;

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

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(10000);
            }
        });

        thread.start();


//        //创建
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


//        mHandlerThread.quit();

        new MyAsyncTask(this).execute();




        //new Thread(new MyRunnable()).start();


    }



   static class MyRunnable implements Runnable{

        @Override

        public void run() {

            SystemClock.sleep(10000);

        }

    }





    static class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        private WeakReference<Context> weakReference;

        public MyAsyncTask(Context context) {

            weakReference = new WeakReference<>(context);

        }

        @Override

        protected Void doInBackground(Void... params) {

            SystemClock.sleep(10000);

            return null;

        }

        @Override

        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);

            HandlerThreadDemo activity = (HandlerThreadDemo) weakReference.get();

            if (activity != null) {

                //...

            }

        }

    }




}
