package com.study.leetcode.dp;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/5 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_354_俄罗斯套娃信封问题 {

    public static int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        Arrays.sort(envelopes, (a , b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int[] height = new int[length];
        for (int i = 0; i < length; i++)
            height[i] = envelopes[i][1];
        // LIS
        int[] top = new int[length];
        int piles = 0;
        for (int i = 0; i < length; i++) {
            int poker = height[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles)
                piles++;
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args) {

    }
}
