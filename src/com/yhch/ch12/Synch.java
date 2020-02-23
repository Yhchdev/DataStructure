package com.yhch.ch12;

class Callme{
    //method1 => synchronized修饰方法   同步方法
    // 确保某一时刻 只有一个线程可以进入call方法
    void call(String msg){
    //synchronized void call(String msg){
        System.out.println("["+msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String msg;
    Callme target;
    Thread thread;
    public Caller(Callme target,String msg){
        this.target = target;
        this.msg = msg;
        thread = new Thread(this);
        thread.start();
    }

    // 多个对象 竞争调用同一方法
    @Override
    public void run(){
        //target.call(msg);
        // method2 : 同步代码块
        synchronized (target) {
            target.call(msg);
        }
    }


}

public class Synch {
    public static void main(String[] args) {
        System.out.println("main Thread start");
        Callme callme = new Callme();

        Caller obj1 = new Caller(callme,"hello");
        Caller obj2 = new Caller(callme,"synchronized");
        Caller obj3 = new Caller(callme,"world");

        try {
            obj1.thread.join();
            obj2.thread.join();
            obj3.thread.join();
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("main Thread is over!!!");
    }
}
