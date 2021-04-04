package com.study.leetcode.dp;

/**
 * 343. 整数拆分
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/3 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_343_整数拆分 {

    static int[] memos;

    public static int integerBreak(int n) {
        memos = new int[n + 1];
        return memo(n);
    }

    /**
     * 记忆化搜索：在递归的过程中，许多子问题被重复计算了
     *          因此可以将这些重复的子问题存储起来
     *          后续如果碰到重复的子问题可以直接从内存中获取而不必重新计算
     *
     * memo(n): 对于正整数n，拆分后的最大乘积
     * 如果要求n的最大乘积，那么
     *      需要求n - 1拆分后的最大乘积，然后乘以1，
     *      需要求n - 2拆分后的最大乘积，然后乘以2，
     *      ...
     *      需要求n - i拆分后的最大乘积，然后乘以i
     * 最后，综合这些乘积计算出n拆分后的最大乘积
     * @param n
     * @return
     */
    private static int memo(int n) {
        // 当n == 1，该数只有一种拆分方式，就是拆成1
        if (n == 1)
            return 1;

        if (memos[n] != 0)
            return memos[n];

        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret = Math.max(ret, Math.max(i * (n - i), i * memo(n - i)));
        }
        memos[n] = ret;
        return ret;
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求dp[i]
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
        System.out.println(integerBreak2(10));
    }
}
