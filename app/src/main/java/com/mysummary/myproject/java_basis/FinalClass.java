package com.mysummary.myproject.java_basis;

/**
 * Created by xingzhi on 2019-07-29.
 */
public class FinalClass {
}

class FinalExample {
    int i;
    final int j ;
    static FinalExample obj;

    public FinalExample () {
        i = 1;                   // 1
        j = 2;                   // 2
    }

    public static void writer () {  //写线程A
        obj = new FinalExample ();  // 3
    }

    public static void reader () {       //读线程B执行
        if(obj != null) {               //4
            int a = obj.i;           //5
            int b = obj.j;           //6
        }
    }
}