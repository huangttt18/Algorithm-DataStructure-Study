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

    /**
     * 状态：dp[i]：表示以第i个元素为结尾的最长的递增子序列的长度（包含nums[i]）
     */
    public static int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            // 计算以第i个元素为结尾的最长递增子序列的长度
            for (int j = 0; j < i; j++) {
                // 如果nums[i] < nums[j]，表示以第i个元素为结尾的递增子序列已经不递增了
                if (nums[i] > nums[j])
                    // 表示此时[j...i]还在递增
                    // dp[j]表示以第j个元素为结尾的最长递增子序列的长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < length + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int lengthOfLIS4(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[] top = new int[length];
        int piles = 0;
        for (int i = 0; i < length; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker)
                    right = mid;
                else if (top[mid] < poker)
                    left = mid + 1;
                else
                    right = mid;
            }
            if (left == piles)
                piles++;
            top[left] = poker;
        }

        return piles;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
    }
}
