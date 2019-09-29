package com.mysummary.myproject.android_basis.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mysummary.myproject.R;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity implements MainContract.View {

    @Inject //不能用privite
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        DaggerMainPresenter_MainComponent.builder().mainModule(new MainPresenter.MainModule(this))
                .build().inject(this);

//        DaggerMainComponent.builder()
//                .mainModule(new MainModule(this))
//                .build()
//                .inject(this);
//        //调用Presenter方法加载数据
        presenter.loadData();


    }


    @Override
    public void updateUI() {
        Log.i("dagger","返回来数据啦");
    }


}
