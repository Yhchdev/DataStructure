package com.yhch.ch09;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

// 字符文件输入流
public class CharFileInputerStreamDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("/Users/yhchdev/test.txt");
        int data = reader.read();
        // 还没读到结尾
        while (data != -1){
            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();
    }
}
