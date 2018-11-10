package com.mysummary.myproject.base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiangxu on 2017/7/21.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    protected List<T> mDatas;
    protected Context mContext;
    private int mLayoutResId;

    public CommonAdapter(Context context, List<T> datas, int layoutResId) {
        this.mContext = context;
        this.mDatas = null == datas ? new ArrayList<T>() : datas;
        this.mLayoutResId = layoutResId;
    }

    public void addData(List<T> datas) {
        if (null == datas || datas.isEmpty()) {
            return;
        }
        this.mDatas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void clear(){
        this.mDatas.clear();
        this.notifyDataSetChanged();
    }

    public void setData(List<T> datas) {
        this.mDatas = null == datas ? new ArrayList<T>() : datas;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, position, convertView, parent, mLayoutResId);
        convert(holder, getItem(position), position);
        return holder.getmConverView();
    }

    public abstract void convert(ViewHolder holder, T bean, int position);

}
