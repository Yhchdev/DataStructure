package com.yhch.ch09;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 文件输入流demo
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/Users/yhchdev/test.txt");
        int len = fis.available();
        while (len>0){
            System.out.print((char)fis.read());
            len --;
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
