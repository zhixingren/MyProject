package com.mysummary.myproject.android_basis.recyclerview.swiperefresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.recyclerview.GpBean;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.adapter.ListViewAdapter;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.base.RefreshLayout;
import com.mysummary.myproject.base.http.ResObserver;
import com.mysummary.myproject.base.http.ServersMethod;
import com.mysummary.myproject.base.http.SubscriberOnListener;

import java.util.ArrayList;
import java.util.List;

//http://gank.io/api/search/query/listview/category/Android/count/100/page/1
public class SwipeRefreshActivity1 extends AppCompatActivity implements AdapterView.OnItemClickListener,SwipeRefreshLayout.OnRefreshListener,RefreshLayout.OnLoadListener{

    private RefreshLayout swipeRefresh ;
    private ListView rv;

    private SubscriberOnListener<GpBean> gpSubscriberOnListener ;
    private String TAG  = "SwipeRefreshActivity" ;
    private ListViewAdapter adapter ;
    private  List<GpBean.IndustryCountListBean> myProjectList;
    private int number = 10;
    private int count = 0;
    private int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        rv = findViewById(R.id.rv);
        swipeRefresh = findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.setOnLoadListener(this);
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        //设置列表样式
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        //设置分割线
//        rv.addItemDecoration(new DeviderDecoration(this));
//        //设置item动画效果
//        rv.setItemAnimator(new DefaultItemAnimator());

        swipeRefresh.setRefreshing(true);

        myProjectList = new ArrayList<>();
//        adapter = new RecyclerAdapterOne(myProjectList,SwipeRefreshActivity.this);

        gpSubscriberOnListener = new SubscriberOnListener<GpBean>() {
            @Override
            public void onNext(GpBean gpBean) {

                //0页
//                if (gpBean.getIndustryCountList().size()<=number){
//                    myProjectList.addAll(gpBean.getIndustryCountList());
//                    adapter.setData(myProjectList);
//                    adapter.notifyDataSetChanged();
//                    return;
//                }
//                myProjectList.addAll(gpBean.getIndustryCountList());
                adapter = new ListViewAdapter(gpBean.getIndustryCountList(),SwipeRefreshActivity1.this);
                rv.setAdapter(adapter);


//                if (gpBean.getIndustryCountList().size()>number){
//                    count = gpBean.getIndustryCountList().size() / 10;
//                }



//                if (pageNo==1){
//                    myProjectList.addAll(gpBean.getIndustryCountList());
//                    adapter.setData(myProjectList.subList(count*pageNo,pageNo*10>gpBean.getIndustryCountList().size()
//                            ?gpBean.getIndustryCountList().size():pageNo*10));
                    //adapter.notifyDataSetChanged();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            swipeRefresh.setRefreshing(false);
                        }
                    },1000);

//                }else {
//
//
//                }




            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                swipeRefresh.setRefreshing(false);
//                ErrorHandle.dealWithError(e);
//                if (e instanceof IOException){
//                    Toast.makeText(SwipeRefreshActivity.this, "网络异常！", Toast.LENGTH_SHORT).show();
//                }
                Log.e(TAG,"---->"+Thread.currentThread().getName()+"---"+e.getMessage());
            }
        };


        getBaseInfo();
    }



    @Override
    public void onRefresh() {
        Log.e(TAG,"TAG");
//        count =  0;
//        pageNo = 1;
        myProjectList.clear();
        getBaseInfo();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e(TAG,"id--->"+id);
    }

    @Override
    public void onLoad() {
        Log.e(TAG,"onLoad");


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
