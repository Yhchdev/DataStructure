package com.yhch.sort;

public class Selection {
    /**
     *
     * 选择排序
     * 1.找出数组中最小的元素，将其与第一个元素交换位置；
     * 2.从第二个起，找出最小的元素，将其与第二个元素交换位置；
     * 3.以此类推。。。。3，4，5
     */
    public static int []  sort(int[] shortArr){

        int N = shortArr.length;
        for(int i=0;i<N;i++){
            //从此排序完成之后查找
            int min = i;
            for (int j = i+1;j< N;j++){
                if(shortArr[j]<shortArr[min]){
                    //min 一直记录了最小值的index
                    min = j;
                }
            }
            //一遍查找下来，已经找到了最小的值的index，和起始位置相互交换
            int t = shortArr[i];
            shortArr[i] = shortArr[min];
            shortArr[min] = t;
        }
        return shortArr;


    }



    //遍历输出数组
    public static void show(int [] arr){
        for (int item:arr){
            System.out.printf("%d\t",item);
        }
    }
    public static void main(String[] args) {

        //step1 => 生成随机数组
        int [] sortArr = new int[100];
        for(int i=0;i<100;i++){
            sortArr[i] = (int)(Math.random()*100);
        }
        System.out.println("原序列：");
        show(sortArr);
        System.out.println();
        System.out.println("排序后的序列");
        int [] sortedArr = sort(sortArr);
        show(sortedArr);

    }
}
