package com.mysummary.myproject.android_basis.greendao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.sqlite.DatabaseHelper;
import com.mysummary.myproject.app.QiandaoApplication;
import com.mysummary.myproject.utils.ToastUtil;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import greendao.dao.gen.DaoMaster;
import greendao.dao.gen.DaoSession;
import greendao.dao.gen.UserBeanDao;

/**
 * Greendao 数据库练习
 *
 */
public class GreenDaoActivity extends AppCompatActivity {

    private UserBeanDao userBeanDao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);

        DaoSession daoSession = ((QiandaoApplication)getApplication()).getDaoSession();
        userBeanDao = daoSession.getUserBeanDao();



        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });


    }

    private void addData() {
        QueryBuilder<UserBean> builder = userBeanDao.queryBuilder();
        UserBean unique = builder.where(UserBeanDao.Properties.Name.eq("张三")).build().unique();
        if (unique==null){
            UserBean bean = new UserBean();
            bean.setName("张三");
            userBeanDao.insert(bean);
            ToastUtil.showToast("新增成功！");
        }else {
            ToastUtil.showToast("新增内容已存在");
        }
    }


    private void delete(){
        QueryBuilder<UserBean> builder = userBeanDao.queryBuilder();
        Query<UserBean> build = builder.where(UserBeanDao.Properties.Name.eq("张三")).build();
        List<UserBean> list = build.list();

        if (list!=null){
          for (UserBean bean:
                list){
              userBeanDao.delete(bean);
          }
        }else {
            ToastUtil.showToast("删除数据失败");
        }

    }

    private void query(){
        QueryBuilder<UserBean> queryBuilder = userBeanDao.queryBuilder();
        List<UserBean> list = queryBuilder.where(UserBeanDao.Properties.Name.eq("张三")).build().list();
        
        if (!list.isEmpty()){
            for (UserBean bean:
                 list) {
                System.out.println(bean.getName());
                System.out.println(bean.getId());
            }
        }else {
            ToastUtil.showToast("查询数据为空");
        }

    }

    /**
     * 数据库升级--思路和sqlite数据库升级一样
     * https://www.jianshu.com/p/020fe137707c
     */
    class MyUpdateHelper extends DaoMaster.DevOpenHelper{

        public MyUpdateHelper(Context context, String name) {
            super(context, name);
        }

        public MyUpdateHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            if (oldVersion<newVersion){
                try{
//                    Log.d("1542", "DatabaseHelper beginTransaction");
//                    db.beginTransaction();
//                    // 1, 将表TABLE_TEST1重命名为TABLE_TEST1+"_temp"
//                    String tempTableName = userBeanDao.getTablename() + "_temp";
//                    String sql = "ALTER TABLE " + DatabaseHelper.TABLE_PERSON + " RENAME TO " + tempTableName;
//                    db.execSQL(sql);
//                    // 2, 创建用户表(字段id、name改变、并新增了以个字段phone)
//                    String sql1 = "create table if not exists " + userBeanDao.getTablename() + "(_id integer primary key autoincrement, name varchar, age integer,sex varchar)";
//
//                    db.execSQL(sql1);
//                    // 3, 将旧表数据导入到新表中,旧表中的id,name,age分别查到新表中的id,name,sign
//                    sql = "INSERT INTO " + userBeanDao.getTablename() + " (" + "_id,name,age" + ") " + " SELECT " + "_id,name,age" + " FROM " + tempTableName;
//                    db.execSQL(sql);
//                    // 4, 删除旧的表
//                    db.execSQL("DROP TABLE IF EXISTS " + tempTableName);
//                    Log.d("1542", "DatabaseHelper middle");
//                    db.setTransactionSuccessful();
//                    //db.setVersion(2);
//                    Log.d("1542", "DatabaseHelper setTransactionSuccessful");
                }catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    db.endTransaction();
                }
            }

        }
    }

}
