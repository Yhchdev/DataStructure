package com.yhch.ch12;

// java 线程： 主线程

// 不会等线程处理完再顺序执行
// 并行
public class TestSeelpDemo {
    public static void main(String[] args) throws InterruptedException {
        String ThreadName = Thread.currentThread().getName();
        System.out.println(
                ThreadName + "Thread Start..."
        );
        // 创建Thread 线程对象  并把接口对象作为构造参数 传递进去
        Thread t1 = new Thread(new MyRunnable3(),"Thread1");
        Thread t2 = new Thread(new MyRunnable3(),"Thread2");
        t1.start();
        t2.start();

        Thread.sleep(4000);
        System.out.println(
                ThreadName + "Thread End..."
        );
    }
}

// java 线程 ： 子线程
// 1.实现Runnable接口
class MyRunnable3 implements Runnable{

    // 2.重写run 方法
    @Override
    public void run(){
        System.out.println("Thread Start.... => "+Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Start.... => "+Thread.currentThread().getName());
    }
}

