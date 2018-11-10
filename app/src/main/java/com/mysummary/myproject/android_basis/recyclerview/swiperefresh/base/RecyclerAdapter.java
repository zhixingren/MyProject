package com.mysummary.myproject.android_basis.recyclerview.swiperefresh.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mysummary.myproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xingzhi on 2018/7/11.
 */

public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {



    private static final String TAG = "RecyclerAdapter";
    private Context mContext;
    private List<T> mData = new ArrayList<>();


    private static final int HEADER_TYPE = 111;
    private static final int FOOTER_TYPE = 222;
    protected static final int STATUS_TYPE = 333;
    protected int mViewCount = 0;

    protected View mStatusView;
    protected LinearLayout mLoadMoreView;
    public TextView mNoMoreView;
    private View headerView;
    private View footerView;

    private boolean hasHeader = false;
    private boolean hasFooter = false;


    public RecyclerAdapter(Context context) {
        mContext = context;
        initStatusView(context);
    }

    public RecyclerAdapter(Context context,T[] t){
        this(context,Arrays.asList(t));
    }

    public RecyclerAdapter(Context context, List<T> data) {
        mContext = context;
        this.mData = data;
        mViewCount += data.size();
        initStatusView(context);
    }

    public void initStatusView(Context context) {
        mStatusView = LayoutInflater.from(context).inflate(R.layout.view_status_last, null);
        mStatusView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mLoadMoreView = (LinearLayout) mStatusView.findViewById(R.id.load_more_view);
        mNoMoreView = (TextView) mStatusView.findViewById(R.id.no_more_view);
//        mViewCount++;
    }

    public abstract BaseViewHolder<T> onCreateBaseViewHolder(ViewGroup parent, int viewType);


    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEADER_TYPE) {
            return new BaseViewHolder(headerView);
        } else if (viewType == FOOTER_TYPE) {
            return new BaseViewHolder(footerView);
        } else if (viewType == STATUS_TYPE) {
            return new BaseViewHolder(mStatusView);
        } else
            return onCreateBaseViewHolder(parent, viewType);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {


    }

    @Override
    public int getItemCount() {

        return mViewCount;
    }



    public void setHeader(View header) {
        hasHeader = true;
        headerView = header;
        mViewCount++;
    }

    public void setHeader(@LayoutRes int res) {
        setHeader(LayoutInflater.from(mContext).inflate(res, null));
    }

    public View getHeader() {
        return headerView;
    }

    public View getFooter() {
        return footerView;
    }

    public void setFooter(View footer) {
        hasFooter = true;
        footerView = footer;
        mViewCount++;
    }

    public void setFooter(@LayoutRes int res) {
        setFooter(LayoutInflater.from(mContext).inflate(res, null));
    }
}
