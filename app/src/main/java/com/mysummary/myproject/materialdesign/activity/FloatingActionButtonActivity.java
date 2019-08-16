package com.mysummary.myproject.materialdesign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mysummary.myproject.R;
import com.mysummary.myproject.materialdesign.snacke.SnackbarUtils;

//https://blog.csdn.net/u010687392/article/details/46954213
public class FloatingActionButtonActivity extends AppCompatActivity {
    Snackbar snacker;
    FloatingActionButton viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        viewById = findViewById(R.id.fab);

        //把根布局换成协调者布局FloatingActionButton就会在snack上面
//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //snacker = Snackbar.make(v, " 始虐发计算机数据粉红啊没钱哦嗯呢", Snackbar.LENGTH_INDEFINITE);
//
//                SnackbarUtils.Short(viewById, "设置文字位看见看见看见借款看见看见快看见看见快置左右两侧图片").leftAndRightDrawable(R.mipmap.i9, R.mipmap.i11).show();
//
//
//            }
//        });

    }

}



