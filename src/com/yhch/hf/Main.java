package com.yhch.hf;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            String line = sc.nextLine();
            String arr [] = line.split("\\s");
            int hand = Integer.parseInt(arr[0]);
            int foot = Integer.parseInt(arr[1]);

            float b = (6*hand-foot)/14;
            float a = hand - 3*b;
            System.out.printf("%.2f %.2f",a,b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
                sc = null;
            }
        }
    }
}
