package com.mysummary.myproject.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.R;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialDesignActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_to_float, btn_to_appbar, btn_to_coordinator, btn_to_tablayout, btn_to_textinput, btn_to_dpv;
    private Button btn_to_dpv1, btn_to_coordinator1;

    @BindView(R.id.btn_to_toolbar)
    Button btn_to_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        btn_to_float = findViewById(R.id.btn_to_float);
        btn_to_float.setOnClickListener(this);
        btn_to_appbar = findViewById(R.id.btn_to_appbar);
        btn_to_appbar.setOnClickListener(this);
        btn_to_coordinator = findViewById(R.id.btn_to_coordinator);
        btn_to_coordinator.setOnClickListener(this);
        btn_to_tablayout = findViewById(R.id.btn_to_tablayout);
        btn_to_tablayout.setOnClickListener(this);
        btn_to_textinput = findViewById(R.id.btn_to_textinput);
        btn_to_textinput.setOnClickListener(this);
        btn_to_dpv = findViewById(R.id.btn_to_dpv);
        btn_to_dpv.setOnClickListener(this);
        btn_to_dpv1 = findViewById(R.id.btn_to_dpv1);
        btn_to_dpv1.setOnClickListener(this);
        btn_to_coordinator1 = findViewById(R.id.btn_to_coordinator1);
        btn_to_coordinator1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_float:
                startActivity(new Intent(MaterialDesignActivity.this, FloatingActionButtonActivity.class));
                break;
            case R.id.btn_to_appbar:
                startActivity(new Intent(MaterialDesignActivity.this, AppBarLayoutActivity.class));
                break;
            case R.id.btn_to_coordinator:
                startActivity(new Intent(MaterialDesignActivity.this, CoordinatorLayoutActivity.class));
                break;
            case R.id.btn_to_coordinator1:
                startActivity(new Intent(MaterialDesignActivity.this, CoordinatorLayoutActivity1.class));
                break;
            case R.id.btn_to_tablayout:
                startActivity(new Intent(MaterialDesignActivity.this, TabLayoutActivity.class));
                break;
            case R.id.btn_to_textinput:
                startActivity(new Intent(MaterialDesignActivity.this, TextInputActivity.class));
                break;
            case R.id.btn_to_dpv:
                startActivity(new Intent(MaterialDesignActivity.this, DependencyViewActivity.class));
                break;
            case R.id.btn_to_dpv1:
                startActivity(new Intent(MaterialDesignActivity.this, DependencyView1Activity.class));
                break;

        }
    }

    @OnClick(R.id.btn_to_toolbar)
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_toolbar:
                startActivity(new Intent(MaterialDesignActivity.this, ToolBarActivity.class));

                break;

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}

//class ThreadPoolExecutorTest {
//    public static void main(String[] args) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
//        for (int i = 1; i <= 5; i++) {
//            final int index = i;
//            fixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                       // System.out.println(index);
//                        System.out.println("第" + index + "个线程" + Thread.currentThread().getName());
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//    }
//}

class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("第" + index + "个线程");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

class LinkedBlockingQueueDemo1 {

    // TODO: queue是LinkedList对象时，程序会出错。
    //private static Queue<String> queue = new LinkedList<String>();
    private static Queue<String> queue = new LinkedBlockingQueue<String>();

    public static void main(String[] args) {

        // 同时启动两个线程对queue进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value;
        Iterator iter = queue.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.println(value + ", ");
        }
//        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 1) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + i;
                System.out.println("====="+val);

                queue.add(val);
                // 通过“Iterator”遍历queue。
                printAll();
            }
        }
    }
}