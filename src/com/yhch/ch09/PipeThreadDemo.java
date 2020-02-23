package com.yhch.ch09;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// 发送方
class Send implements Runnable{
    // 管道输出流
    PipedOutputStream pos = null;
    public Send(){
        this.pos = new PipedOutputStream() ;
    }
    @Override
    public void run(){
        String str =  "Hello world!!!";
        try {
            // 将字符串作为二进制流写出
            pos.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //get方法
    public PipedOutputStream getPos() {
        return pos;
    }
}

// 接收消息类
class Receive implements Runnable{
    PipedInputStream pis = null;

    public Receive(){
        pis = new PipedInputStream();
    }

    @Override
    public void run() {

        byte[] b = new byte[1024];

        int len = 0;

        try {
            len = pis.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接收到的信息:" +new String(b,0,len)  );
    }

    public PipedInputStream getPis() {
        return pis;
    }
}

// 使用管道流 在两个线程中通信
public class PipeThreadDemo {
    public static void main(String[] args) {
        Send send = new Send();
        Receive re = new Receive();
        try {
            //用 connect 连接输出流和输入流
            //re.getPis().connect(send.getPos());
            send.getPos().connect(re.getPis());
        } catch (IOException e) {
            e.printStackTrace();
        }


        Thread sendt = new Thread(send);
        Thread ret = new Thread(re);

        sendt.start();
        ret.start();

    }
}
