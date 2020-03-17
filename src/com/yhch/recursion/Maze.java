package com.yhch.recursion;

public class Maze {
    public static void main(String[] args) {
        // 初始化地图
        int[][] map = new int[8][7];

        // 上下墙
        for(int i=0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右墙
        for(int i =1;i<7;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置中间的挡板
        map[5][1] = 1;
        //map[6][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[3][3] = 1;
        map[2][3] = 1;


        System.out.println("原始迷宫");
        getMap(map);

        if(setWay(map,1,1)){
            System.out.println("找到出口了！！！！");
            System.out.println("递归回溯路径如下:");
            getMap(map);
        }


    }

    /**
     *
     * @param map 迷宫
     * @param i 起始位置i
     * @param j 起始位置j
     * @return 表示是否能走通
     *  0(默认): 还没有走过
     *  1： 墙
     *  2： 已经走过了 能走通
     *  3： 已经走过了 走不通
     *  走迷宫的策略：下 -> 右 -> 上 -> 左
     *  迷宫出口：map[6][5]
     *
     */
    public static boolean setWay(int[][]map,int i,int j){
        // 已经找到出口了
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){ //还没有走过
                map[i][j] = 2 ; //假定这个点能走通
                // 探查策略：下 -> 右 -> 上 -> 左
                if(setWay(map,i+1,j)){ //向下走
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else {
                    // 下 -> 右 -> 上 -> 左 都走过了 走不通
                    // 是死路，假定错误，重新标记该点是死路
                    map[i][j] = 3;
                    return false;
                }
            }else { //map[i][j]!=0 2 3 1
                return false;
            }
        }
    }

    // 输出地图
    public static void getMap(int[][] map){
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
