package com.yhch.ch09;


import java.io.*;

public class ObjSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persion persion = new Persion();
        persion.setName("yhch");
        persion.setAge(20);
        persion.setSex('男');

        // 对象的序列化
        // 1、创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/Users/yhchdev/Persion.txt"));
        // 2. 写出对象
        oos.writeObject(persion);
        System.out.println("对象序列化完成！！！");
        oos.close();

        // 1.创建对象输出流
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/Users/yhchdev/Persion.txt"));
        Persion persion1 = (Persion) ois.readObject();
        System.out.println("对象反序列化完成！！！");

        System.out.println(persion1.toString());


    }

}
