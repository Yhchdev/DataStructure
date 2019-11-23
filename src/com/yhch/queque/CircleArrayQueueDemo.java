package com.yhch.queque;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // 测试
        CircleQueue circleQueue = new CircleQueue(4);
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
                        circleQueue.showQueue();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数！！！");
                    int n = scanner.nextInt();
                    circleQueue.addQueue(n);
                    break;
                case 'g':
                    try{
                        int n2 = circleQueue.getQueue();
                        System.out.printf("取出的数据为%d\n",n2);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 'p':
                    try{
                        int n2 = circleQueue.peek();
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

//数组队列的问题 数组只能使用一次
// 优化: 通过取模运算 实现环形队列

// 队首 front 0 指向队列的首元素
// 队尾 rear 初始 0 指向队列尾部最后一个元素的下一位置
// 队尾指向最后一个元素 +1
// 队空  front == rear
// 环形队列满  (rear + 1) % maxsize == front
// 有效元素个数 (rear + maxsize - front) % maxsize

class CircleQueue{
    private int MaxSize;//数组最大容量
    private int front; //队列的头部
    private int rear; //队尾
    private int [] arr; //数组队列

    // 1. 创建数组
    public CircleQueue(int maxSize){
        this.MaxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0; // 队列首部
        this.rear = 0; //队尾 后一个元素
    }

    // 2. 判断队列是否满
    public boolean isFull(){
        return (rear + 1) % MaxSize == front ;
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
        arr[rear] = n;
        rear = (rear + 1) % MaxSize ;
    }

    // 5.数据出队列
    public int getQueue(){
        //队列为空 引发异常
        if(isEmpty()){
            throw new RuntimeException("队列已经为空，不能取出数据了");
        }
        int value = arr[front];
        front = (front+1) % MaxSize;
        return value;
    }

    // 6. 查看队头元素
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front];
    }

    // 7.查看所有元素
    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无数据");
        }
        for(int i= front;i< front+size();i++) {
            System.out.printf("arr[%d]=%d\n",i % MaxSize,arr[i % MaxSize]);
        }
    }

    // 8.获取环形队列数据的有效个数
    public int size(){
        int num = (rear + MaxSize - front) % MaxSize;
        return num;
    }
}
