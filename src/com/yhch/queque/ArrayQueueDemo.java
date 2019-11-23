package com.yhch.queque;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

        // 测试
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        //不知道循环次数
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据队列");
            System.out.println("g(get): 获取队列数据");
            System.out.println("p(peek): 查看队列首元素");
            System.out.println("e(exit): 退出系统");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    try {
                        arrayQueue.showQueue();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数！！！");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'g':
                    try{
                        int n2 = arrayQueue.getQueue();
                        System.out.printf("取出的数据为%d\n",n2);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 'p':
                    try{
                        int n2 = arrayQueue.peek();
                        System.out.printf("队首的数据为%d\n",n2);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("你已经退出了系统");
    }
}

//用数组实现队列
class ArrayQueue{
    private int MaxSize;//数组最大容量
    private int front; //队列的头部
    private int rear; //队尾
    private int [] arr; //数组队列

    // 1. 创建数组
    public ArrayQueue(int maxSize){
        this.MaxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1; // 队列首部 前一个
        this.rear = -1; //队尾
    }

    // 2. 判断队列是否满
    public boolean isFull(){
        return rear == MaxSize -1 ;
    }

    // 3. 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 4. 数据入队列
    public void addQueue(int n){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满,不能再加数据了");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    // 5.数据出队列
    public int getQueue(){
        //队列为空 引发异常
        if(isEmpty()){
            throw new RuntimeException("队列已经为空，不能取出数据了");
        }
        front ++;
        return arr[front];
    }

    // 6. 查看队头元素
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front+1];
    }

    // 7.查看所有元素
    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无数据");
        }
        for(int i=0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }




}
