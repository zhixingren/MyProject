package com.mysummary.myproject.materialdesign.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mysummary.myproject.R;

// 标题栏（Toolbar或TabLayout）的专属滑动容器
public class AppBarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);
    }
}
