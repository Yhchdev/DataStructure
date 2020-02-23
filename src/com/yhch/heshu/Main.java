package com.yhch.heshu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            String line = sc.nextLine();
            String arr[] = line.split("\\s");
            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);

            int num =0;

            for (int i = start;i<end;i++){
                boolean ju = Judge(i);
                if(!ju){
                    num++;
                }
            }
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
                sc = null;
            }
        }
    }


    public static boolean Judge(int number) {
        // 满足条件
        boolean a = true;
        //偶数直接退出
        if (number %2 == 0){
            return a;
        }
        for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    a = false;
                    break;
                }
        }
        return a;
    }
}


