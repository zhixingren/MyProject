package com.mysummary.myproject.materialdesign.widget;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

/**
 * Created by xingzhi on 2018/4/20.
 */

public class DependencyView extends AppCompatTextView {


    public DependencyView(Context context) {
        super(context);
    }

    public DependencyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DependencyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x ;
        float y ;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

//                setX(event.getRawX());
//                setY(event.getRawY());
            break;
            case MotionEvent.ACTION_MOVE:
//                setX(event.getRawX());
//                setY(event.getRawY());
                break;
            case MotionEvent.ACTION_UP:
//                setX(event.getX());
//                setY(event.getY());
//                setX(event.getRawX());
//                setY(event.getRawY());
                break;
        }

        return true;
    }
}
