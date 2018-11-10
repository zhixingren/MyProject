package com.mysummary.myproject.android_basis.event_dispatch.nest_scroll_recycl_viewpage;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.event_dispatch.nestscrollrecyclerview.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NestScrollRecyclViewPagerActivity extends AppCompatActivity {


    @BindView(R.id.view_page)
    ViewPager viewPager ;
    @BindView(R.id.rv)
    RecyclerView recyclerView;

    ArrayList<String> list = new ArrayList<>();
    RecyclerViewAdapter adapter ;
    ViewPagerAdapter viewPagerAdapter ;


    ArrayList<Integer> mivGoodsList;
    ArrayList<ImageView> imageViews ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_scroll_recycl_view_pager);

        ButterKnife.bind(this);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);




        for (int i = 0; i < 30; i++) {

            list.add(i+"");
        }
        mivGoodsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mivGoodsList.add(R.mipmap.ic_launcher);
        }

        imageViews = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mivGoodsList.get(i));
            imageViews.add(imageView);
        }



        viewPagerAdapter = new ViewPagerAdapter(this,imageViews);
        adapter = new RecyclerViewAdapter(list,this);
        recyclerView.setAdapter(adapter);

        viewPager.setAdapter(viewPagerAdapter);
    }



}
