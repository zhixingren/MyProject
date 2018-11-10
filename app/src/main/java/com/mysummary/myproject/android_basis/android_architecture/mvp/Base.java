package com.mysummary.myproject.android_basis.android_architecture.mvp;

import com.mysummary.myproject.android_basis.android_architecture.mvp.model.Student;

/**
 * Created by xingzhi on 2018/7/6.
 */

public interface Base {

    interface UIView{

        void showDialog();
        void showData(Student student);
        void dismissDialog();
    }

    interface Present{

        void start();
    }

}
