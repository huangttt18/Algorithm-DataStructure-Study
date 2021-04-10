package com.study.leetcode.everyday;

/**
 * 264. 丑数 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/10 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_264_丑数_II {

    /**
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 对于第n个丑数来说，需要通过n - 1...0来求出，min(ugly[n - 1] * 2 * 3 * 5...ugly[0] * 2 * 3 * 5) && ugly[n] > ugly[n - 1]
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            // 如果dp[i] == 任意一个数
            // 则表示当前num所在的位置i是下一个丑数
            // 该丑数是由p2 * 2 或 p3 * 3 或 p5 * 5计算而来
            if (dp[i] == num2)
                p2++;
            if (dp[i] == num3)
                p3++;
            if (dp[i] == num5)
                p5++;
        }

        return dp[n];
    }

    private static boolean isUgly(int n) {
        if (n <= 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1300));
    }
}
