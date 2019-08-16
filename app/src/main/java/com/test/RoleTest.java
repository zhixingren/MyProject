package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xingzhi on 2018/6/13.
 */

public class RoleTest {


    public static void main(String[] args) {

        List<RoleBean> list1 = new ArrayList<RoleBean>();
        List<RoleBean> list2 = new ArrayList<RoleBean>();
        List<RoleBean> list3 = new ArrayList<RoleBean>();
        List<RoleBean> list4 = new ArrayList<RoleBean>();
        List<RoleBean> list5 = new ArrayList<RoleBean>();

        //角色1
        list1.add(new RoleBean(0,"ABC",0));
        list1.add(new RoleBean(2,"KSJ",0));
        list1.add(new RoleBean(4,"E",0));

        //角色2
        list2.add(new RoleBean(1,"B",0));
        list2.add(new RoleBean(2,"KSJ",0));
        list2.add(new RoleBean(3,"D",0));

        //角色3
        list3.add(new RoleBean(2,"KSJ",0));
        list3.add(new RoleBean(3,"D",0));
        list3.add(new RoleBean(4,"E",0));

        //角色4
        list4.add(new RoleBean(0,"ABC",0));
        list4.add(new RoleBean(1,"B",0));
        list4.add(new RoleBean(4,"E",0));

        //角色5
        list5.add(new RoleBean(5,"F",0));


        String role = "3,1,2,4";
        List<String> result = Arrays.asList(role.split(","));
        List<RoleBean> tempRoleList = new ArrayList<>();

        System.out.println(result);
        for (int i =0;i<result.size();i++){
            if (result.get(i).equals("1")) {
                tempRoleList.addAll(list1);
            }
            if (result.get(i).equals("2")) {
                tempRoleList.addAll(list2);
            }
            if (result.get(i).equals("3")) {
                tempRoleList.addAll(list3);
            }
        }

        Iterator<RoleBean> iterator = tempRoleList.iterator();

        List<RoleBean> tempList = new ArrayList<>();


        while (iterator.hasNext()) {
            RoleBean str = iterator.next();
            if (!tempList.contains(str)) {
                tempList.add(str);
            }
        }


        Collections.sort(tempList);
        for (int i = 0;i<tempList.size();i++){
            System.out.println(tempList.get(i).getRoleName());
        }


        System.out.println(tempRoleList);

    }
}
