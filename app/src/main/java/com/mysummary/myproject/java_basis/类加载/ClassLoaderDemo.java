package com.mysummary.myproject.java_basis.类加载;

import java.util.Random;

/**
 * Created by xingzhi on 2019-07-28.
 */
public class ClassLoaderDemo {
}

class Test2 {
    public static void main(String args[]){
        System.out.println(FinalTest2.x);
    }
}
class FinalTest2{

    public static final int x = new Random().nextInt(100);
    static {
        System.out.println("FinalTest2 static block");
    }


}

 class Test1 {
    public static void main(String args[]){
        System.out.println(FinalTest.x);
    }

//     public static final int i; //报错，必须初始化 因为常量在常量池中就存在了，调用时不需要类的初始化，所以必须在声明时初始化
//     public static final int j;
//     Test1() {
//         i = 2;
//         j = 3;
//     }
}

class FinalTest{
    public static final int x =6/3;
    static {
        System.out.println("FinalTest static block");
    }
}
