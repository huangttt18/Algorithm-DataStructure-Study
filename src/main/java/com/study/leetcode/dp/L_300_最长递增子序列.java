package com.study.leetcode.dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/7 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_300_最长递增子序列 {

    public static int lengthOfLIS(int[] nums) {
        return back(nums, nums.length - 1);
    }

    private static int back(int[] nums, int start) {
        int max = 1;
        for (int i = 0; i < start; i++) {
            if (nums[i] < nums[start])
                max = Math.max(max, back(nums, i) + 1);
        }
        return max;
    }

    static int[] memo;

    public static int lengthOfLIS2(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return memo(nums, nums.length - 1);
    }

    private static int memo(int[] nums, int start) {
        if (memo[start] != -1)
            return memo[start];
        int max = 1;
        for (int i = 0; i < start; i++) {
            if (nums[i] < nums[start])
                max = Math.max(max, memo(nums, i) + 1);
        }
        memo[start] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
    }
}
