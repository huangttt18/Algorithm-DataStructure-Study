package com.study.leetcode.dp;

import java.util.Arrays;

/**
 * 712. 两个字符串的最小ASCII删除和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/6 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_712_两个字符串的最小ASCII删除和 {

    /**
     * dp[i][j]：[0...s1.i] - [0...s2.j]最长公共子序列的ascii和
     */
    public static int minimumDeleteSum(String s1, String s2) {
        if (s1.equals(s2))
            return 0;
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + (int) c1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return sumAscii(s1) + sumAscii(s2) - 2 * dp[m][n];
    }

    private static int sumAscii(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += c;
        }
        return ans;
    }

    public static void main(String[] args) {
        String word1 = "delete", word2 = "leet";
        System.out.println(minimumDeleteSum(word1, word2));
    }
}
