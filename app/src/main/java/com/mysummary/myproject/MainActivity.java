package com.mysummary.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mysummary.myproject.android_basis.AndroidBasisActivity;
import com.mysummary.myproject.android_basis.andfix.AndFixPatchManager;
import com.mysummary.myproject.broadcast.activity.BroadCastActivity;
import com.mysummary.myproject.java_basis.JavaBasisActivity;
import com.mysummary.myproject.materialdesign.activity.MaterialDesignActivity;
import com.mysummary.myproject.android_basis.service.ServiceActivity;
import com.mysummary.myproject.utils.ToastUtil;
import com.mysummary.myproject.xiaodai.dialog.WindowUtils;

import java.io.File;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_to_material,btn_to_broadcast,btn_to_service;
    private Button btn_to_java ,btn_to_android ,btn_dialog ,btn_dialog1;

    ///storage/emulated/0/Android/data/com.mysummary.myproject/cache/apatch/
    private static final String FILE_END = ".apatch";
    private String mPatchDir ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mPatchDir = getExternalCacheDir().getAbsolutePath()+"/apatch/";
        //是为了创建我们的文件夹
        File file = new File(mPatchDir);
        if (file == null||!file.exists()) {
            file.mkdir();
        }

        ClassLoader classLoader = getClassLoader();

        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());


    }

    private void initView() {
        btn_to_material = findViewById(R.id.btn_to_material);
        btn_to_material.setOnClickListener(this);
        btn_to_broadcast = findViewById(R.id.btn_to_broadcast);
        btn_to_broadcast.setOnClickListener(this);
        btn_to_service = findViewById(R.id.btn_to_service);
        btn_to_service.setOnClickListener(this);
        btn_to_java = findViewById(R.id.btn_to_java);
        btn_to_java.setOnClickListener(this);
        btn_to_android = findViewById(R.id.btn_to_android);
        btn_to_android.setOnClickListener(this);

        btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog1 = findViewById(R.id.btn_dialog1);
        btn_dialog.setOnClickListener(this);
        btn_dialog1.setOnClickListener(this);

        //AndFix 产生bug
        findViewById(R.id.btn_produce_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = null ;
                Log.e("produce_bug","no bug");
            }
        });
        //修复bug
        findViewById(R.id.btn_fix_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndFixPatchManager.getInstance().addPatch(getPathName());
            }
        });

    }
    //构造patch文件名
    private String getPathName() {
        return mPatchDir.concat("immoc").concat(FILE_END);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_to_material:
                startActivity(new Intent(MainActivity.this, MaterialDesignActivity.class));
                break;
            case R.id.btn_to_broadcast:
                startActivity(new Intent(MainActivity.this, BroadCastActivity.class));
                break;
            case R.id.btn_to_service:
                startActivity(new Intent(MainActivity.this, ServiceActivity.class));

                //                FatherClass fatherClass = new SonClass();
//                Log.e("ee",fatherClass.getClass().getMethod("getSonFirst").invoke()+"");
//                try {
//                    fatherClass.getClass().getMethod("getSonFirst").invoke(fatherClass);
//                } catch (Exception e) {
//
//                }

//                Log.e("ee",fatherClass.getClass().getSuperclass()+"");
//                Log.e("ee",fatherClass.getClass().getSimpleName());

//                FatherInterface fatherInterface = new SonInterface();
//                Log.e("ee",fatherInterface.getClass().getMethod("getFatherInterfacFirst",new Class[]{Son}).invoke(fatherInterface)+"");
//
//                try {
//                    fatherInterface.getClass().getMethod("getFatherFirst").invoke(fatherInterface);
//                    fatherInterface.getClass().getMethod("getFatherInterfacFirst").invoke(fatherInterface);
//
//                } catch (Exception e) {
//
//                }
                break;
            case R.id.btn_to_java:
                startActivity(new Intent(MainActivity.this, JavaBasisActivity.class));
                break;
            case R.id.btn_to_android:
                startActivity(new Intent(MainActivity.this, AndroidBasisActivity.class));
                break;
            case R.id.btn_dialog:
                WindowUtils.listDialog("list", this, "", "", "Ok", "CANCLE", "Three",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showToast("第一个");
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showToast("第二个");

                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showToast("第三个");

                    }
                });
                break;
            case R.id.btn_dialog1:
                    WindowUtils.OkandCancleDialog(this, "title", "提示你呢", "OK", "CANCLE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast("确认了");

                        }
                    }, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast("取消了");

                        }
                    });
                break;
        }
    }

}





