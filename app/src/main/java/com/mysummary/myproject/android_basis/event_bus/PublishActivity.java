package com.mysummary.myproject.android_basis.event_bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mysummary.myproject.R;

import de.greenrobot.event.EventBus;

public class PublishActivity extends AppCompatActivity {


    private EditText mMessageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        mMessageET = (EditText) findViewById(R.id.messageET);

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("postEvent", Thread.currentThread().getName());
                        String message = mMessageET.getText().toString();
                        if(TextUtils.isEmpty(message)) {
                            message = "defaule message";
                        }
                        EventBus.getDefault().post(new MessageEvent(message));
                    }
                }).start();
//                Log.e("postEvent", Thread.currentThread().getName());
//                String message = mMessageET.getText().toString();
//                if(TextUtils.isEmpty(message)) {
//                    message = "defaule message";
//                }
//                EventBus.getDefault().post(new MessageEvent(message));
            }
        });

    }
}
