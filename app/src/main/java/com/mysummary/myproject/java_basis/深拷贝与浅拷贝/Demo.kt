package com.mysummary.myproject.java_basis.深拷贝与浅拷贝

import android.annotation.SuppressLint

//import android.util.Log.println

/**
 * Created by xingzhi on 2019-08-24.
 */

@SuppressLint("WrongConstant")
fun main(args: Array<String>) {

    val number = 123
    val stu1 = Student()
    stu1.number = number

    val stu2 = stu1
    stu2.number = 321
    System.out.println("number:" + number)
    System.out.println(stu1 == stu2)
    System.out.println("学生1:" + stu1.number)
    System.out.println("学生2:" + stu2.number)

}

class Student {
    var number: Int = 0
}
