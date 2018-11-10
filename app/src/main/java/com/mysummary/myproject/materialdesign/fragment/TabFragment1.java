package com.mysummary.myproject.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mysummary.myproject.R;

/**
 * Created by xingzhi on 2018/4/19.
 */

public class TabFragment1 extends Fragment {



    private String tabName ;
    private TextView mTextView ;

    public static TabFragment1 newInstance(String name){
        TabFragment1 fragment1 = new TabFragment1();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        tabName = bundle.getString("name");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab,container,false);
        mTextView = view.findViewById(R.id.tv);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mTextView.setText(tabName);

        super.onViewCreated(view, savedInstanceState);
    }
}
