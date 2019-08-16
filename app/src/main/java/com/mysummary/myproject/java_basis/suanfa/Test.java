package com.mysummary.myproject.java_basis.suanfa;

import android.util.Log;

/**
 * Created by xingzhi on 2018/7/6.
 */

public class Test {


    //冒泡排序
    /*
        这个冒泡是我有史以来看算法写得最快的一次，并且是自己分析的。-_-
        可以先把外循环注释掉理解，内循环循环一次，将最大值放到最后。
        首先：
            肯定是需要两层循环？因为一次循环只能把一个最大值放到最后。
            内循环是真正的比较数值的，8个数比较7次就能确定最后的最大数了.
            下次比较6次.....最后比较1次,也就是说内循环比较的次数一次减小，
            把内循环的每一次比较都堪称一次，外循环确定一共比多少次。

     */
    public static void main(String[] args){
//        int [] arr = {4,3,6,10,1,5,20,13};
        int[] arr = {72,6 ,57, 88, 60,42,83,73, 48, 85};
        quicksort(arr,0,9);


//        for (int s:
//                arr) {
//            System.out.println(s);
//        }
    }

    public static void jiandanxunze() {

        //简单选择排序
        int[] arr = {4, 3, 6, 10, 1, 5, 20, 13};



        int min = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                while (arr[0+i]>arr[j+1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[0+i];
                    arr[0+i] = temp;

                }
            }

        }

        for (int s:
                arr) {
            System.out.println(s);
        }

    }
    //        for (int i = 1; i < arr.length ; i++) {
//
//            for (int j = 0; j < arr.length-i; j++) {
//
//                if (arr[j] > arr[j+1]) {
//                    int temp ;
//                    temp = arr[j] ;
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//






    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);


//            quicksort(n, left, dp - 1);
//            quicksort(n, dp + 1, right);
        }
        for (int a:
                n) {
            System.out.println(a);
        }

    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }


}

/**
 * 冒泡排序
 */
class MaoPao{

    public static void main(String[] args){
        int [] arr = {1,3,6,10,4,5,20,13};

        for (int j=1;j<arr.length;j++){
            for (int i=0;i<arr.length-j;i++){
                int temp ;
                if (arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp ;
                }
            }
        }

        for (int a:
                arr) {
            System.out.println(a);
        }
    }
}
/**
 * 选择排序
 */
class XuanZe{

    public static void main(String[] args){
        int [] arr = {1,3,6,10,4,5,20,13,11};

        for (int i=0;i< arr.length;i++){
            int minTemp = i ;
            for (int j = i;j<arr.length;j++){
                if (arr[j]<arr[minTemp]){
                    minTemp = j ;
                }
            }
            int temp = arr[minTemp];
            arr[minTemp] = arr[i];
            arr[i] = temp;
        }

        for (int e:
             arr) {
            System.out.println(e);
        }

    }


}