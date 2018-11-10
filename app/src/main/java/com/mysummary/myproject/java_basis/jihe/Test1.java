package com.mysummary.myproject.java_basis.jihe;

import java.util.HashSet;

/**
 * Created by xingzhi on 2018/6/13.
 */

public class Test1 {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        String a = new String("qq");
        String b = new String("qq");



        hashSet.add(a);
        hashSet.add(b);

        System.out.print(hashSet);
        System.out.print(a.getClass().hashCode()+'\n');
        System.out.print(b.getClass().hashCode()+'\n');

        String c = "qq";
        String d = "qq";


        System.out.print(c.getClass().hashCode()+"----"+d.getClass().hashCode());

    }
}
