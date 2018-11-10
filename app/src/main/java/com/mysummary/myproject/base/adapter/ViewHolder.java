package com.mysummary.myproject.base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ViewHolder工具类 简化适配器中的ViewHolder编程代码
 *
 * @author qiangxu
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConverView;
    public ViewHolder(Context context, int position, ViewGroup parent, int layoutResId) {
        this.mViews = new SparseArray<View>();
        this.mPosition = position;
        this.mConverView = LayoutInflater.from(context).inflate(layoutResId, parent, false);
        this.mConverView.setTag(this);
    }

    public static ViewHolder get(Context context, int position, View convertView, ViewGroup parent, int layoutResId) {
        if (convertView == null) {
            return new ViewHolder(context, position, parent, layoutResId);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    public int getmPosition() {
        return mPosition;
    }

    public View getmConverView() {
        return mConverView;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConverView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
}
