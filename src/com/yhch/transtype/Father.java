package com.yhch.transtype;

public class Father {
    // 1.父类变量
    String var = "FatherVar";

    // 2.父类静态变量
     public static String staticVar = "FatherStaticVar";

    // 3.父类普通方法
    void fun(){
        System.out.println("fatherFun");
    }

    // 4.父类静态方法
    static void staticFun(){
        System.out.println("fatherStaticFun");
    }
}
