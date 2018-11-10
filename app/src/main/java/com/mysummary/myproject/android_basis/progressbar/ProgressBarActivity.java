package com.mysummary.myproject.android_basis.progressbar;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mysummary.myproject.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressBarActivity extends AppCompatActivity {


    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.bt)
    Button button ;

    HashMap<String,String> map ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        ButterKnife.bind(this);

        //Serializable entity = getIntent().getSerializableExtra("entity");
       // Log.e("entity",entity.toString());


    }


    @OnClick(R.id.bt)
    public void OnClick(){
        //两种方式实现，进度条3秒走50%。
//        progress1();
        progress2();

    }

    private void progress3() {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1,5,60, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5));
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int max = progressBar.getMax();
                while (progressBar.getProgress()<50){
                    int current = (50)/3;

                    progressBar.setProgress(progressBar.getProgress()+current);
                    Log.e("aaaa",progressBar.getProgress()+current+"");


                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }

    private void progress2() {

        new ProgressTask().execute("hi");

    }



    private void progress1() {
        progressBar.setProgress(0);
        new Thread(new Runnable() {
            @Override
            public void run() {

                int progress = progressBar.getMax();

                while (progressBar.getProgress()<progress/2){

                    int i = progress / 30;

                    progressBar.setProgress(i+progressBar.getProgress());
                    Log.e("aaaa",progressBar.getProgress()+i+"");


                    try {
                        Thread.sleep(200);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }).start();
    }

    private Long time1,time2 ;


    class ProgressTask extends AsyncTask<String,Integer,String>{



        @Override
        protected String doInBackground(String... strings) {

            int max = progressBar.getMax();

            int i = max / 30;

         //   Log.e("time1", System.currentTimeMillis()+"");
            time1 = System.currentTimeMillis();
            Log.e("LongTime1",getLongTime(time1)+"");

            while (progressBar.getProgress()<30) {

                publishProgress(progressBar.getProgress()+i);
                Log.e("aaaa",progressBar.getProgress()+i+"");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            
            return strings[0];
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
           progressBar.setProgress(values[0]);


        }

        @Override
        protected void onPostExecute(String result) {
            time2 = System.currentTimeMillis();

            Log.e("LongTime2",getLongTime(time2)+"");

            //Log.e("time2", System.currentTimeMillis()+"");
            Toast.makeText(ProgressBarActivity.this,result , Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onPreExecute() {
            progressBar.setProgress(0); // 进度条复位
            //Toast.makeText(ProgressBarActivity.this,"执行完毕后输出 hi" , Toast.LENGTH_SHORT).show();

        }
    }

    public static String getLongTime(Long time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        String timStr = dateFormat.format(date);


        return timStr;
    }

}
