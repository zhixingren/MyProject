package com.mysummary.myproject.android_basis.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mysummary.myproject.R;

/**
 * Created by xingzhi on 2018/7/11.
 */

public class DeviderDecoration extends RecyclerView.ItemDecoration  {

    private int deviderHeight = 0;
    private Paint dividerPaint;

    public DeviderDecoration(Context context) {
        //设置画笔
        dividerPaint = new Paint();
        //设置分割线颜色
        dividerPaint.setColor(Color.RED);
        //设置分割线宽度
        deviderHeight = context.getResources().getDimensionPixelSize(R.dimen.divide_height);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        super.getItemOffsets(outRect, view, parent, state);
        //改变宽度
        //设置了item偏移量，https://blog.csdn.net/w855227/article/details/80973321，这个链接中动图解释了这四个参数
        outRect.set(0,0,0,10);


    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Log.e("onDraw","onDraw");
        //得到列表所有的条目
        int childCount = parent.getChildCount();
        //得到条目的宽和高
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            //计算每一个条目的顶点和底部 float值
            float top = view.getBottom();
            float bottom = view.getBottom()+40 ;//因为getItemOffsets定义了bottom的高度是10，所以这里设置了40是没用的，只能画间隔为10的分割线，
            Log.e("ada",top+"===="+bottom);
            //重新绘制
            c.drawRect(10, top, right-10, bottom, dividerPaint);
        }

    }
}
