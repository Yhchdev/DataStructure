package com.yhch.geshu;

import java.util.Scanner;

public class geshu {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            String line = sc.nextLine();
            String arr []  = line.split("\\s");
            int num = arr.length - 1;
            getCounts(line,num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
                sc = null;
            }
        }
    }



    public static void getCounts(String string,int num) {
        int count_abc=0, count_num=0, count_oth=0;
        int count [] = null;
        char[] chars = string.toCharArray();
        //判断每个字符
        for(int i = 0; i < chars.length; i++){
            if((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <=122)){
                count_abc++;
            }else if(chars[i] >= 48 && chars[i] <= 57){
                count_num++;
            }else{
                count_oth++;
            }
        }
        count_oth -= num;
        System.out.println(count_abc);
        System.out.println(count_num);
        System.out.println(count_oth);
    }

}
