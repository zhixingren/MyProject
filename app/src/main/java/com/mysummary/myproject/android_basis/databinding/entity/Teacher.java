package com.mysummary.myproject.android_basis.databinding.entity;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;

/**
 * Created by xingzhi on 2019-08-20.
 */
public class Teacher {

    public ObservableField<String> name;

    public ObservableField<String> sex;

    public ObservableField<String> head;

    public Teacher(String name, String sex, String head) {
        this.name = new ObservableField<>(name);
        this.sex = new ObservableField<>(sex);
        this.head = new ObservableField<>(head);
    }

}
