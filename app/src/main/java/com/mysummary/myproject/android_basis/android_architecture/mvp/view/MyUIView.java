package com.mysummary.myproject.android_basis.android_architecture.mvp.view;

import com.mysummary.myproject.android_basis.android_architecture.mvp.model.Student;

/**
 * Created by xingzhi on 2018/7/6.
 */

public interface MyUIView {

    void showDialog();
    void showData(Student student);
    void dismissDialog();

}
