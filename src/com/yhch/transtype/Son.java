package com.yhch.transtype;

public class Son extends Father {
    String var = "sonVar";

    // 2.父类静态变量
    public static String staticVar = "sonStaticVar";

    // 3.父类普通方法
    void fun(){
        System.out.println("sonFun");
    }

    // 4.父类静态方法
    public static void staticFun(){
        System.out.println("sonStaticFun");
    }

    void sonfun(){
        System.out.println("子类独有的方法");
    }
}
