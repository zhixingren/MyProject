package com.mysummary.myproject.java_basis.深拷贝与浅拷贝;

import java.util.HashMap;

/**
 * Created by xingzhi on 2019-09-01.
 */
public class Demo2 {

    public static void main(String[] args){

        String a = "000";
        sentString(a);
        System.out.println(a);

        int b= 111;
        sentInt(b);
        System.out.println(b);

        Student student = new Student();
        student.setName("张无忌");
        sentObject(student);
        System.out.println(student.getName());
    }


    public static void sentString(String a){
        a = "1212";
    }
    public static void sentInt(int a){
        a = 1212;
    }

    public static void sentObject(Student studenta){
        studenta.setName("赵无极");
    }

   static class Student{

        String name ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

