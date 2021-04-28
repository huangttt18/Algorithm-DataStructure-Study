package com.study.leetcode.everyday;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/26 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1011_在D天内送达包裹的能力 {

    public static int shipWithinDays(int[] weights, int D) {
        int left = max(weights), right = sum(weights);
        while (left < right) {
            int mid = (right + left) >>> 1;
            int cost = 1;
            int total = 0;
            for (int weight : weights) {
                total += weight;
                if (total > mid) {
                    cost++;
                    total = weight;
                }
            }

            if (cost <= D)
                // cost < D，表示当前运载量下不需要D天就能把货运完
                // 即当前运载量过大，那么缩减右边界
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private static int max(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            if (weight > max)
                max = weight;
        }
        return max;
    }

    private static int sum(int[] weights) {
        int sum = 0;
        for (int weight : weights)
            sum += weight;
        return sum;
    }

    public static void main(String[] args) {

    }
}
