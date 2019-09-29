package com.mysummary.myproject.android_basis.recyclerview1.recyclerview.ui;

import android.content.Context;
import android.view.ViewGroup;

import com.mysummary.myproject.android_basis.recyclerview1.lemon.view.adapter.BaseViewHolder;
import com.mysummary.myproject.android_basis.recyclerview1.lemon.view.adapter.RecyclerAdapter;
import com.mysummary.myproject.android_basis.recyclerview1.recyclerview.ui.bean.Consumption;


public class CardRecordAdapter extends RecyclerAdapter<Consumption> {

    public CardRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<Consumption> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new CardRecordHolder(parent);
    }
}