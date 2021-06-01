package com.study.leetcode.everyday;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/1</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1744_你能在你最喜欢的那天吃到你最喜欢的糖果吗 {

    /**
     * 从第0天开始吃糖果，每天至少吃一颗糖果，在吃完所有的第i - 1类糖果之前不能吃第i类糖果
     * [favType, favDay, dailyCap] => {
     *     favType = 需要吃到这一类糖果,
     *     favDay = 需要在这一天吃到favType类的糖果,
     *     dailyCap = 每天最多吃这么多糖果
     * }
     * favType 从 0 开始
     * favDay 从 0 开始， 因此最后一天是favDay + 1
     * 根据题意可知：{
     *     最早吃到favType类糖果的时间为： 以最快的速度(dailyCap)来吃糖果，吃到第favType类糖果的时间为(sum[favType - 1] / dailyCap) + 1
     *     最晚吃到favType类糖果的时间为： 以最慢的速度(1)来吃糖果，吃到第favType类糖果的时间为sum[favType]
     *     sum[favType]：表示[0...favType)之间共有多少糖果
     * }
     * 因此如果实际消耗时间 >= 最早时间 && 实际消耗时间 <= 最晚时间，那么返回true
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int cs = candiesCount.length;
        int qs = queries.length;
        long[] sum = new long[cs + 1];

        for (int i = 1; i <= cs; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }

        boolean[] ans = new boolean[qs];
        for (int i = 0; i < qs; i++) {
            int favType = queries[i][0];
            int favDay = queries[i][1] + 1;
            int dailyCap = queries[i][2];

            long fastest = sum[favType] / dailyCap + 1;
            long slowest = sum[favType + 1];
            ans[i] = fastest <= favDay && favDay <= slowest;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
