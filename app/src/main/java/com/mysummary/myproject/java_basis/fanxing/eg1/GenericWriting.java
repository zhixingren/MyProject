package com.mysummary.myproject.java_basis.fanxing.eg1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingzhi on 2018/6/13.
 */

public class GenericWriting {

    static List<Apple> apples = new ArrayList<Apple>();

    static List<Fruit> fruit = new ArrayList<Fruit>();

    static <T> void writeExact(List<T> list, T item) {

        list.add(item);

    }

    static void f1() {

        writeExact(apples, new Apple());

        writeExact(fruit, new Apple());

    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {

        list.add(item);

    }

    static void f2() {

        //用 <? super T> 的我们可以往里面添加元素，
        //与 <? extend T> 相反
        writeWithWildcard(apples, new Apple());

        writeWithWildcard(fruit, new Apple());

    }

    public static void main(String[] args) {

        f1(); f2();

    }
}
