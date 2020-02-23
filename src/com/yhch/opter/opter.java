package com.yhch.opter;

public class opter {
    public static void main(String[] args) {
//        int a = 10;
//        int b = 10;
//
//        for(int i = 0;i<10;i++){
//            System.out.println(++a);
//        }

        //System.out.println("i++ 先取值再+1  "+   a++);
        //System.out.println("++i 先+1再取值 "+ ++b);


        Integer a = 10;
        Integer b = 10;
        //String str = "yhch";
        // 1.比较基本数据类型的时候 == 和 equals效果相同
        System.out.println(a==b);
        System.out.println(a.equals(b));

        //2. 比较两个string类型

        String c = "yhch";
        String d = "yhch";

        //开辟了新的内存空间
        String e = new String("yhch");

        // 两个值相同的String值，指向了同一个引用地址
        System.out.println(c.equals(d)); //true

        System.out.println(c == d);//true

        System.out.println(c == e);//false

        System.out.println(c.equals(d));//true






        //Student student1 = new Student();

    }


//    public class Student{
//        public int id;
//        public String name;
//
//
//    }
}


