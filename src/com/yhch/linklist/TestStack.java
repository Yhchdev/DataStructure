package com.yhch.linklist;


import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack mystack  = new Stack<String>();
        mystack.add("java");
        mystack.add("python");
        mystack.add("javascript");

        System.out.println("出栈："+mystack.pop());
        System.out.println("出栈："+mystack.pop());
        System.out.println("出栈："+mystack.pop());
    }
}
