package com.mysummary.myproject.android_basis.service.bindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.R;

public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener,ServiceConnection{

    private Button btn_bind_service,btn_pause_service,btn_stop_service,btn_start_service;
    private ServiceBind  serviceBind ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        iniiView();

    }

    private void iniiView() {
        btn_bind_service = findViewById(R.id.btn_bind_service);
        btn_pause_service = findViewById(R.id.btn_pause_service);
        btn_stop_service = findViewById(R.id.btn_stop_service);
        btn_start_service = findViewById(R.id.btn_start_service);

        btn_bind_service.setOnClickListener(this);
        btn_pause_service.setOnClickListener(this);
        btn_stop_service.setOnClickListener(this);
        btn_start_service.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_bind_service:
                intent.setClass(BindServiceActivity.this,ServiceBind.class);
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_start_service:
                serviceBind.play();
                break;
            case R.id.btn_pause_service:
                serviceBind.pause();
                break;
            case R.id.btn_stop_service:
               serviceBind.stop();
               unbindService(this);
                break;
        }


    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        ServiceBind.MyBinder myBinder = (ServiceBind.MyBinder)service;
        serviceBind = myBinder.getServiceBind();

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

}

