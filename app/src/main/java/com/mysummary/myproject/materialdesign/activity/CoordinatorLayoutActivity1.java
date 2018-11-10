package com.mysummary.myproject.materialdesign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mysummary.myproject.R;

public class CoordinatorLayoutActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("");

        initView();
        TextView textView = findViewById(R.id.tv);

        for (int i = 0; i < 100; i++) {

            textView.append(i+1+"\n");
        }


    }

    private void initView() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        // 设置展开后标题颜色
        collapsingToolbarLayout.setExpandedTitleColor(Color.RED);
        // 设置折叠后标题颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.YELLOW);
        collapsingToolbarLayout.setTitle("任行知");






    }
}
