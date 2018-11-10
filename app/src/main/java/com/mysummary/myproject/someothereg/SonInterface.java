package com.mysummary.myproject.someothereg;

import android.util.Log;

/**
 * Created by xingzhi on 2018/5/19.
 */

public class SonInterface extends FatherClass implements FatherInterface{

    @Override
    public void getFatherInterfacFirst() {
        Log.e("SonInterface","SonInterface");
    }

    public void getFatherFirst(){
        System.out.print("getFatherFirst");
    }

}
