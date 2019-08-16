package com.mysummary.myproject.android_basis.databinding.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.databinding.entity.Student;
import com.mysummary.myproject.android_basis.net.entity.BaseEntity;
import com.mysummary.myproject.android_basis.net.retrofit.NetService;
import com.mysummary.myproject.databinding.ActivityPracticeBinding;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * databingding practice
 */
public class PracticeActivity extends AppCompatActivity {

    ActivityPracticeBinding viewDataBinding ;
    Student student = new Student("赵四","women","");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.
                setContentView( this,R.layout.activity_practice);
        viewDataBinding.setStudent(student);
        viewDataBinding.setPresent(new Present());

        new NetService()
                .getHttpInterface(null,PracticeActivity.this)
                .getRegist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Observer<BaseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity baseEntity) {
                        student.name = baseEntity.getData().get(0).getFundMarkName2().toString();
                        student.sex = "123r43";
                        student.head = "";
                        viewDataBinding.setStudent(student);

//                        viewDataBinding.
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

    public class Present{
        public void onClick(Student student){
            Toast.makeText(PracticeActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
        }

    }
}
