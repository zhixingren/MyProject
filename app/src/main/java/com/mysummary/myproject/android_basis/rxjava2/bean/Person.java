package com.mysummary.myproject.android_basis.rxjava2.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingzhi on 2018/8/16.
 */

public class Person {

    private String name;
    private List<Plan> planList = new ArrayList<>();

    public Person(String name, List<Plan> planList) {
        this.name = name;
        this.planList = planList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

}
