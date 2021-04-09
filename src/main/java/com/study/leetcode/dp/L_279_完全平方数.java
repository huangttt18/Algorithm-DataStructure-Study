package com.study.leetcode.dp;

/**
 * 279. 完全平方数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/6 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_279_完全平方数 {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
