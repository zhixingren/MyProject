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

public class TabFragment extends Fragment {


    private String tabName ;
    private TextView mTextView ;

    public static TabFragment newInstance(String tab){
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tabName",tab);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        tabName = arguments.getString("tabName");

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
        super.onViewCreated(view, savedInstanceState);

        mTextView.setText(tabName);
    }
}
