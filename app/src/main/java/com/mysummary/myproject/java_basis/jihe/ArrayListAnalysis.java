package com.mysummary.myproject.java_basis.jihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by xingzhi on 2018/7/2.
 *
 * 参考：
 * https://blog.csdn.net/qq_16681169/article/details/78241280
 * https://blog.csdn.net/fighterandknight/article/details/61240861
 * https://blog.csdn.net/zxt0601/article/details/77281231
 * https://blog.csdn.net/wangjun5159/article/details/61415358
 *
 * 1.当用for循环并且调用list的remove方法时，分为两种情况考虑：
 *  (1)正续删除时，会有遗漏，因为当删除第一个元素时，剩下的元素向前一动，下次循环，
 *     i+1,变为1了，就将i=1处的删除了，而此时0处是有值的，即刚刚整体向前一动的原本是i=1的值。
 * （2）倒叙删除时，则全部会删除，因为倒叙的时候，i每次都会减1，与list.size()也是每次减1的，
 *     总是保持一致，所以可以全部删除。
 *
 * 2.使用foreach 编译成的class文件代码如下：
 *   删除也是有问题的。debug跑一边，就知道了。
 *
 *   Iterator var3 = list.iterator();
     while(var3.hasNext()) {
     String temp = (String)var3.next();
     if("2".equals(temp)) {
     list.remove(temp);
     } else {
     System.out.println("heheh");
     }

     System.out.println(i++ + "\n");
     System.out.println("----" + temp);
     }
 *
 *
 *
 */

public class ArrayListAnalysis {



    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//2
        int i = 0;
        for (String temp: list
             ) {

            if("2".equals(temp)){
                list.remove(temp);

            }else {
                System.out.println("heheh");
            }

            System.out.println(i++ +"\n");
            System.out.println("----"+temp);
        }

        if (i == 2) {
            System.out.println(list.get(0) +"\n");
            System.out.println(list.get(1) +"\n");
        }


        //1
//        for (int i = list.size()-1; i >=0 ; i--) {
//            if ("4".equals(list.get(i))) {
//                list.remove(list.get(i));
//            System.out.println("---"+list.size());
//            }

            //System.out.println("---"+list.size());
//        }

//        System.out.println("---"+list.size());
//        System.out.println("++"+list.size()+"--"+list.get(0)+"--"+list.get(1));
//        System.out.print(c.getClass().hashCode()+"----"+d.getClass().hashCode());

    }
    
}
