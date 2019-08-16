package com.mysummary.myproject.android_basis.kotlin

/**
 * Created by xingzhi on 2019-08-10.
 */

fun twoAnd(operat:(Int,Int) -> (Int)):Int{

   return operat(2,3)

}


fun String.filter(pre:(Char) -> Boolean):String{

    val stringBuffer = StringBuilder()

    for (index in 0 .. length){
        val e = get(index)
        if (pre(e)){
            stringBuffer.append(e)
        }
    }
    return stringBuffer.toString()
}

fun plus(ad:(Int,Int) -> Unit ){
    ad(2,3)
}