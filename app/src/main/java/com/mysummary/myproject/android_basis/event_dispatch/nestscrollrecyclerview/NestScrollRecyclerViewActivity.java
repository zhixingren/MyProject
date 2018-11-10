package com.mysummary.myproject.android_basis.event_dispatch.nestscrollrecyclerview;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mysummary.myproject.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NestScrollRecyclerViewActivity extends AppCompatActivity {


    @BindView(R.id.nest_scroll)
    NestedScrollView nestedScrollView ;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView ;

    ArrayList<String> list = new ArrayList<>();
    RecyclerViewAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_scroll_recycler_view);

        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);



        for (int i = 0; i < 30; i++) {

            list.add(i+"");
        }


        adapter = new RecyclerViewAdapter(list,this);

        recyclerView.setAdapter(adapter);

//        nestedScrollView.setListView(recyclerView);




    }
}
