package com.mysummary.myproject.android_basis.databinding.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xingzhi on 2018/8/14.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{

    private T mBinding ;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding ;
    }


    public T getmBinding(){

        return mBinding ;
    }

}
