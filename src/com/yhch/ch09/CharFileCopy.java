package com.yhch.ch09;

import java.io.*;

// read write 类的使用
// 其他都是针对字节的输入输出
// 对于文本信息使用字符为输入输出单位 效率更高
public class CharFileCopy {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("/Users/yhchdev/source.txt");
        // 出于对性能的考虑 在使用缓冲类对其进行封装
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("/Users/yhchdev/copyfile.txt");
        // 使用缓冲进行封装
        BufferedWriter bw = new BufferedWriter(fw);

        // 读入的字符
        String str = br.readLine();
        while (str!=null){
            bw.write(str);
            // 由于 readLine不读入换行符
            // 手动换行
            bw.newLine();
            str = br.readLine();
        }

        bw.close();
        br.close();

    }
}
