package com.mysummary.myproject.android_basis.multi_thread.synchroniz;

import android.util.Log;

/**
 * Created by xingzhi on 2018/7/13.
 */

public class DrawThread extends Thread {

    private Account account ;
    private double drawAmount ;
    private String TAG = "DrawThread";

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {

        account.draw(drawAmount);
        //super.run();
//----------1-----------同步代码块
//        synchronized (account) {
//            if (account.getBalance() >= drawAmount) {
//                System.out.println(getName() + "取钱成功！" + drawAmount);
//
//
//                try {
//
//                    Thread.sleep(1);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                account.setBalance(account.getBalance() - drawAmount);
//                System.out.println("余额为" + account.getBalance());
//
//            } else {
//                System.out.println("余额不足！");
//            }

//        }
//----------1-----------
    }
}
