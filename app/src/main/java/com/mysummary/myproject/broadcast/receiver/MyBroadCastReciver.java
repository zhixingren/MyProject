package com.mysummary.myproject.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by xingzhi on 2018/4/20.
 */

public class MyBroadCastReciver  extends BroadcastReceiver {

    private String TAG = "MyBroadCastReciver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,intent.getStringExtra("hello"));
    }
}
