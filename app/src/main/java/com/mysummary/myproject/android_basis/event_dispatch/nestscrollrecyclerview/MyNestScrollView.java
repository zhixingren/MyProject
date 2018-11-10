package com.mysummary.myproject.android_basis.event_dispatch.nestscrollrecyclerview;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by xingzhi on 2018/8/23.
 */


//外部拦截法：在外部分父view的拦截方法中根据具体条件进行拦截。
public class MyNestScrollView extends NestedScrollView {


    RecyclerView lv ;

    public MyNestScrollView(Context context) {
        super(context);
    }

    public MyNestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int nowY ;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int y = (int) event.getY();

        Log.e("intercept","inter");

        Log.e("y",y+"");

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                nowY = y;
                Log.e("yy",y+"");
                intercepted = false;
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("yyy",y+"");

                RecyclerView.LayoutManager layoutManager = lv.getLayoutManager();
                View viewByPosition = layoutManager.findViewByPosition(0);
                View viewByPosition1 = layoutManager.findViewByPosition(lv.getAdapter().getItemCount());


                if (viewByPosition.getVisibility() == View.VISIBLE && event.getY()>nowY){
                    intercepted = true;
                    break;
                }else

                if (viewByPosition1.getVisibility() == View.VISIBLE && event.getY()<nowY){
                    intercepted = true;
                    break;
                }

                intercepted = false ;

                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
        }




        return intercepted;


    }

    public void setListView(RecyclerView lv ){

       this.lv = lv ;


    }
}
