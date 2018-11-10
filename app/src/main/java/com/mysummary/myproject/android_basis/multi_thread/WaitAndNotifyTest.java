package com.mysummary.myproject.android_basis.multi_thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by xingzhi on 2018/7/12.
 */
//https://blog.csdn.net/u013256816/article/details/50440123
/*
    wait()与
*/
public class WaitAndNotifyTest {

    public static Object object = new Object();

    static class Thread1 implements Runnable
    {
        @Override
        public void run()
        {
            synchronized(object)
            {
                System.out.println(Thread.currentThread().getName()+" is running.");
                try
                {
                    object.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" get the lock.");
            }
        }
    }

    static class Thread2 implements Runnable
    {
        @Override
        public void run()
        {
            synchronized(object)
            {
                System.out.println(Thread.currentThread().getName()+" is running.");
                object.notify();
                System.out.println(Thread.currentThread().getName()+" invoke notify()");
                System.out.println(Thread.currentThread().getName()+" release the lock.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();

        //Thread.sleep(5);
        thread2.start();
    }
}
