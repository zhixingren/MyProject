package com.mysummary.myproject.java_basis.fanxing.eg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mysummary.myproject.java_basis.fanxing.eg1.GenericWriting.f2;

/**
 * Created by xingzhi on 2018/6/13.
 */

public class GenericReading {

    //各自的集合可以存储各自类型的数据，但是apples与fruit没有关系。
    //
    static List<Apple> apples = Arrays.asList(new Apple());

    static List<Fruit> fruit = Arrays.asList(new Fruit());

    static List<? extends Fruit> fruit1 = Arrays.asList(new Fruit());

    static List<? super Fruit> fruit2 = Arrays.asList(new Fruit());



    static class Reader<T> {

        T readExact(List<? extends T> list) {

            return list.get(0);

        }

    }

    static void f1() {

        Reader<Fruit> fruitReader = new Reader<Fruit>();

        Fruit fruit1 = new Apple();

        Apple apple =(Apple) fruit1;//5.只有我们的父类对象本身就是用子类new出来的时候, 才可以在将来被强制转换为子类对象.

//        Apple apple1 = (Apple) fruit.get(0);//6.这种情况下，是不能进行转换的
        System.out.print(apple.toString());

        //编译时出错 ：Errors: List<Fruit> cannot be applied to List<Apple>.
         Fruit f = fruitReader.readExact(apples);//因为T不确定是什么类型，如果不使用通配符，编译出错
        //3、如何解决这种情况呢：利用通配符？但是这种只能获取里面的元素,我们不能像下面那样添加元素。

         List<? extends Fruit> flist = new ArrayList<Apple>();

        // Compile Error: can't add any type of object:

        // flist.add(new Apple())

        // flist.add(new Orange())

        // flist.add(new Fruit())


        //4、也可以看类GenericWriting
        //<? extends T> 表示上界通配符 它表示T以及T的子类， 类型最高是T
        //<? super T> 表示下界通配符 它表示T以及T的超类，类型最高可到Object ，最低是T
        //2、这种与1相反，只能添加，不能获取。






    }

    public static void main(String[] args) {

//        f1();
          f3();
        Fruit fruit = fruit1.get(0);
        System.out.println(fruit);

    }

    private static void f3() {
        fruit.add(new Fruit());
        apples.add(new Apple());



    }


}
