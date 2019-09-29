package com.mysummary.myproject.java_basis.suanfa;

import android.util.Log;

import java.util.Arrays;

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

    }

}

/**
 * 冒泡排序
 */
class MaoPao {

    public static void main(String[] args){
//        int [] arr = {1,3,6,10,4,5,20,13,20,5,30,11,45,23,2,50,25,8,34,9};
        int [] arr = {1,3,6,10,4,5,20,13,20};
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
class MaoPao1{

    public static void main(String[] args){
//        int [] arr = {1,3,6,10,4,5,20,13,20,5,30,11,45,23,2,50,25,8,34,9};
        int [] arr = {1,3,6,10,4,5,21,33,20};
        int i = arr.length-1;  //初始时,最后位置保持不变
        System.out.println("前1"+System.currentTimeMillis());
        int count = 0;
        int count1 = 0 ;
        while ( i> 0) {
            int pos= 0; //每趟开始时,无记录交换
            for (int j= 0; j< i; j++) {
                if (arr[j] > arr[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                System.out.println("次数i--"+count++);
            }
            System.out.println("次数j--"+count1++);
            i= pos; //为下一趟排序作准备
        }
        System.out.println("后1"+System.currentTimeMillis());

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
        int [] arr = {19,2,7,23,5,1,13,16};

        for (int i = 0;i<arr.length-1;i++){
            int min = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            if (i!=min){//主要是当没有走进去上面的循环，说明min就是i，交换没有意义
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }

        }

        for (int e:
                arr) {
            System.out.println(e);
        }
    }
}
/**
 * 快速排序
 */
 class KuaiSu{

     public static void main(String[] args){
         //给出无序数组
         int arr[] = {72,6,57,88,60,42,83,73,48,85};
         quickSort(arr,0,arr.length-1);
         System.out.println(Arrays.toString(arr));
     }

     private static void quickSort(int[] arr,int start,int end){
         if (start<end){
             //把数组中第0个作为标准
             int stard = arr[start];
             //记录需要排序的下标
             int low = start;
             int high = end;

             while (low<high){

                 while (low<high&&stard<=arr[high]){
                     high--;
                 }
                 //当跳出上面的循环说明高位小于stard，于是将高位的赋值给低位
                 arr[low] = arr[high];

                 while (low<high&&arr[low]<=stard){
                     low++;
                 }
                 arr[high] = arr[low];

             }
             arr[low] = stard;

             quickSort(arr,start,low);

             quickSort(arr,low+1,end);
         }


     }

}
