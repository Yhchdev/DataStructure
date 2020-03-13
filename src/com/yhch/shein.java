package com.yhch;

import java.util.Scanner;
public class shein{
        public static void main(String[] args) {
            String str=new Scanner(System.in).nextLine();
            String[] split = str.split(" ");
            StringBuilder res=new StringBuilder();
            for (int i = split.length-1; i >=0; i--) {
                if(i==0){
                    res.append(split[i]);
                }else
                    res.append(split[i]+" ");
            }
            System.out.println(res.toString());
        }
}