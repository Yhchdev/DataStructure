package com.yhch.ch09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 文件输出流
public class FileOutPutDemo {
    public static void main(String[] args) throws IOException {

        // 1. 新建文件输出流类（指定文件路径）
        // 2. 调用write 方法
        FileOutputStream fos = new FileOutputStream("/Users/yhchdev/javawritefile.txt");
        fos.write("FilterOutPutStream是OutPutStream的装饰器提供扩展功能".getBytes());
        //fos.write("OneLine".getBytes());
        //fos.write("\n".getBytes()); // 换行

        fos.close();





    }
}
