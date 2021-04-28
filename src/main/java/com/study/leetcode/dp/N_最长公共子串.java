package com.study.leetcode.dp;

/**
 * 最长公共子串
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/16 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class N_最长公共子串 {

    public static int longestCommonSubstring(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        int[][] dp = new int[lenS1 + 1][lenS2 + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lenS1 + 1; i++) {
            for (int j = 0; j < lenS2 + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "has", s2 = "saha";
        System.out.println(longestCommonSubstring(s1, s2));
    }
}
