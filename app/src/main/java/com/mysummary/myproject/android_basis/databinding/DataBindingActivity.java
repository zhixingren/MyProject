package com.mysummary.myproject.android_basis.databinding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.databinding.activity.DataBindingSimpleActivity;
import com.mysummary.myproject.android_basis.databinding.activity.PracticeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataBindingActivity extends AppCompatActivity {

    @BindView(R.id.btn_simple)
    Button button1;
    @BindView(R.id.btn_list)
    Button button2;
    @BindView(R.id.btn_two_way_binding)
    Button button3;
    @BindView(R.id.btn_lambda)
    Button button4;
    @BindView(R.id.btn_expression)
    Button button5;
    @BindView(R.id.btn_animation)
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding2);

        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_simple,R.id.btn_list,R.id.btn_two_way_binding,R.id.btn_lambda,R.id.btn_expression,R.id.btn_animation})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btn_simple:
                    startActivity(new Intent(this, DataBindingSimpleActivity.class));
                break;
            case R.id.btn_list:
                startActivity(new Intent(this, PracticeActivity.class));
                break;
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
