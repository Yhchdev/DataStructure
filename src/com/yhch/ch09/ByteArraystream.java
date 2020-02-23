package com.yhch.ch09;


import java.io.ByteArrayInputStream;
import java.io.IOException;

// 字节数组输入流的用法
public class ByteArraystream {
    public static void main(String[] args) {

        byte [] buff = {1,15,56,-1,-19,17};

        //创建一个字节数组输入流对象
        ByteArrayInputStream bytearrInput = new ByteArrayInputStream(buff,1,4);
        // 读取单个数据
        int data = bytearrInput.read();
        while (data != -1){
            System.out.println(data + " ");
            data = bytearrInput.read();
        }

        // 读取结束 => 关闭流
        try {
            bytearrInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
