package com.mysummary.myproject.android_basis.databinding.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.mysummary.myproject.R;
import com.mysummary.myproject.databinding.ActivityDataBindListBinding;

public class DataBindListActivity extends AppCompatActivity {

    ActivityDataBindListBinding listBinding;

    public class Presenter{
        public void OnClickAddItem(View view){

        }

        public void OnClickRemoveItem(View view){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_bind_list);
        listBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


}
