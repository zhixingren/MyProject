package com.mysummary.myproject.android_basis.ui_optimization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mysummary.myproject.R;

public class UIActivity extends AppCompatActivity {
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        ViewStub viewStub = findViewById(R.id.viewstub_demo_text);
        viewStub.inflate();
        final TextView tv = findViewById(R.id.viewstub_demo_textview);
        tv.setText("1121212");
//        tv.setVisibility(View.GONE);


        ViewStub stub = findViewById(R.id.viewstub_demo_image);
        stub.inflate();
        ImageView image = findViewById(R.id.viewstub_demo_imageview);
        image.setImageResource(R.drawable.girl);



        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag){
                    tv.setVisibility(View.GONE);
                    flag = false;
                }else {
                    tv.setVisibility(View.VISIBLE);
                    flag = true;
                }
            }
        });

    }
}
