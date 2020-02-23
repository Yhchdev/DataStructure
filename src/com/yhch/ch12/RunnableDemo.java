package com.yhch.ch12;

public class RunnableDemo {

    public static void main(String[] args) {
        // 接口对象
        MyThread2 myThread = new MyThread2();
        //3. 通过Thread 类 创建线程对象，接口对象作为接口对象的参数 传递
        //4. 调用 start() 方法
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();

    }


}

// 1. 实现 Runable 接口
class MyThread2 implements Runnable{
    private int ticket = 8;
    // 2. 重写run 方法 => 将需要多线程执行的方法 放在 run方法内
    public void run() {
        for(int i=0;i<10;i++){
            if(ticket>0) {
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}
