package com.study.leetcode.dp;

/**
 * 516. 最长回文子序列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/6 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_516_最长回文子序列 {

    /**
     * dp[i][j]：表示子序列[i...j]的最长回文子序列的长度
     */
    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 : Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
