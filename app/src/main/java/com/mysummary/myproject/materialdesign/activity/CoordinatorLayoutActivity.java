package com.mysummary.myproject.materialdesign.activity;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mysummary.myproject.R;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    AppBarLayout.ScrollingViewBehavior a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);

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
        collapsingToolbarLayout.setTitle("collapsingToolbarLayout");






    }
}
