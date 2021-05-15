package com.study.leetcode.dp;

/**
 * 583. 两个字符串的删除操作
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/6 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_583_两个字符串的删除操作 {

    /**
     * word1: sea
     * word2: eat
     * 如果ch1 != ch2，移除
     * 如果ch1 == ch2，继续
     * dp[i][j]：word1的i和Word2的j位置的最长公共子序列的长度
     */
    public static int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return m + n - 2 * dp[m][n];
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
        String word1 = "sea", word2 = "eat";
//        String word1 = "print", word2 = "printf";
        System.out.println(minDistance(word1, word2));
//        minDistance(word1, word2);
    }
}
