package com.yhch.Win;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 4, 5, 7, 8, 11, 12, 15};
        System.out.println(solution.FindNumbersWithPro(nums, 60));
    }


    public String FindNumbersWithPro(int[] nums, int target) {
        StringBuffer result = new StringBuffer();
        int len = nums.length;
        int front = 0;
        int behind = len - 1;
        while (front <= behind) {
            int product = nums[front] * nums[behind];
            if (product == target) { //满足条件
                result.append("[");
                result.append(nums[front]);
                result.append(",");
                result.append(nums[behind]);
                result.append("]");
                // 满足条件指针继续向下走
                front++;
                continue;
            } else if (product < target) {
                front++;
            } else {
                behind--;
            }
        }
        if (result.length() ==0 ){
            result.append("[-1,-1]");
        }
        return result.toString();
    }
}
