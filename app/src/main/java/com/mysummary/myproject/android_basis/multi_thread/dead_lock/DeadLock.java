package com.mysummary.myproject.android_basis.multi_thread.dead_lock;

/**
 * Created by xingzhi on 2018/7/16.
 */
/*
https://blog.csdn.net/ns_code/article/details/17200937

当A拥有locka,去竞争lockb，B拥有lockb去竞争locka时会出现，死锁现象
 */
public class DeadLock implements Runnable {

    A a = new A();
    B b = new B();

    public void init(){

        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入主线程后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入副线程后");
    }

    public static void main(String[] args){
        DeadLock lock = new DeadLock();
        new Thread(lock).start();
        lock.init();

    }

}
