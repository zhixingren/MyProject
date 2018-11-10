package com.mysummary.myproject.materialdesign.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mysummary.myproject.materialdesign.fragment.TabFragment;
import com.mysummary.myproject.materialdesign.fragment.TabFragment1;

import java.util.List;

/**
 * Created by xingzhi on 2018/4/19.
 */

public class TabPagerAdapter1 extends FragmentPagerAdapter{

    List<TabFragment1> list;
    String[] arr ;



    public TabPagerAdapter1(FragmentManager fm,List<TabFragment1> f,String[] arr) {
        super(fm);
        this.list = f ;
        this.arr = arr;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return arr[position];
    }
}
