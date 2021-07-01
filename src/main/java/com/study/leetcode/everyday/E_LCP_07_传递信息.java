package com.study.leetcode.everyday;

/**
 * LCP 07. 传递信息
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/1</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_LCP_07_传递信息 {

    public static int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0];
                int dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {

    }

}
