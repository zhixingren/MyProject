package com.mysummary.myproject.materialdesign.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.mysummary.myproject.R;

/**
 * Created by xingzhi on 2018/4/20.
 */

public class DependencyViewBehavior extends CoordinatorLayout.Behavior<AppCompatTextView> {

    public DependencyViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //表示是否给应用了Behavior 的View 指定一个依赖的布局，对应的就是
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppCompatTextView child, View dependency) {

        return dependency.getId()== R.id.dp_view;
    }
    //类似于监听动作改变的监听器
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppCompatTextView child, View dependency) {

        float x = dependency.getX();
        float y = dependency.getY();

        child.setX(x);
        child.setY(y+dependency.getHeight());

        child.setText("X: " + dependency.getX() + ", Y: " + dependency.getY());


        return true;
    }
}
