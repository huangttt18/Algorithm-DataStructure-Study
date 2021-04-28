package com.study.leetcode.dp;

/**
 * 背包问题
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/15 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class N_背包问题 {

    public static int knapsack(int[] vals, int[] caps) {
        int m = vals.length;
        int n = caps.length;
        assert m == n : "两个数组的长度必须相等";

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = caps[i - 1] > j ? dp[i - 1][j] : Math.max(dp[i - 1][j], vals[i - 1] + dp[i - 1][j - caps[i - 1]]);
            }
        }
        printDp(dp);
        return dp[m][n];
    }

    private static void printDp(int[][] dp) {
        assert dp != null : "入参dp数组不能为null";
        int m = dp.length;
        int n = dp[0].length;
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < m; i++) {
            sb.append("\t[");
            for (int j = 0; j < n; j++) {
                if (j == n - 1)
                    sb.append(dp[i][j]).append("],\n");
                else
                    sb.append(dp[i][j]).append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
//        int[] vals = {1500, 3000, 2000, 2000};
//        int[] caps = {1, 4, 3, 1};
        int[] vals = {2000, 2000, 3000, 1500};
        int[] caps = {1, 3, 4, 1};
        System.out.println(knapsack(vals, caps));
    }
}
