package com.mysummary.myproject.java_basis.seven_jicheng;

/**
 * Created by xingzhi on 2018/7/10.
 */

public class Cleanser {

    private String s = "Cleanser";


    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.print(x);
    }


}
