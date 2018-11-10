package com.mysummary.myproject.android_basis.event_dispatch;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by xingzhi on 2018/4/11.
 */

public class DispatchButton extends AppCompatButton {

    private String TAG = "DispatchButton";

    public DispatchButton(Context context) {
        super(context);
    }

    public DispatchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }

}
