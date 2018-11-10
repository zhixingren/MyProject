package com.mysummary.myproject.android_basis.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.adapter.RecyclerAdapter;
import com.mysummary.myproject.base.http.ErrorHandle;
import com.mysummary.myproject.base.http.ResObserver;
import com.mysummary.myproject.base.http.ServersMethod;
import com.mysummary.myproject.base.http.SubscriberOnListener;

import java.util.List;

public class RecylcerViewActivity extends AppCompatActivity {

    private RecyclerView rl ;
    private SubscriberOnListener<GpBean> gpSubscriberOnListener ;
    private String TAG  = "RecylcerViewActivity" ;
    private RecyclerAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylcer_view);

        rl = findViewById(R.id.rv_s);

        //设置列表样式
        rl.setLayoutManager(new LinearLayoutManager(this));
        //设置分割线
        rl.addItemDecoration(new DeviderDecoration(this));
        //设置item动画效果
        rl.setItemAnimator(new DefaultItemAnimator());




        gpSubscriberOnListener = new SubscriberOnListener<GpBean>() {
            @Override
            public void onNext(GpBean gpBean) {
                List<GpBean.ManagersBean> myProjectList = gpBean.getManagers();

                adapter = new RecyclerAdapter(myProjectList,RecylcerViewActivity.this);
                rl.setAdapter(adapter);


            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
//                ErrorHandle.dealWithError(e);
            }
        };


        getBaseInfo();
    }


    public void getBaseInfo(){
        ResObserver<GpBean> mResObserver = new ResObserver<>(gpSubscriberOnListener);
//        Map<String, Object> map = new HashMap<>();
//        map.put("accessToken","cabd120591c24291818b0e046fa98475");
        String id = "1";
        new ServersMethod().getGpData(mResObserver,id);
    }


}
