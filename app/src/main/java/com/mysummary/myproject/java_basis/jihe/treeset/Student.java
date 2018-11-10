package com.mysummary.myproject.java_basis.jihe.treeset;

import android.support.annotation.NonNull;

/**
 * Created by xingzhi on 2018/7/12.
 */
//implements Comparable<Student>
public class Student {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public int compareTo(@NonNull Student o) {
//
//        if (this.name.compareTo(o.name)==0){
//
//            if (this.age>o.getAge()){
//
//                return 0;
//            }
//        }else if (this.name.compareTo(o.name)>0) {
//
//            return 1;
//        }else if (this.name.compareTo(o.name)<0){
//
//            return  -1;
//        }
//
//        return 0;
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}
