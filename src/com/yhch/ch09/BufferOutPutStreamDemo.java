package com.yhch.ch09;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 输出缓冲流
public class BufferOutPutStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("/Users/yhchdev/my.txt"));

        // 将数据写入缓冲区
        bos.write("oneLine".getBytes());
        bos.write("\n".getBytes());// 写入换行符
        bos.write("twoLine".getBytes());
        bos.write("\n".getBytes());

        // 将缓冲区的内容写入到目的地
        if(bos !=null){
            try {
                bos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                bos.close();
            }
        }
    }
}
