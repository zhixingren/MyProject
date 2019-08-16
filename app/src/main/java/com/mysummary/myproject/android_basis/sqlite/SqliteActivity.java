package com.mysummary.myproject.android_basis.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mysummary.myproject.R;

public class SqliteActivity extends AppCompatActivity {

    // 数据库助手
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        helper = DatabaseHelper.getDBHelper(this);

    }


    // 创建数据库
    public void createDatabase(View view) {
        // 通过数据库助手，创建一个数据库对象
        SQLiteDatabase db = helper.getReadableDatabase();
        // 当数据库不使用时，关闭
        db.close();

        Log.d("1542", "db created in activity");
    }

    // 插入数据
    public void insertData(View view) {
        SQLiteDatabase db = helper.getReadableDatabase();
        // 插入一条数据
        ContentValues values = new ContentValues();
        values.put("name", "张三");
        values.put("age", 18);

        // 插入数据
        // table：表名
        // nullColumnHack：当插入数据为null时，nullColumnHack不允许其为空，从而保证了系统的稳定性。多数情况下，插入的数据不为null，则nullColumnHack用不上，则为null
        // values：插入的数据
        db.insert(DatabaseHelper.TABLE_PERSON, null, values);

        db.close();
    }

    // 删除数据
    public void deleteData(View view) {
        SQLiteDatabase db = helper.getReadableDatabase();
        // 删除一条数据
        // table：操作的表名
        // whereClause：删除条件
        // whereArgs：满足的删除条件
        db.delete(DatabaseHelper.TABLE_PERSON, "name = ?", new String[]{"张三"});

        db.close();
    }

    // 修改数据
    public void updateData(View view) {
        SQLiteDatabase db = helper.getReadableDatabase();
        // 修改一条数据
        // table：操作的表名
        // values：修改后的数据
        // whereClause：修改条件
        // whereArgs：满足修改的条件
        ContentValues values = new ContentValues();
        values.put("name", "赵四");
        values.put("age", 17);
        db.update(DatabaseHelper.TABLE_PERSON, values, "name = ?", new String[]{"张三"});

        db.close();
    }

    // 查询数据
    public void queryData(View view) {
        SQLiteDatabase db = helper.getReadableDatabase();
        // 查询数据
        // table：查询的表名
        // columns：代表被查询的字段
        // selection：查询条件
        // selectionArgs：满足查询的条件
        // groupBy：指定分组（多数情况用不上）
        // having：分组筛选数据的关键字（多数情况用不上）
        // orderBy：排序。如果null则为默认排序
//        Cursor cursor = db.query(DatabaseHelper.TABLE_PERSON, new String[]{"name", "age"}, "name = ?", new String[]{"张三"}, null, null, null);
        int version = db.getVersion();

        Log.d("1542",version+"");
        Cursor cursor = db.query(DatabaseHelper.TABLE_PERSON, null, null, null, null, null, null);

        String[] columnNames = cursor.getColumnNames();
        for (int i = 0; i <columnNames.length ; i++) {
            Log.d("1542", "columnNames : " + columnNames[i]);

        }


        // 字段对应的索引值
        int nameIndex = cursor.getColumnIndex("name");
        int ageIndex = cursor.getColumnIndex("age");
        // 遍历查询数据
        while (cursor.moveToNext()) {
            // 通过索引值间接获取字段对应的数据
            int age = cursor.getInt(ageIndex);
            String name = cursor.getString(nameIndex);

            Log.d("1542", "name : " + name + ", age : " + age);

        }

        cursor.close();
        db.close();
    }



}


