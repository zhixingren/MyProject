package com.mysummary.myproject.android_basis.donghua;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mysummary.myproject.R;

public class AnimationActivity extends AppCompatActivity {

    TextView textView ;
    Button button ;
    Button button1 ,btn_2;
    ImageView iv ;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textView = (TextView) findViewById(R.id.tv);
        button = (Button) findViewById(R.id.btn);
        button1 = (Button) findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        iv = findViewById(R.id.iv);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValueAnimator();
//
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValueAnimatior2();
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//          getPropertyAnimator()
                getObjectAnimator();

            }
        });

    }

    private void getObjectAnimator(){
//        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"alpha",0,10);
//        animator.setDuration(500);
//        animator.start();

//        float x = iv.getTranslationX();
//
//        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"translationX",x,-500,x);
//        animator.setDuration(600);
//        animator.start();

        ObjectAnimator moveIn = ObjectAnimator.ofFloat(iv, "translationX", -50f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(iv, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(iv, "alpha", 1f, 0f, 1f);

        AnimatorSet animSet = new AnimatorSet();
        //先平移，然后旋转的同时改变alpha
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();

    }


    private void getPropertyAnimator(){

        if (flag==0){
            iv.animate()
                    .translationX(300)
                    .rotation(180)
                    .setDuration(500)
                    .setInterpolator(new LinearInterpolator());
            flag ++;
        }else if (flag==1){
            iv.animate()
                    .translationX(0)
                    .rotation(0)
                    .setDuration(500)
                    .setInterpolator(new LinearInterpolator());
            flag --;
        }
    }

    //属性动画1
    //从0过渡到3
    public void getValueAnimator() {
        // 步骤1：设置动画属性的初始值 & 结束值
        ValueAnimator anim = ValueAnimator.ofInt(0, 10);
        // ofInt（）作用有两个
        // 1. 创建动画实例
        // 2. 将传入的多个Int参数进行平滑过渡:此处传入0和1,表示将值从0平滑过渡到1
        // 如果传入了3个Int参数 a,b,c ,则是先从a平滑过渡到b,再从b平滑过渡到C，以此类推
        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置，即默认设置了如何从初始值 过渡到 结束值
        // 关于自定义插值器我将在下节进行讲解
        // 下面看看ofInt()的源码分析 ->>关注1

// 步骤2：设置动画的播放各种属性
        anim.setDuration(3000);
        // 设置动画运行的时长
//        anim.setStartDelay(500);
        // 设置动画延迟播放时间
        anim.setRepeatCount(0);
        // 设置动画重复播放次数 = 重放次数+1
        // 动画播放次数 = infinite时,动画无限重复
        anim.setRepeatMode(ValueAnimator.RESTART);
        // 设置重复播放动画模式
        // ValueAnimator.RESTART(默认):正序重放
        // ValueAnimator.REVERSE:倒序回放

        //设置动画变化快慢模式
        anim.setInterpolator(new LinearInterpolator());
        //
//        anim.setEvaluator();

// 步骤3：将改变的值手动赋值给对象的属性值：通过动画的更新监听器
        // 设置 值的更新监听器
        // 即：值每次改变、变化一次,该方法就会被调用一次
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int currentValue = (Integer) animation.getAnimatedValue();
//                PropertyValuesHolder[] values = animation.getValues();
                // 获得改变后的值


                System.out.println(animation.getAnimatedValue());
                // 输出改变后的值

                // 步骤4：将改变后的值赋给对象的属性值，下面会详细说明
                    // 步骤5：刷新视图，即重新绘制，从而实现动画效果
                textView.setText(currentValue+"");
               // textView.invalidate();


            }
        });

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }
        });

        anim.start();
        // 启动动画
    }

    //属性动画2
    private void getValueAnimatior2(){
        // 步骤1：设置属性数值的初始值 & 结束值
        ValueAnimator valueAnimator = ValueAnimator.ofInt(button.getLayoutParams().width, 500);
        // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
        // 结束值 = 500
        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
        // 即默认设置了如何从初始值150 过渡到 结束值500

// 步骤2：设置动画的播放各种属性
        valueAnimator.setDuration(2000);
        // 设置动画运行时长:1s

// 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
        // 设置更新监听器：即数值每次变化更新都会调用该方法
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {

                int currentValue = (Integer) animator.getAnimatedValue();
                // 获得每次变化后的属性值
                System.out.println(button.getLayoutParams().width);
                // 输出每次变化后的属性值进行查看

                button.getLayoutParams().width = currentValue;
                // 每次值变化时，将值手动赋值给对象的属性
                // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

// 步骤4：刷新视图，即重新绘制，从而实现动画效果
                button.requestLayout();

            }
        });

        valueAnimator.start();
        // 启动动画

    }




}
