package com.yhch.recursion;

// 递归
public class RecursionTest {

    public static void main(String[] args) {
        test(4);
    }

    private static void test(int n){
        if(n>2){
            test(n-1); //4 -> 3 -> 2
        }
        System.out.printf("n = %d\n",n); // 2 3 4
    }
}
