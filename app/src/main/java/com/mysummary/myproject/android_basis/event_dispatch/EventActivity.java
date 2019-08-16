package com.mysummary.myproject.android_basis.event_dispatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.event_dispatch.nest_scroll_recycl_viewpage.NestScrollRecyclViewPagerActivity;
import com.mysummary.myproject.android_basis.event_dispatch.nestscrollrecyclerview.NestScrollRecyclerViewActivity;
import com.mysummary.myproject.android_basis.event_dispatch.scroll_listview.ScrollListVIewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by xingzhi on 2018/4/11.
 */
/*

https://blog.csdn.net/carson_ho/article/details/54136311
https://juejin.im/entry/5796159ac4c971005421be1a
 */


public class EventActivity extends AppCompatActivity {

    private String TAG = "EventActivity";

    @BindView(R.id.bt)
    Button button ;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);


        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,v.getClass().getName()+"----bt1");
            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,v.getClass().getName()+"----bt2");
            }
        });

        findViewById(R.id.ll1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,v.getClass().getName()+"----ll");
            }
        });

    }

    @OnClick({R.id.bt,R.id.bt_nest,R.id.bt_v})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.bt:
                startActivity(new Intent(EventActivity.this, ScrollListVIewActivity.class));
                break;
            case R.id.bt_nest:
                startActivity(new Intent(EventActivity.this, NestScrollRecyclerViewActivity.class));
                break;

            case R.id.bt_v:
                startActivity(new Intent(EventActivity.this, NestScrollRecyclViewPagerActivity.class));
                break;

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("demo","MainActivity-----------onTouchEvent--------------" + event.getAction());
        //super.onTouchEvent(event);
        return false;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("demo","MainActivity-----------dispatchTouchEvent--------" + event.getAction());
//        super.dispatchTouchEvent(event);
        return  super.dispatchTouchEvent(event);
    }

    /**
     * ACTION_DOWN = 0
     * ACTION_UP = 1
     * ACTION_MOVE = 2
     * ACTION_CANCEL = 3
     *
     *
     *
        1.activity的dispatchTouchEvent返回true或者false,事件被消费，停止传递。
          如果onTouchEvent返回true（此时不做讨论，因为在window边界以外,如果返回false,未消费（默认,也不做谈论）
        2.只有当dispatchTouchEvent返回super.dispatchTouchEvent(event)时，才向下传递。

     */


}
