package com.study.leetcode.sort;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/17 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1502_判断能否形成等差数列 {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
