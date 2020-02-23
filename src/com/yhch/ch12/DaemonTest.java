package com.yhch.ch12;

// 用户线程
class MyCommon extends Thread{
    public void run(){
        //用户线程 执行5次
        for(int i=0;i<5;i++){
            System.out.println("用户线程：执行了"+i+"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


// 守护线程
class DaemonThread implements Runnable {
    @Override
    public void run(){
        // 守护线程执行100次；
        // 但是执行5次后，由于用户线程的退出、所以守护线程也随之退出了
        for(int i=0;i<100;i++){
            System.out.println("守护线程：执行了"+i+"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


// 守护线程的实例
public class DaemonTest {
    public static void main(String[] args) {
        MyCommon common = new MyCommon();
        Thread t = new Thread(new DaemonThread());
        // 设置一个线程为 守护线程
        // 守护线程里面一般 不写业务逻辑 一般是资源回收
        // jvm的垃圾回收就是一个典型的守护线程
        t.setDaemon(true);

        common.start();
        t.start();

    }
}
