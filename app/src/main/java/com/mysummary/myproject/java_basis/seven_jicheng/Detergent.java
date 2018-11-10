package com.mysummary.myproject.java_basis.seven_jicheng;

/**
 * Created by xingzhi on 2018/7/10.
 */

public class Detergent extends Cleanser {


    public Detergent(){
        super();
    }

    public void scrub(){
        append(" Detergent scrub()");
        super.scrub();
        System.out.print("");
    }

    public void foam(){

        append(" foam()");
    }

    public static void main(String [] args){
        Detergent x = new Detergent();

        x.dilute();
        x.apply();
        x.scrub();
        x.foam();

        System.out.print(x);
        System.out.print("Test ");

        Cleanser.main(args);

        System.out.print("\n"+args.length);

    }
}
