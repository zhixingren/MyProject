package com.mysummary.myproject.java_basis.seven_jicheng;

/**
 * Created by xingzhi on 2018/7/10.
 */

class Game {
    public Game(int i){
        System.out.print("Game ");
    }

}

class BoradGame extends Game{

    public BoradGame(int i){
        super(i);
        System.out.print("BoradGame ");
    }
}

public class Chess extends BoradGame{

    public Chess(int i){
        super(i);
    }

    public Chess(){
        super(11);
        System.out.print("Chess ");
    }

    public static void main(String [] args){
       Chess chess = new Chess();

//       System.out.print("\n"+args.length);

    }

}
