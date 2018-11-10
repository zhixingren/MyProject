package com.mysummary.myproject.android_basis.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.service.bindservice.BindServiceActivity;
import com.mysummary.myproject.android_basis.service.startservice.StartServiceActivity;
/*



 */
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_to_startervice,btn_to_bindservice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initView();
    }

    private void initView() {
        btn_to_startervice = findViewById(R.id.btn_to_startervice);
        btn_to_bindservice = findViewById(R.id.btn_to_bindservice);
        btn_to_startervice.setOnClickListener(this);
        btn_to_bindservice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();;
        switch (v.getId()){
            case R.id.btn_to_startervice:
                intent.setClass(ServiceActivity.this,StartServiceActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_to_bindservice:
                intent.setClass(ServiceActivity.this,BindServiceActivity.class);
                startActivity(intent);
                break;

        }
    }
}
