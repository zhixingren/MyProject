package com.mysummary.myproject.java_basis.jihe.treeset;


import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by xingzhi on 2018/7/12.
 */

public class TreeSetAnalysis {


    public static void main(String[] args) {


        TreeSet treeSet = new TreeSet(new MyComparator());

        //可以比较
//        treeSet.add(1);
//        treeSet.add(2);

        /*
        下面这种情况就会发生错误，因为treeset不知道是按照名字还是年龄去比较。
        所以此时必须让所添加的对象student实现Comparable<T>接口。

        1.自然排序：在student中实现Comparable<T>接口称为。
        2.比较器排序：将student中的实现去掉，以构造器参数的形式，传给treeset。
         */
        treeSet.add(new Student("zhang", 1));
        treeSet.add(new Student("li", 2));
        treeSet.add(new Student("ce", 5));
        treeSet.add(new Student("asdad", 9));


        for (Object s: treeSet
             ) {
            System.out.println(((Student)s).getName()+"--"+((Student)s).getAge());
        }

    }

//        System.out.println(linkedList.size());



    public static class MyComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1,Student s2) {
            //比较名字，如果相同则向下比较年龄
            if (s1.getName().compareTo(s2.getName())==0){

                //如果名字相同，比较年龄
                if (s1.getAge()==s2.getAge()){

                    return 0;
                }
            }else if (s1.getName().compareTo(s2.getName())>0) {
                return 1;
            }else if (s1.getName().compareTo(s2.getName())<0){

                return  -1;
            }

            return 0;
        }




    }


}
