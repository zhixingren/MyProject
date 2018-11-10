package com.mysummary.myproject.android_basis.android_architecture.mvp.present;

import com.mysummary.myproject.android_basis.android_architecture.mvp.Base;
import com.mysummary.myproject.android_basis.android_architecture.mvp.model.Student;
import com.mysummary.myproject.android_basis.android_architecture.mvp.view.MyUIView;

/**
 * Created by xingzhi on 2018/7/6.
 */

public class MyPresent implements Base.Present{

    private Base.UIView myUIView;

    public MyPresent(Base.UIView myUIView){

        this.myUIView = myUIView;

    }


    public void deal(){
        Student student = new Student();
        student.setName("赵云");
        student.setAge(35);

        myUIView.showDialog();

        myUIView.showData(student);

        myUIView.dismissDialog();
    }


    @Override
    public void start() {
        deal();
    }
}
