package com.mysummary.myproject.java_basis.jihe;

import java.util.HashMap;

/**
 * Created by xingzhi on 2019/7/24.
 */
public class HashMapAnalysis {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put("a","A");
        hashMap.put("b","B");
//        hashMap.put("c","C");
//        hashMap.put("d","D");
//        hashMap.put("e","E");
//        hashMap.put("f","F");
//        hashMap.put("g","G");

        int a = 20;
        int b = 3;

        do {
            if (b==10) {

                break;
            }
            System.out.println("b"+b);

            b++;
           System.out.println("=-==-=--=-"+b);
        } while (a>b);

//        Set set = hashMap.entrySet();
//
//
//        Iterator iterator = set.iterator();
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        Iterator set1 = hashMap.keySet().iterator();
//        while (set1.hasNext()){
//            System.out.println(set1.next());
//        }
//
//        Iterator set2 = hashMap.values().iterator();
//        while (set2.hasNext()){
//            System.out.println(set2.next());
//        }

//        System.out.println(hashMap.size());



    }
}
