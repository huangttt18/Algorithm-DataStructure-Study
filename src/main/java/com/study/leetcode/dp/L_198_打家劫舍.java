package com.study.leetcode.dp;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/6 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_198_打家劫舍 {

    public static int rob(int[] nums) {
        int[] memos = new int[nums.length];
        Arrays.fill(memos, -1);
        return memo(memos, nums, 0);
    }

    private static int memo(int[] memos, int[] nums, int start) {
        if (start >= nums.length)
            return 0;

        if (memos[start] != -1)
            return memos[start];

        int res = 0;
        for (int i = start; i < nums.length; i++) {
            res = Math.max(res, nums[i] + memo(memos, nums, start + 2));
        }
        memos[start] = res;
        return res;
    }

    /**
     * 状态：
     * 状态转移方程：
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        // dp[i]：nums[i...length - 1]的最大价值
        int[] dp = new int[length];
        // 最后一家的最大价值就是他自己的价值
        dp[length - 1] = nums[length - 1];
        // 自底向上遍历，计算从nums[length - 2...0]的最大价值
        // i表示当前从哪一家开始偷
        for (int i = length - 2; i >= 0; i--) {
            // 计算从[i]家开始偷到[length - 1]家的最大价值
            for (int j = i; j < length; j++) {
                // 取当前最大价值和新的最大价值的最大值
                // 当前最大价值为dp[i]
                // 新的最大价值为当前偷的这一家的价值nums[j]加上之前的最大价值dp[j + 2]
                // 注意数组越界问题，如果j + 2 >= length，那么表示没有可以被偷的房屋了，此时之前的最大价值应该为0
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < length ? dp[j + 2] : 0));
            }
        }

        return dp[0];
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        // dp[i]：nums[0...i)的最大价值
        // dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2])
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }

        return dp[length];
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public static int rob4(int[] nums) {
        int prev = 0;
        int curr = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
        System.out.println(rob4(nums));
    }
}
