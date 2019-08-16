package com.mysummary.myproject.java_basis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xingzhi on 2019/7/23.
 */
public class KeywordsDemo {
}

/**
 * final
 */
 class Test {
    public static void main(String[] args)  {
        MyClass myClass = new MyClass();
        int i = 0 ;
        myClass.changeValueInt(i);
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

class MyClass {
    void changeValue(StringBuffer buffer) {//值传递
        buffer.append("world");
    }
    //int k = 0 ;
    void changeValueInt(int k){
        k++;
       System.out.println(k);
    }
}