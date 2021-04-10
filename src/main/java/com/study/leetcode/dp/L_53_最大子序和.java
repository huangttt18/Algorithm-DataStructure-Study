package com.study.leetcode.dp;

/**
 * 53. 最大子序和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/9 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_53_最大子序和 {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 数组长为n
     * 对于[0...n - 1]
     * [0]的最大和为[0]
     * [1]的最大和为max([0], [0...0] + [1])
     * [2]的最大和为max([0], [0...1] + [2])
     * <p>
     * 状态(子问题)：dp(n - 1)
     * 状态转移方程(子问题之间的关系)：f(n) = max(f(n - 1) + nums[n], f(n - 1))
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        // dp[n] = max(nums[n], dp[n - 1] + nums[n])
        int[] dp = new int[length + 1];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static int maxSubArray2(int[] nums) {
        int length = nums.length;
        // dp[n] = max(nums[n], dp[n - 1] + nums[n])
        int pre = 0;
        int ans = nums[0];
        for (int i = 0; i < length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {5, 4, -1, 7, 8};
//        int[] nums = {-100000};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }
}
