package com.mysummary.myproject.android_basis.databinding.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.databinding.entity.Student;
import com.mysummary.myproject.databinding.ActivityDataBindingBinding;

/*
    注意事项：1.student中的字段不能是私有的，否则在xml中找不到stu.name
            2.使用ToastUtil.showToast()会报空指针。

 */
public class DataBindingSimpleActivity extends AppCompatActivity {

    ActivityDataBindingBinding mBinding ;

    Student student = new Student("赵四","男");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        //1.不用findviewbyid了
       // mBinding.name.setText("张三");
        //2.ui变量的绑定 ，可以把id去掉
        mBinding.setStu(student);
        //mBinding.setVariable(BR.stu,s);效果同上

        //3.事件绑定
        mBinding.setPresent(new Present());



    }

    //第一种事件绑定方式：方法引用绑定
    public class Present{
        public void onTextChanged(CharSequence s, int start, int before, int count){
            student.setName(s.toString());
              //这里重新刷新了数据，也可以直接在student中设置，继承，并且设置
//            mBinding.setStu(student);
            student.setFire(!student.mfire.get());
//            Log.e("DataBindingSimpleActivity","s"+!student.mfire.get());
        }

        public void onClick(View view){
            Toast.makeText(DataBindingSimpleActivity.this, "点击啦！", Toast.LENGTH_SHORT).show();

        }

        //第二种绑定方式：监听器绑定，参数是从xml中回传过来的
        public void onClickListenerBind(Student student){
            Toast.makeText(DataBindingSimpleActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
            //ToastUtil.showToast("");//会报空指针,还没有细看为什么。

        }
    }

}
