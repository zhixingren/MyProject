package com.mysummary.myproject.android_basis.recyclerview.swiperefresh.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.mysummary.myproject.R;

/**
 * Created by xingzhi on 2018/7/11.
 */

public class RefreshRecyclerView extends FrameLayout {

    private final String TAG = "RefreshRecyclerView";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    private boolean refreshAble;
    private boolean loadMoreAble;


    public RefreshRecyclerView(@NonNull Context context) {
        this(context,null);
    }

    public RefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflate(context, R.layout.view_refresh_recycler, this);
        mSwipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        mRecyclerView = view.findViewById(R.id.recycler_view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.RecycleListView);
        refreshAble = typedArray.getBoolean(R.styleable.RefreshRecyclerView_refresh_able,true);
        loadMoreAble = typedArray.getBoolean(R.styleable.RefreshRecyclerView_load_more_able,true);

        if (!refreshAble){
            mSwipeRefreshLayout.setEnabled(false);
        }

    }





}
