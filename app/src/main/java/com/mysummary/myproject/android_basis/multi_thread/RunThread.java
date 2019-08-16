package com.mysummary.myproject.android_basis.multi_thread;

/**
 * Created by xingzhi on 2019/2/17.
 */
public class RunThread extends Thread {

   volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        System.out.println("setRunning-----b--->"+Thread.currentThread().getName());

        this.isRunning = isRunning;
        System.out.println("setRunning----f--->"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("进入到run方法中了");
        while (isRunning == true) {
            System.out.println(Thread.currentThread().getName()+"---->while");
        }
        System.out.println("线程执行完成了");
    }

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
          //  Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName());
            thread.setRunning(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//public class Run {

//}
