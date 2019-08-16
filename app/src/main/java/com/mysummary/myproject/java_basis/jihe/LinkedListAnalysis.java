package com.mysummary.myproject.java_basis.jihe;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by xingzhi on 2018/7/11.
 */

public class LinkedListAnalysis {

    Map<String,String> map = new HashMap<>();

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 5 ; i++) {

            arrayList.add("张三"+i);
            linkedList.add("李四"+i);


        }

        ListIterator listIterator = arrayList.listIterator();

        int i = 1 ;

       while (listIterator.hasNext()){
           String next = (String)listIterator.next();

           linkedList.add(i,next);

           i = i + 2;
       }

        ListIterator listIterator1 = linkedList.listIterator();

        while (listIterator1.hasNext()){
            System.out.println(listIterator1.next());
        }

        System.out.println(linkedList.size());


        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(null);
        linkedList1.add("asa");
        for (Object e:
             linkedList1) {
            System.out.println(e);
        }

    }
}
