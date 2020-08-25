package com.linjie;

import java.awt.*;

public class TestEnum2 {
    public static void main(String[] args) {
        Color11 c = Color11.RED;
        System.out.println(c.name());
        System.out.println(c.ordinal());
        c.print1();
    }
}

enum Color11{
    RED("red"){
        @Override
        public void print1() {
            System.out.println("red");
        }
    },GREEN("green"){
        @Override
        public void print1() {
            System.out.println("green");
        }
    },YELLOW("yellow"){
        @Override
        public void print1() {
            System.out.println("yellow");
        }
    };
    private Color11(String name){
//        System.out.println(name);
    }
    //抽象方法
    //当在枚举里面写了抽象方法后，需要在每个实例上面都实现抽象方法
    public abstract void print1();
}
