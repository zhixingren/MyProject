package com.mysummary.myproject.android_basis.databinding.activity;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.databinding.entity.Student;
import com.mysummary.myproject.android_basis.net.entity.BaseEntity;
import com.mysummary.myproject.android_basis.net.retrofit.NetService;
import com.mysummary.myproject.databinding.ActivityDataBindingBinding;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
    注意事项：1.student中的字段不能是私有的，否则在xml中找不到stu.name
            2.使用ToastUtil.showToast()会报空指针。

 */
public class DataBindingSimpleActivity extends AppCompatActivity {

    ActivityDataBindingBinding mBinding;

    Student student = new Student(null, "男","http://tes-xwjr.oss-cn-beijing.aliyuncs.com/testnews/2018/09/微信图片_20181024175947.jpg");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding);

//        mBinding.setStudent(student);
        //1.不用findviewbyid了
        //mBinding.name.setText("张三");
        //2.ui变量的绑定 ，可以把id去掉
        mBinding.setStu(student);

        //mBinding.setVariable(BR.stu,s);效果同上

        //3.事件绑定
        mBinding.setPresent(new Present());

        new NetService()
                .getHttpInterface(null,DataBindingSimpleActivity.this)
                .getRegist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Observer<BaseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity baseEntity) {
                        mBinding.setBase(baseEntity.getData().get(0));
                        Log.e("onNext","onNext --->"+baseEntity.getData().get(0).fundMarkValue1);
                        //baseEntity.getData().get(0).fundMarkValue1;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError",e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    //第一种事件绑定方式：方法引用绑定
    public class Present {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            student.setName(s.toString());
            //这里重新刷新了数据，也可以直接在student中设置，继承，并且设置
//            mBinding.setStu(student);
            student.setFire(!student.mfire.get());
//            Log.e("DataBindingSimpleActivity","s"+!student.mfire.get());
        }

        public void onClick(View view) {
            Log.e("onClick","onClick");

            new NetService()
                        .getHttpInterface(null,DataBindingSimpleActivity.this)
                        .getRegist()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(new Observer<BaseEntity>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(BaseEntity baseEntity) {
                                mBinding.setBase(baseEntity.getData().get(0));
                                Log.e("onNext","onNext --->"+baseEntity.getData().get(0).fundMarkValue1);
                                //baseEntity.getData().get(0).fundMarkValue1;
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onError",e.toString());

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


        }

        //第二种绑定方式：监听器绑定，参数是从xml中回传过来的
        public void onClickListenerBind(Student student) {
            Toast.makeText(DataBindingSimpleActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
            //ToastUtil.showToast("");//会报空指针,还没有细看为什么。

        }
    }

    @BindingAdapter(value = { "imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }


}
