package com.study.leetcode.everyday;

/**
 * 1143. 最长公共子序列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/3 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1143_最长公共子序列 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        String text1 = "psnw", text2 = "vozsh";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
