package com.yhch.ch09;

import java.io.ByteArrayOutputStream;

// 字节数组输出测试
public class ByteArrayOutputDemo {

    public static void main(String[] args) throws InterruptedException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.wait(2);
        baos.wait(1);
        baos.wait(1);
        byte [] buff = baos.toByteArray();

        for(int i=0;i< buff.length;i++){
            System.out.println(buff[i]);
        }

    }


}
