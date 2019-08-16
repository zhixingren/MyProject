package com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mysummary.myproject.R;

import java.util.ArrayList;
import java.util.List;

public class RoleTestActivity extends AppCompatActivity {

    private List list1 = new ArrayList<RoleBean>();
    private List list2 = new ArrayList<RoleBean>();
    private List list3 = new ArrayList<RoleBean>();
    private List list4 = new ArrayList<RoleBean>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_test);

        list1.add("张三");
        list1.add("李四");
        list1.add("王五");

        list2.add("张三");
        list2.add("陈二");
        list2.add("赵八");
        list2.add("韩撒");


        list3.add("张三");

        list4.add("郑啊");

    }


}
