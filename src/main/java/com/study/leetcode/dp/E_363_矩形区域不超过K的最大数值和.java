package com.study.leetcode.dp;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/22 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_363_矩形区域不超过K的最大数值和 {

    /**
     * 二维矩阵前缀和
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        int max;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int a = i; a < m + 1; a++) {
                    for (int b = j; b < n + 1; b++) {
                        max = dp[a][b] - dp[i - 1][b] - dp[a][j - 1] + dp[i - 1][j - 1];
                        if (max <= k)
                            ans = Math.max(max, ans);
                    }
                }
            }
        }

        return ans;
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
                    sb.append(dp[i][j]).append("]").append(i == m - 1 ? "" : ",").append("\n");
                else
                    sb.append(dp[i][j]).append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        int k = 3;
        maxSumSubmatrix(matrix, k);
    }
}
