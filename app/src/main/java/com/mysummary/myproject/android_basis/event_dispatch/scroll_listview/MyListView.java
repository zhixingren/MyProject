package com.mysummary.myproject.android_basis.event_dispatch.scroll_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by xingzhi on 2018/9/17.
 */

//内部拦截法，让父view的onInterceptTouchEvent不拦截,
//此拦截方法必须是viewgroup的，不能是scrollview的。
//如果是内部拦截法，不需要自定义Scrollview,直接自定义listview就可以了

public class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //将事件拦截，进入到自己的onTouchEvent中
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }


    float initY = 0;
    boolean flag = true;
    float y  ;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        float initX = 0;

        //float y = 0 ;

        float currentHeight = this.getHeight();

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                initX = ev.getX();
                initY = ev.getY();
                Log.e("onTouchEvent2","initX--"+initX+"--"+"initY"+"--"+initY);
                break;
            case MotionEvent.ACTION_MOVE:

                float x = ev.getX();
                y = ev.getY();

                Log.e("onTouchEvent4","initY--"+initY+"--"+"y"+"--"+y);
                //不让父view（scrollview）拦截，即自己处理事件
                getParent().requestDisallowInterceptTouchEvent(true);
                //
                if (y-initY>0&&this.getFirstVisiblePosition()==0&& this.getChildAt(0).getTop() >= this.getPaddingTop()){
                    //当第一条全部可见，让父view去处理事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                    Log.e("top","initY--"+initY+"--"+"y"+"--"+y);

                    //返回false说明不消费事件，并且返回给父view处理
                    return false;
                }
                //&&currentHeight == this.getChildAt(this.getChildCount()-1).getBottom()
                if (y-initY<0&&this.getLastVisiblePosition()==getCount()-1&&currentHeight == this.getChildAt(this.getChildCount()-1).getBottom()){
                    //当最后一条全部可见，让父view去处理事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                    Log.e("bottom","initY--"+initY+"--"+"y"+"--"+y);

                    //返回false说明不消费事件，并且返回给父view处理
                    return  false ;
                }

                break;
//            case MotionEvent.ACTION_UP:
//                getParent().requestDisallowInterceptTouchEvent(false);
//                break;

        }

        //返回super.onTouchEvent(ev) 因为要在其中做一些原始操作，比如滑动滚动之类的
        return super.onTouchEvent(ev);
    }


}
