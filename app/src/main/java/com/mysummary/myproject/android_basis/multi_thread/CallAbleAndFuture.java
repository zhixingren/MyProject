package com.mysummary.myproject.android_basis.multi_thread;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by xingzhi on 2018/7/16.
 */
/*

    看下面便可知，asynctask的原理
    https://blog.csdn.net/jdsjlzx/article/details/51407807

 */
public class CallAbleAndFuture implements Callable<Integer> {


    @Override
    public Integer call() {

        int j = 0;

        for (; j < 10; j++) {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值： "+j);
        }

        return j;
    }

    static class CallableTest{


        public static void main(String[] a){

//            try {
//                System.out.println("before---"+"主线程阻塞前！");
//                Thread.sleep(1000);
//                System.out.println("after---"+"主线程阻塞后！");
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //创建callable对象
            CallAbleAndFuture c = new CallAbleAndFuture();
            //使用FutureTask包装callable对象
            FutureTask<Integer> task = new FutureTask<>(c);


            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+" 的循环变量i的值： "+i);

                if (i == 2) {
                    new Thread(task,"有返回值的线程").start();

                }
                
            }

            try {
                System.out.println("子线程的返回值： "+task.get());

            }catch (Exception e){
                e.printStackTrace();

            }

        }

    }
}
