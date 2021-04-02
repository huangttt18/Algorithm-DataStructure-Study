package com.study.leetcode.dp;

import java.util.Arrays;

/**
 * 70. 爬楼梯
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/2 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_70_爬楼梯 {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2;i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 记忆化搜索
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return back(dp, n);
    }

    private static int back(int[] dp, int n) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] == -1)
            dp[n] = back(dp, n - 1) + back(dp, n - 2);

        return dp[n];
    }

    /**
     * 递归: 求到第N阶台阶，需要通过第n - 1阶台阶上1阶或者通过第n - 2 阶台阶上2阶
     *  因此steps(n) = steps(n - 1) + stpes(n - 2)
     *  当n == 0时，一阶都不需要上，因此登上第0阶台阶的方式只有1种
     *  当n == 1时，需要上1阶，此时也只有1种方式
     *  当n > 1时，steps(n - 1) + stpes(n - 2)
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n == 0 || n == 1)
            return 1;
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(climbStairs3(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs(n));
    }
}
