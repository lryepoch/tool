package com.problem.others;

import java.util.Scanner;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class ArraytoAim {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[4];
        Scanner sc = new Scanner(System.in);        //输入数组
        for (int k = 0; k < nums.length; k++)
            nums[k] = sc.nextInt();

        int target = sc.nextInt();                        //输入数字
        int[] is = solution.twoSum(nums, target);
        for (int i = 0; i < is.length; i++)
            System.out.println("结果为" + is[i]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {        //暴力求解
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        throw new IllegalArgumentException("No two sum solution");
        //return new int[2];                                     //不存在输出两个0
    }

}
