package com.yhch.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class BubbleSort {
    public static void main(String[] args) {
        //int[] array = {89, -3, 5, -9, 0, 3};

        int [] array = new int[80000];
        for (int i=0;i<80000;i++){
            array[i] = (int)(Math.random()*80000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");

        Date date1 = new Date();
        System.out.println("排序前时间："+simpleDateFormat.format(date1));

        bubbleSort(array);
        Date date2 = new Date();
        System.out.println("排序后时间："+simpleDateFormat.format(date2));


        /*
        System.out.println(Arrays.toString(array));
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
         */
    }



    // 时间复杂度 O(n^2)
    private static void bubbleSort(int[] array){
        // 判断是否进行了交换
        boolean flage = false;
        //辅助变量
        int temp = 0;
        for (int i=0;i< array.length-1;i++) {
            for (int j = 0; j < array.length - 1 -i; j++) {
                if (array[j] > array[j + 1]) {
                    // 这一趟发生过交换
                    flage = true;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序");
//            System.out.println(Arrays.toString(array));

            if(!flage){
                break; //这一趟没有发生过交换
            }else {
                flage = false; //  重置flage，不然flage一直为true，无效
            }
        }
    }
}
