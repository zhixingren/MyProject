package com.mysummary.myproject.android_basis.event_dispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by xingzhi on 2018/4/11.
 */

public class Dispatchlinearlayout1 extends LinearLayout {

    private String TAG = "Dispatchlinearlayout1";

    public Dispatchlinearlayout1(Context context) {
        super(context);
    }

    public Dispatchlinearlayout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Dispatchlinearlayout1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.e(TAG,"onInterceptTouchEvent");
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }

    /*
    * 1.如果dispatch返回true，事件将停止传递。返回false则向上传递到上层onTouchEvent，这里指的是activity的onTouchEvent。
    *   如果想要事件传递，则必须调用super.dispatchTouchEvent().
    * 2.onInterceptTouchEvent如果调用super.onInterceptTouchEvent(ev)或者false,
    *
    *
    *
    * */
}
