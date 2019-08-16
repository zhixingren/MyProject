package com.mysummary.myproject.android_basis.multi_thread;

/**
 * Created by xingzhi on 2019/1/8.
 */
public class ThreadClass implements Runnable{

    protected int countDown = 10;
    public static  int taskCount = 0;
    private final int id = taskCount++;

    public ThreadClass(){

    }

    public String status(){

        return "#"+id+"("+(countDown>0?countDown:"off")+").";
    }

    @Override
    public void run() {

        if (countDown-- ==10){
            System.out.println(countDown);
        }

        //(countDown = countDown-1)>0

        while (countDown-- >0){
            System.out.println(status());
            Thread.yield();
        }
//        for (int i = 3;i>0;i--){
//
//        }
//        if (countDown >0){
//            System.out.println("a"+countDown);
//        }

    }




    public static void main(String[] args){
        ThreadClass threadClass = new ThreadClass();
        threadClass.run();
    }
}
