package com.mysummary.myproject.android_basis.service.startservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.mysummary.myproject.R;

import java.util.ArrayList;
import java.util.Iterator;

public class StartServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_start_service,btn_stop_service,btn_pause_service;
    private int START_TYPE = 0;
    private int PAUSE_TYPE = 1;
    private int STOP_TYPE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        iniiView();

    }

    private void iniiView() {
        btn_start_service = findViewById(R.id.btn_start_service);
        btn_stop_service = findViewById(R.id.btn_stop_service);
        btn_pause_service = findViewById(R.id.btn_pause_service);
        btn_stop_service.setOnClickListener(this);
        btn_start_service.setOnClickListener(this);
        btn_pause_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_start_service:
                intent.setClass(StartServiceActivity.this,ServiceStart.class);
                intent.putExtra("type",START_TYPE);
                break;
            case R.id.btn_pause_service:
                intent.putExtra("type",PAUSE_TYPE);
                intent.setClass(StartServiceActivity.this,ServiceStart.class);
                break;
            case R.id.btn_stop_service:
                intent.putExtra("type",STOP_TYPE);
                intent.setClass(StartServiceActivity.this,ServiceStart.class);
                break;
        }
                startService(intent);

    }
}
