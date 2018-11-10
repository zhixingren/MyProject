package com.mysummary.myproject.android_basis.android_architecture.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.android_architecture.mvp.Base;
import com.mysummary.myproject.android_basis.android_architecture.mvp.model.Student;
import com.mysummary.myproject.android_basis.android_architecture.mvp.present.MyPresent;

public class MVPActivity extends AppCompatActivity implements Base.UIView{

    private String TAG = "MVPActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        new MyPresent(this).start();


    }

    @Override
    public void showDialog() {
        System.out.println(TAG+"----显示进度条！");
    }

    @Override
    public void showData(Student student) {

        System.out.println(TAG+"----"+student.getName());
        System.out.println(TAG+"----"+student.getAge());

    }

    @Override
    public void dismissDialog() {
        System.out.println(TAG+"----结束进度！");
    }


}
