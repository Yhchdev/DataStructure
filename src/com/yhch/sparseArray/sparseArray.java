package com.yhch.sparseArray;

public class sparseArray {
    public static void main(String[] args) {
        //1.棋盘 => 二维数组
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 1;
        System.out.println("原棋盘数组：");
        for(int [] row : chessArr){
            for(int item:row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        };

      //2.二维数组 => 稀疏数组
        /**
         * 1.获取非零值的数的个数sum,稀疏数组的为 sparseArr[sum+1][3]
         * 2.遍历原数组，将非零值填充在数组中相应的位置
         */
        int sum = 0;
        for (int i = 0;i<11;i++){
            for (int j = 0;j<11;j++) {
                if (chessArr[i][j] !=0){
                    sum++;
                }
            }
        }
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0;i<11;i++){
            for (int j = 0;j<11;j++){
                if(chessArr[i][j] !=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("稀疏数组为：");
        for(int i = 0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //3.稀疏数组 => 二维数组

        System.out.println("由稀疏数组转化出来的二维数组：");
        int converTochessArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i=1;i<sparseArr.length;i++){
            converTochessArr[sparseArr[i][0]][sparseArr[i][0]] = sparseArr[i][2];
        }

        for(int[] row:converTochessArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
