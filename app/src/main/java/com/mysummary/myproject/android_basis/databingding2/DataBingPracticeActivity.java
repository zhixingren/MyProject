package com.mysummary.myproject.android_basis.databingding2;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.databinding.entity.Student;
import com.mysummary.myproject.android_basis.databinding.entity.Teacher;
import com.mysummary.myproject.databinding.ActivityDataBingPracticeBinding;

import java.util.Random;

/**
 * 1.单项绑定不需要在entity中加上 @Bindable
 * 2.android:text="@{student.name,default=赵云}" 加默认值
 * 3.可以通过binding.tvName.setText(""); 动态设置
 * 4.可以在定义 ActivityDataBingPracticeBinding 名字-> <data class="CustomBinding">
 *
 *                                                  </data>
 * 5.双向绑定即改变数据改变视图，改变视图也改变了数据
 */
public class DataBingPracticeActivity extends AppCompatActivity {

    ActivityDataBingPracticeBinding binding ;
    Student student;
    Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_bing_practice);

        student = new Student("张三","男","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566294794764&di=a4498488bad59d677ee8727ecc582856&imgtype=0&src=http%3A%2F%2Fpic17.nipic.com%2F20111015%2F6798351_223826569156_2.jpg");

        teacher = new Teacher("赵越","女","");


        binding.setTeacher(teacher);
        binding.setStudent(student);
        binding.setClickChnge(new ClickChanged());



//        binding.tvName.setText("");
        //当可观察对象的属性更改时就会通知这个监听器
        student.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
//                switch (propertyId){
//                    case BR.name:
//                        Log.e("a","");
//                        break;
//                    case BR.sex:
//                        Log.e("b","");
//                        break;
//                }
            }
        });




    }

    @BindingAdapter({"urlImag"})
    public static void loadImage(ImageView imageView,String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
        Log.e("urlImage",url);
    }


  public  class ClickChanged{
        public void changeField(){
            student.setName("code"+ new Random().nextInt());
            student.setSex("sex ");
        }

        public void changeTeacherField(){
            Log.e("changeTeacherField","changeTeacherField");
            teacher.name.set("名字" + new Random().nextInt());

        }
    }
}
