package com.yhch.ch09;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//缓冲输入流
// 将数据 加载到缓冲区 具有更高的输入效率
public class BufferIpsDemo {
    public static void main(String[] args) throws IOException {
       BufferedInputStream bis = null;
       // 新建字符缓冲区
       byte[] buffer = new byte[1024];

       bis = new BufferedInputStream(new FileInputStream("/Users/yhchdev/test.txt"));
       int readByte = 0;
       // 读取流到缓冲区
       while ((readByte = bis.read(buffer)) != -1){
            String s = new String(buffer,1,readByte);
            System.out.println(s);
        }
    }
}
