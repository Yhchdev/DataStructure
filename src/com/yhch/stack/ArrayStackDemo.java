package com.yhch.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        boolean loop = true;

        while (loop){
            System.out.println("show:显示栈");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("exit:退出程序");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入要入栈的数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是%d \n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    // 关闭扫描器
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}


// 用数组实现一个栈
class ArrayStack{
    private int maxsize;
    private int[] stack;
    // 栈顶指针
    private int top = -1;


    //构造器
    public ArrayStack(int maxsize){
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxsize-1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int peek(){
        return stack[top];
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈

    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        // 反向遍历 从大到下
        for(int i= top;i>=0;i--){
            int value = stack[i];
            System.out.printf("stack[%d] = %d \n",i,value);
        }
    }
}
