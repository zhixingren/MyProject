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

public class Dispatchlinearlayout extends LinearLayout {

    private String TAG = "Dispatchlinearlayout";

    public Dispatchlinearlayout(Context context) {
        super(context);
    }

    public Dispatchlinearlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Dispatchlinearlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent");

//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG,"ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG,"ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG,"ACTION_UP");
//                break;
//
//        }

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
    * 1.如果viewgroup的dispatchTouchEvent返回true，事件将停止传递。不向上，不向下.
    * 2.如果viewgroup的dispatchTouchEvent返回false,回传给父viewgroup或者activity的onTouchEvent.
    * 3.如果viewgroup的dispatchTouchEvent返回super,则向下传递。首先问自己的onInterceptTouchEvent，是否拦截，默认是false不拦截的.
    *   此时onInterceptTouchEvent返回false和super都会向下传递到子viewgroup或者子view的dispatchTouchEvent进行分发.
    *   如果onInterceptTouchEvent返回true表示拦截，则会问自己的onTouchEvent，如果返回true，即消费，返回false和super则向上传递。
    * 4.当viewgroup的onInterceptTouchEvent返回true时，如果子view有点击事件，将不会响应，因为已经被拦截。如果此时自己有响应事件则响应自己的点击事件。
    *
    *
    *
    * */
}
