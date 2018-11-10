package com.mysummary.myproject.android_basis.multi_thread.synchroniz;

/**
 * Created by xingzhi on 2018/7/13.
 */

public class Test {


    public static void main(String[] args){

        Account account = new Account("123",1000);

        new DrawThread("甲",account,800).start();

        new DrawThread("乙",account,800).start();


    }
}
