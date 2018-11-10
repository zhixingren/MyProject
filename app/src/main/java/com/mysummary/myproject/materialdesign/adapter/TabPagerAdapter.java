package com.mysummary.myproject.materialdesign.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mysummary.myproject.materialdesign.fragment.TabFragment;

import java.util.List;

/**
 * Created by xingzhi on 2018/4/19.
 */

public class TabPagerAdapter extends FragmentPagerAdapter{

    List<TabFragment> fragments;
    String [] names ;


    public TabPagerAdapter(FragmentManager fm, List<TabFragment> fragments, String[] names) {
        super(fm);
        this.fragments = fragments;
        this.names = names ;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return names[position];
    }
}
