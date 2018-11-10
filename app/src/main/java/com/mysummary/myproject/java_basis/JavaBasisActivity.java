package com.mysummary.myproject.java_basis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.MainActivity;
import com.mysummary.myproject.R;
import com.mysummary.myproject.java_basis.fanxing.FanXingActivity;
import com.mysummary.myproject.java_basis.类加载.A;

public class JavaBasisActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_basis);


        initView();

    }

    private void initView() {
        btn_t = findViewById(R.id.btn_t);
        btn_t.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_t:
                //startActivity(new Intent(JavaBasisActivity.this, FanXingActivity.class));


                break;

        }
    }
}
