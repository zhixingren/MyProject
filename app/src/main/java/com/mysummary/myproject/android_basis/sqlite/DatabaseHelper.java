package com.mysummary.myproject.android_basis.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by xingzhi on 2018/7/9.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // 数据库文件名
    private final static String DB_NAME = "my_database.db";
    // 数据库版本号
    private final static int DB_VERSION = 2;

    // 数据库表名
    public final static String TABLE_PERSON = "table_person";

    private static volatile DatabaseHelper instance = null;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        String sql = "create table if not exists " + TABLE_PERSON + "(_id integer primary key autoincrement, name varchar, age integer)";

        String sql = "create table if not exists " + TABLE_PERSON + "(_id integer primary key autoincrement, name varchar, age integer,sex varchar)";



        // 执行创建表的sql语句
        db.execSQL(sql);
        Log.d("1542", "DatabaseHelper onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        for (int i = oldVersion; i < newVersion; i++) {
            switch (i) {
                case 1:
                    updateUpgradeToVersion2(db);//修改表原有字段并新增字段
                    Log.d("1542", "DatabaseHelper onUpgrade");
                    break;
                default:
                    break;
            }
        }

    }

    public static DatabaseHelper getDBHelper(Context context) {
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null)
                    instance = new DatabaseHelper(context);
            }
        }
        return instance;
    }



    private void updateUpgradeToVersion2(SQLiteDatabase db) {
        try{
            Log.d("1542", "DatabaseHelper beginTransaction");
            db.beginTransaction();
            // 1, 将表TABLE_TEST1重命名为TABLE_TEST1+"_temp"
            String tempTableName = DatabaseHelper.TABLE_PERSON + "_temp";
            String sql = "ALTER TABLE " + DatabaseHelper.TABLE_PERSON + " RENAME TO " + tempTableName;
            db.execSQL(sql);
            // 2, 创建用户表(字段id、name改变、并新增了以个字段phone)
            String sql1 = "create table if not exists " + TABLE_PERSON + "(_id integer primary key autoincrement, name varchar, age integer,sex varchar)";

            db.execSQL(sql1);
            // 3, 将旧表数据导入到新表中,旧表中的id,name,age分别查到新表中的id,name,sign
            sql = "INSERT INTO " + DatabaseHelper.TABLE_PERSON + " (" + "_id,name,age" + ") " + " SELECT " + "_id,name,age" + " FROM " + tempTableName;
            db.execSQL(sql);
            // 4, 删除旧的表
            db.execSQL("DROP TABLE IF EXISTS " + tempTableName);
            Log.d("1542", "DatabaseHelper middle");
            db.setTransactionSuccessful();
            db.setVersion(2);
            Log.d("1542", "DatabaseHelper setTransactionSuccessful");
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

    }


}
