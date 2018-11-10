package com.mysummary.myproject.java_basis.fanxing.eg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xingzhi on 2018/6/14.
 */

public class eg1 {


    //PECS法则

    public static List<Apple> listap = Arrays.asList(new Apple());
    public static List<Fruit> listfr = Arrays.asList(new Fruit());

    public static void main(String[] args) {

        first();

    }

    static class Reader<T> {

        T readExact(List<? extends T> list) {

            return list.get(0);

        }



    }

    public static void first(){
        Reader<Fruit> reader = new Reader<Fruit>();
        //如果不使用通配符 List<? extends T> 可以正常传入listfr。因为Reader<Fruit>类型，与listfr中的类型一致。
        //如果传入listap，就会提示编译错误。为了解决这种编译错误，我们使用通配符。但是使用了这种通配符以后，我们只能获取值
        //并且转换为基类。
        Fruit o = reader.readExact(listap);

        //如果是使用通配符的list我们是不能向里面添加元素的，原因是编译器只知道容器内是Fruit或者它的派生类，
        // 但具体是什么类型不知道。可能是Fruit？可能是Apple？
        List<? extends Fruit> list = new ArrayList<>();
//        list.add();

    }

}