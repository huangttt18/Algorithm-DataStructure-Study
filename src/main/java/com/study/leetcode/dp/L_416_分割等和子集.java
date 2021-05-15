package com.study.leetcode.dp;

/**
 * 416. 分割等和子集
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/8 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_416_分割等和子集 {

    public static boolean canPartition(int[] nums) {
        // 等和子集，表示两个子集的和为nums的和，也就是每个子集和为sum(nums) / 2，这也就是背包的容量
        // nums -> 物品总和
        // sum -> 背包容量
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0)
            return false;
        sum = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - nums[i - 1] < 0)
                    // 背包容量不足，不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                else
                    // 背包容量充足，可以选择装或者不装第i个物品
                    dp[i][j] = dp[i - 1][j] /* 不装第i个物品 */ || dp[i - 1][j - nums[i - 1]] /* 装第i个物品 */;
            }
        }

        return dp[len][sum];
    }

    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0)
                    dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {

    }
}
