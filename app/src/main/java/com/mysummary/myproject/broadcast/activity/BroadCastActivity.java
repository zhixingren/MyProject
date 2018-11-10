package com.mysummary.myproject.broadcast.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.R;
import com.mysummary.myproject.broadcast.receiver.NetworkStateReceiver;

//https://www.jianshu.com/p/ca3d87a4cdf3
public class BroadCastActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_send_broadcast ;
    private NetworkStateReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        btn_send_broadcast  = findViewById(R.id.btn_send_broadcast);
        btn_send_broadcast.setOnClickListener(this);

        //动态注册广播
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("com.to.broadcast");
//        MyBroadCastReciver reciver = new MyBroadCastReciver();
//        registerReceiver(reciver,filter);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkStateReceiver();
        registerReceiver(receiver,filter);

    }

    //发送广播
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_broadcast:
                Intent intent = new Intent();
                intent.setAction("com.to.broadcast");
                intent.putExtra("hello","你好");
                sendBroadcast(intent);
                break;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
