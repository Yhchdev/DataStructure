package com.yhch.recursion;

// 八皇后问题 8 X 8
public class Queen8 {
    int max = 8;
    int[] array = new int[max];
    private static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法：",count);

    }

    // 编写一个方法 放置第n个皇后
    private void check(int n){
        if(n == max){ // n=8 其实8个皇后已经放好了
            print();
            return;
        }
        for(int i=0;i<max;i++){ // 0 1 2 3 4 5 6 7 8
            //先把这个皇后n 放到该行的第1列
            array[n] = i; // array[0] 第一行 n=> 行  i=> 列
            if(judge(n)){
                // 接着放第n+1个皇后 开始递归
                check(n+1);    // n=> 行 n+1 直到8
            }
        }
    }


    // 查询当我们摆放第n个皇后 是 和前面已经摆放的皇后是否冲突
    private boolean judge(int n ){
        for(int i = 0;i<n;i++){
            // array[i] == array[n] 同一列
            // Math.abs(n-i) == Math.abs(array[n] - array[i])
            // |y1 - y2| == |x1 -x2| 正方形 斜率 相同 在对角线上
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
