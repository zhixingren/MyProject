package com.mysummary.myproject.java_basis.seven_jicheng;

/**
 * Created by xingzhi on 2018/7/10.
 */

public class DetergentDelegation {


    private Detergent detergent = new Detergent();
    private String name ;

    public DetergentDelegation(String name){
        this.name = name ;
    }

    public void scrub(){
        detergent.scrub();
    }

    public void foam(){
        detergent.foam();
    }

    public static void main(String [] args){

        DetergentDelegation d = new DetergentDelegation("DetergentDelegation ");

       d.scrub();
       d.foam();
    }

}
