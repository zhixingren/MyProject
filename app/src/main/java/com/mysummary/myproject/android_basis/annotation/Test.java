package com.mysummary.myproject.android_basis.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//https://blog.csdn.net/briblue/article/details/73824058

/*

    注解是一系列元数据，它提供数据用来解释程序代码，但是注解并非是所解释的代码本身的一部分。注解对于代码的运行效果没有直接影响。
    注解有许多用处，主要如下：
-   提供信息给编译器： 编译器可以利用注解来探测错误和警告信息
-   编译阶段时的处理： 软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理。
-   运行时的处理： 某些注解可以在程序运行的时候接受代码的提取

    现在，我们可以给自己答案了，注解有什么用？给谁用？给 编译器或者 APT 用的。


    如果注解难于理解，你就把它类同于标签，标签为了解释事物，注解为了解释代码。
    注解的基本语法，创建如同接口，但是多了个 @ 符号。
    注解的元注解。
    注解的属性。
    注解主要给编译器及工具类型的软件用的。
    注解的提取需要借助于 Java 的反射技术，反射比较慢，所以注解使用时也需要谨慎计较时间成本。


 */
@TestAnnotation(msg = "hello")
public class Test {

    @Check(value = 121)
    int a;


    @Perform
    public void testMethod() {
    }


    @SuppressWarnings("deprecation")
    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }


    public static void main(String[] args) {

        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);

        if (hasAnnotation) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            //获取类的注解
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }


        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            //获取一个成员变量上的注解
            Check check = a.getAnnotation(Check.class);

            if (check != null) {
                System.out.println("check value:" + check.value());
            }

            Method testMethod = Test.class.getDeclaredMethod("testMethod");

            if (testMethod != null) {
                // 获取方法中的注解
                Annotation[] ans = testMethod.getAnnotations();
                for (int i = 0; i < ans.length; i++) {
                    System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

}