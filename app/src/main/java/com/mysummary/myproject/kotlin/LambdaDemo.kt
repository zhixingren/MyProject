package com.mysummary.myproject.kotlin

import android.annotation.SuppressLint
import android.util.Log
import android.util.Log.println

/**
 * Created by xingzhi on 2019-08-24.
 */
class LambdaDemo {
}

fun main(args:Array<String>){
    postcomput(100, Runnable { println(Log.INFO,"","") })
}


fun postcomput(deley: Int, runnable: Runnable) {

}

