package com.study.leetcode.sort;

/**
 * 832. 翻转图像
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
public class LeetCode832 {

    /**
     * [
     *      [1,1,0],
     *      [1,0,1],
     *      [0,0,0]
     * ]
     * 时间复杂度：On^2
     * 空间复杂度：O1
     */
    public static int[][] flipAndInvertImage(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = reverseArray(a[i]);
        }

        return flipArray(a);
    }

    public static int[] reverseArray(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            swap(a, lo, hi);
            lo++;
            hi--;
        }

        return a;
    }

    public static int[][] flipArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    a[i][j] = 1;
                } else if (a[i][j] == 1) {
                    a[i][j] = 0;
                }
            }
        }

        return a;
    }

    public static void swap(int[] a, int lo, int hi) {
        int tmp = a[lo];
        a[lo] = a[hi];
        a[hi] = tmp;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        flipAndInvertImage(a);
        System.out.println();
    }
}
