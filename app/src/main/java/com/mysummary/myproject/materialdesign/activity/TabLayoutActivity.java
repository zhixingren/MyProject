package com.mysummary.myproject.materialdesign.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mysummary.myproject.R;
import com.mysummary.myproject.materialdesign.adapter.TabPagerAdapter;
import com.mysummary.myproject.materialdesign.adapter.TabPagerAdapter1;
import com.mysummary.myproject.materialdesign.fragment.TabFragment;
import com.mysummary.myproject.materialdesign.fragment.TabFragment1;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
//如果根布局设置为constaintlayout 点击tab 不能进入相应页面

    TabLayout tab_layout ;
    ViewPager viewPager ;
    List<TabFragment1> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        initView();

    }

    private void initView() {
        tab_layout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);


        String[] array = getResources().getStringArray(R.array.apples);

        mFragments = new ArrayList<>();
        for (String name:
             array) {
            TabFragment1 fragment1 = TabFragment1.newInstance(name);
            mFragments.add(fragment1);
        }


        TabPagerAdapter1 adapter1 = new TabPagerAdapter1(getSupportFragmentManager(),mFragments,array);
        viewPager.setAdapter(adapter1);

        tab_layout.setupWithViewPager(viewPager);





//        mFragments = new ArrayList<>();
//        String[] array = getResources().getStringArray(R.array.apples);
//        for (String name : array
//             ) {
//            TabFragment tabFragment = TabFragment.newInstance(name);
//            mFragments.add(tabFragment);
//        }
//
//        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager(),mFragments,array);
//
//
//        viewPager.setAdapter(adapter);
//
//        tab_layout.setupWithViewPager(viewPager);
//
//        // 设置TabLayout滑动模式
//        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

}
