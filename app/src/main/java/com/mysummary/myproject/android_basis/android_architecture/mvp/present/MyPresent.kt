package com.mysummary.myproject.android_basis.android_architecture.mvp.present

import com.mysummary.myproject.android_basis.android_architecture.mvp.Base
import com.mysummary.myproject.android_basis.android_architecture.mvp.model.Student

/**
 * Created by xingzhi on 2018/10/27.
 */
class MyPresent(var myUIView: Base.UIView) : Base.Present {

//    private val myUIView: Base.UIView

    fun MyPresent(myUIView: Base.UIView){

        this.myUIView = myUIView

//    }


    fun deal() {
        val student = Student()
        student.name = "赵云"
        student.age = 35

        myUIView.showDialog()

        myUIView.showData(student)

        myUIView.dismissDialog()
    }


}
