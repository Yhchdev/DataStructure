package com.yhch.ch12;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

// 1. 继承 Thread类
class MyThread extends Thread{
    // 2. 覆写 run 方法
    public void run(){
        System.out.println("线程要执行的方法");
    }
}
