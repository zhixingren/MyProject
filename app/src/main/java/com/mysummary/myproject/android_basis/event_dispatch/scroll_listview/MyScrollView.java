package com.mysummary.myproject.android_basis.event_dispatch.scroll_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by xingzhi on 2018/8/23.
 */


//外部拦截法：在外部分父view的拦截方法中根据具体条件进行拦截。
public class MyScrollView extends ScrollView {


    ListView lv;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
//    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e("dispatchTouchEvent",ev.getAction()+"");

        return super.dispatchTouchEvent(ev);
    }

//    float last;
//    float nowY;
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//
//        //ScrollView在该方法中进行了一些赋值操作，
//        super.onInterceptTouchEvent(event);
//        boolean intercepted = false;
//
//        //last =  event.getY();
//        int currentHeight = lv.getHeight();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                last = event.getY();
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                nowY = event.getY();
//                if (lv.getFirstVisiblePosition() == 0 && nowY - last > 0 && lv.getChildAt(0).getTop() >= lv.getPaddingTop()) {
//                    intercepted = true;
//                    break;
//                }
//                Log.e("Position", lv.getLastVisiblePosition() + "");
//                Log.e("getCount", (lv.getCount() - 1) + "");
//                Log.e("nowY", nowY + "");
//                Log.e("last", last + "");
//                Log.e("currentHeight", currentHeight + "");
//                Log.e("getChildAt", lv.getChildAt(lv.getChildCount() - 1).getBottom()+"");
//
//                if (lv.getLastVisiblePosition() == lv.getCount() - 1 && nowY - last < 0 && currentHeight == lv.getChildAt(lv.getChildCount() - 1).getBottom()) {
//                    intercepted = true;
//                    break;
//                }
//
//                break;
//            case MotionEvent.ACTION_UP:
//                intercepted = false;
//                break;
//        }
//
//        return intercepted;
//    }
//
//    public void setListView(ListView lv) {
//
//        this.lv = lv;
//    }
//

}
