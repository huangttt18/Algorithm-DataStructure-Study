package com.study.leetcode.dp;

import java.util.Arrays;

/**
 * 钢条切割
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class N_钢条切割 {

    public static int cut(int[] p, int n) {
        if (n == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, p[i - 1] + cut(p, n - i));
        }

        return max;
    }

    static int[] memo;

    public static int cut2(int[] p, int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        return c(p, n);
    }

    private static int c(int[] p, int n) {
        if (memo[n] != -1)
            return memo[n];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, p[i - 1] + c(p, n - i));
        }
        memo[n] = max;
        return memo[n];
    }

    public static int cut3(int[] p, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, p[j - 1] + dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 35, 40, 42, 42, 47, 50, 52, 52, 52, 60};
        int n = 20;
        long start = System.nanoTime();
        int r = cut(p, n);
        System.out.println("r = " + r);
        System.out.println("Cost1: " + (System.nanoTime() - start));
        start = System.nanoTime();
        r = cut2(p, n);
        System.out.println("r = " + r);
        System.out.println("Cost2: " + (System.nanoTime() - start));
        start = System.nanoTime();
        r = cut3(p, n);
        System.out.println("r = " + r);
        System.out.println("Cost3: " + (System.nanoTime() - start));
    }
}
