package com.mysummary.myproject.android_basis.recyclerview.swiperefresh.base;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;

import com.mysummary.myproject.R;


/**
 * 继承自SwipeRefreshLayout,从而实现滑动到底部时上拉加载更多的功能.
 *
 * @author mrsimple
 */
public class RefreshLayout extends SwipeRefreshLayout {

    /**
     * 滑动到最下面时的上拉操作
     */

    private int mTouchSlop;
    /**
     * listview实例
     */
    private RecyclerView mRecycleView;
    private ListView mListView;

    /**
     * 上拉监听器, 到了最底部的上拉加载操作
     */
    private OnLoadListener mOnLoadListener;

    /**
     * ListView的加载中footer
     */
    private View mListViewFooter;

    /**
     * 按下时的y坐标
     */
    private int mYDown;
    /**
     * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
     */
    private int mLastY;
    /**
     * 是否在加载中 ( 上拉加载更多 )
     */
    private boolean isLoading = false;

    /**
     * 是否可以上拉加载更多
     */
    private boolean isLoadEnable = true;

    private int scrollState;

    private float mPrevX;

    private ListViewOnScrolllistener listViewOnScrolllistener;

    /**
     * @param context
     */
    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mListViewFooter = LayoutInflater.from(context).inflate(R.layout.view_list_footer, null, false);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // 初始化ListView对象
        if (mListView == null && mRecycleView == null) {
            getListView();
        }
    }

    /**
     * 获取ListView对象
     */
    private void getListView() {
        int childs = getChildCount();
        if (childs > 0) {
            View childView = getChildAt(0);
            if (childView instanceof RecyclerView) {
                mRecycleView = (RecyclerView) childView;
                // 设置滚动监听器给ListView, 使得滚动的情况下也可以自动加载
                mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        // 滚动时到了最底部也可以加载更多
                        if (canLoad()) {
                            loadData();
                        }
                    }

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        scrollState = newState;
                    }
                });
            }

            if (childView instanceof ListView) {
                mListView = (ListView) childView;
                mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                        scrollState = i;
                    }

                    @Override
                    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                        // 滚动时到了最底部也可以加载更多
                        if (canLoad()) {
                            loadData();
                        }

                        if (listViewOnScrolllistener != null) {
                            listViewOnScrolllistener.onScroll(absListView, i, i1, i2);
                        }
                    }
                });
                Log.d(VIEW_LOG_TAG, "### 找到listview");
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see android.view.ViewGroup#dispatchTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 按下
                mYDown = (int) event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                // 移动
                mLastY = (int) event.getRawY();
                break;

            case MotionEvent.ACTION_UP:
                // 抬起
                if (canLoad()) {
                    loadData();
                }
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    /**
     * 是否可以加载更多, 条件是到了最底部, listview不在加载中, 且为上拉操作.
     *
     * @return
     */
    private boolean canLoad() {
        return isBottom() && !isLoading && isPullUp() && isLoadEnable;
    }

    /**
     * 判断是否到了最底部
     */
    private boolean isBottom() {
        if (mListView == null && mRecycleView == null) {
            return false;
        } else {
            if (mRecycleView != null) {
                LinearLayoutManager lm = (LinearLayoutManager) mRecycleView.getLayoutManager();
                int position = lm.findLastVisibleItemPosition();
                int count = lm.getItemCount();
                return position == count - 1 && (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING || scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            } else {
                int position = mListView.getLastVisiblePosition();
                int count = 0;
                if (mListView.getAdapter() != null) {
                    count = mListView.getAdapter().getCount();
                }
                return position == (count - 1) && (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING || scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }
        }
    }

    /**
     * 是否是上拉操作
     *
     * @return
     */
    private boolean isPullUp() {
        return (mYDown - mLastY) >= mTouchSlop;
    }

    /**
     * 如果到了最底部,而且是上拉操作.那么执行onLoad方法
     */
    private void loadData() {
        if (mOnLoadListener != null) {
            mOnLoadListener.onLoad();
            // 设置状态
            setLoading(true);
        }
    }

    /**
     * @param loading
     */
    public void setLoading(boolean loading) {
        isLoading = loading;
        if (isLoading) {
            if (mListView != null) {
                mListView.addFooterView(mListViewFooter);
            }
        } else {
            if (mListView != null) {
                Adapter adapter = mListView.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    mListView.removeFooterView(mListViewFooter);
                }
            }
            mYDown = 0;
            mLastY = 0;
        }
    }

    public boolean isLoading() {
        return isLoading;
    }

    /**
     * @param loadListener
     */
    public void setOnLoadListener(OnLoadListener loadListener) {
        mOnLoadListener = loadListener;
        setLoadEnable(true);
    }

    /**
     * 设置是否可以上拉加载更多
     *
     * @param enable
     */
    public void setLoadEnable(boolean enable) {
        this.isLoadEnable = enable;
    }

    /**
     * 加载更多的监听器
     *
     * @author mrsimple
     */
    public interface OnLoadListener {
        void onLoad();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPrevX = MotionEvent.obtain(event).getX();
                break;

            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                float xDiff = Math.abs(eventX - mPrevX);

                if (xDiff > mTouchSlop) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(event);
    }

    public interface ListViewOnScrolllistener {
        void onScroll(AbsListView absListView, int i, int i1, int i2);
    }

    public void setListViewScrolllistener(ListViewOnScrolllistener listener) {
        this.listViewOnScrolllistener = listener;
    }
}