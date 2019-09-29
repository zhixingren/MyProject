package com.mysummary.myproject.android_basis.databinding.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

import com.mysummary.myproject.BR;

/**
 * Created by xingzhi on 2018/8/13.
 */

public class Student extends BaseObservable{
    public String name ;
    public String sex ;
   // public boolean fire = false;
    public String head ;
    public ObservableBoolean mfire = new ObservableBoolean();

    public ObservableArrayMap<String,String> map = new ObservableArrayMap<>();


    public Student(String name, String sex,String head) {
        this.name = name;
        this.sex = sex;
        this.head = head;
        mfire.set(false);
        map.put("hello","word");
        map.put("hi","w");
        map.put("yo","ww");

    }

    @Bindable
    public String getHead(){
        return head ;
    }

    public void setHead(String head){
        this.head = head;
        notifyPropertyChanged(BR.head);//只更新本字段
//        notifyChange();//更新所有字段

    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
//        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
       notifyChange();


    }

//    public boolean getFire() {
//        return fire;
//    }

    public void setFire(boolean fire) {
       mfire.set(fire);
    }


}


