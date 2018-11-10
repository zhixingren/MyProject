package com.mysummary.myproject.java_basis.fanxing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://blog.csdn.net/s10461/article/details/53941091
/*

    1、
    T与？的区别：通俗地说，"T"是定义类或方法时声明的东西，"?"是调用时传入的东西，二者是不同的概念。

    2、《java编程思想》有具体的原理介绍
    List<?> list = new ArrayList<String>();
    这个时候通配符会捕获具体的String,但是编译器不叫他String，具体的可能是起了一个临时编号，"sda#1"，
    座椅以后不能往里面存任何元素，包括String。

    通配符、上边界、下边界
    https://blog.csdn.net/hanchao5272/article/details/79355931
    List<? extends Fruit> fruit = Arrays.asList(new Fruit());
    Fruit fruit = fruit1.get(0);
    可以用get，但是不能用add.

    List<? super Fruit> fruit = Arrays.asList(new Fruit());
    fruit.add(new Apple());
    可以用add，但是不能用get.

    3.类型擦出
    https://blog.csdn.net/lonelyroamer/article/details/7868820
    这是因为，泛型信息只存在于代码编译阶段，在进入 JVM 之前，与泛型相关的信息会被擦除掉，专业术语叫做类型擦除。

    这个里面有会泛型擦出的具体说明
    https://blog.csdn.net/briblue/article/details/76736356


    4. 为什么会有泛型？
    https://www.jianshu.com/p/5179ede4c4cf





 */
public class FanXingActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn_t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_xing);


        initView();

    }

    private void initView() {
        btn_t = findViewById(R.id.btn_tt);
        btn_t.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tt:
                //泛型
                    eg();
                //compareTo 是如何比较字符串大小的
                    eg1();
                break;

        }
    }

    private void eg1() {

        String s1 = "abc";
        String s2 = "abcd";
        String s3 = "abcdfg";
        String s4 = "1bcdfg";
        String s5 = "cdfg";
        System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度小1)
        System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度小3)
        System.out.println( s2.compareTo(s3) ); // -2 (前面相等,s1长度小3)

        System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48)
        System.out.println( s1.compareTo(s5)+"---------"); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2)

        ArrayList list1 = new ArrayList();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        list1.add(s5);
        Collections.sort(list1);//按照生序排列
        System.out.println(list1);

        System.out.println( "---------");
        String s11 = "abc";
        String s12 = "abcd";
        String s13 = "abcdfg";

        ArrayList list = new ArrayList();
        list.add(s11);
        list.add(s12);
        list.add(s13);

        System.out.println( s11.compareTo(s12) );
        System.out.println( s12.compareTo(s13) );
        System.out.println( s11.compareTo(s13) );

        Collections.sort(list);
        System.out.println(list);


    }

    private void eg() {

        //1、使用泛型类我们的Box类便可以得到复用
//        Box<Integer> integerBox = new Box<Integer>();
//        integerBox.set(1);
//        Box<Double> doubleBox = new Box<Double>();
//        Box<String> stringBox = new Box<String>();

        //2.泛型方法的使用
        Pair<Integer, String> p1 = new Pair<>(1, "apple");

        Pair<Integer, String> p2 = new Pair<>(2, "pear");

       // boolean same = Util.<Integer, String>compare(p1, p2);
        boolean same = Util.compare(p1, p2);

    }


    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {

        int count = 0;

        for (T e : anArray)

            if (e.compareTo(elem) > 0)  // compiler error

                ++count;

        return count;

    }




}
