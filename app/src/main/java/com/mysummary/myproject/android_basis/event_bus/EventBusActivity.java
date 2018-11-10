package com.mysummary.myproject.android_basis.event_bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mysummary.myproject.R;

import java.lang.reflect.Method;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/*
    EventBus使用场景：

    1.项目中的，更多资料->完善资料，涉及到回传地址值，其实可以用onActivityResult(),但是如果跨页面，用eventbus会很方便的。
    2.项目中的红点，当点击红点进入下个页面，在下个页面发送事件，给红点页面，让红点页面中的相应订阅该事件的方法更新页面。

    缺点：事件多了要维护很多onevent,还有很多的messenge


    优先级：
            ThreadMode相同的情况下，优先级越大，越是现接收到消息。
            当不同的时候，开启子线程是需要时间的，所以设置的优先级大，但是也可能接收消息的时间比较晚。

    粘性事件：
            就是在没有注册的时候先发送消息了，然后消息被保存在内存中，当注册的时候接收到消息。


 */
public class EventBusActivity extends AppCompatActivity {

    private Button btn_to_next ,btn_to_sticky,bt_observer;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        EventBus.getDefault().register(this);

        btn_to_next = findViewById(R.id.btn_to_next);
        tv_message = findViewById(R.id.tv_message);
        btn_to_sticky = findViewById(R.id.btn_to_sticky);
        bt_observer = findViewById(R.id.bt_observer);


        btn_to_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventBusActivity.this, PublishActivity.class);
                startActivity(intent);
            }
        });

        btn_to_sticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventBusActivity.this, StickyModeActivity.class);
                startActivity(intent);
            }
        });


    }

    //在产生事件的线程中执
    @Subscribe(threadMode = ThreadMode.PostThread,priority = 5)
    public void onMessageEventPostThread(MessageEvent messageEvent) {
        Log.e("PostThread", Thread.currentThread().getName());


    }

    //在UI线程中执行
    @Subscribe(threadMode = ThreadMode.MainThread,priority = 4)
    public void onMessageEventMainThread(MessageEvent messageEvent) {
        Log.e("MainThread", Thread.currentThread().getName());
        tv_message.setText("MainThread from PublishActivity:" + messageEvent.getMessage());

    }

    //如果产生事件的是UI线程，则在新的线程中执行。如果产生事件的是非UI线程，则在产生事件的线程中执行
    @Subscribe(threadMode = ThreadMode.BackgroundThread,priority = 3)
    public void onMessageEventBackgroundThread(MessageEvent messageEvent) {
        Log.e("BackgroundThread", Thread.currentThread().getName());
    }

    //无论产生事件的是否是UI线程，都在新的线程中执行
    @Subscribe(threadMode = ThreadMode.Async,priority = 2)
    public void onMessageEventAsync(MessageEvent messageEvent) {
        Log.e("Async", Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消事件注册
        EventBus.getDefault().unregister(this);
        //取消广播注册
//        unregisterReceiver(mBroadcastReceiver);
    }

}
