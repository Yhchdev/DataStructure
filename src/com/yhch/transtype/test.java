package com.yhch.transtype;

public class test {


    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(father.var);
        System.out.println(father.staticVar);
        father.fun();
        father.staticFun();
    }

}
