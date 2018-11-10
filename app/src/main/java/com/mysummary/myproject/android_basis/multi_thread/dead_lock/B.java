package com.mysummary.myproject.android_basis.multi_thread.dead_lock;

/**
 * Created by xingzhi on 2018/7/16.
 */

public class B {

    public synchronized void bar(A a){
        System.out.println("当前线程名：" +Thread.currentThread().getName()+"  进入B实例的bar方法");

        try {

            Thread.sleep(300);

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("当前线程名：" +Thread.currentThread().getName()+"  企图调用A实例的last方法");
        a.last();

    }

    public synchronized void last(){

        System.out.println("进入B实例的last方法");

    }

}
