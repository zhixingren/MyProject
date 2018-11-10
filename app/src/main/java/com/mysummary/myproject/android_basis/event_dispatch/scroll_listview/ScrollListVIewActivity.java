package com.mysummary.myproject.android_basis.event_dispatch.scroll_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.mysummary.myproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollListVIewActivity extends AppCompatActivity {

    @BindView(R.id.lv)
    MyListView lv;
    @BindView(R.id.sv)
    ScrollView sv ;

    List<Map<String, Object>> list;
    private SimpleAdapter simAdapt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_list_view);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("age", i);

            list.add(item);
        }

        simAdapt = new SimpleAdapter(this,list,R.layout.item_scroll_list_view,
                                      new String[]{"age"},new int[]{R.id.tv});

        lv.setAdapter(simAdapt);
       // LIstViewHeight.setListViewHeightBasedOnChildren(lv);


        //sv.setListView(lv);
    }


}
