package com.study.quick;

import com.study.common.util.CommonUtils;

/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 * @Author Created by Daniel
 */
public class QuickSort {

    /**
     * 快速排序
     * @param arr
     */
    public static void sort(long[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序的子排序
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static void sort(long[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // p为选定的值的索引
        int p = partition(arr, start, end);
        sort(arr, start, p - 1);
        sort(arr, p + 1, start);
    }

    private static int partition(long[] arr, int start, int end) {
        // 选定一个元素，将剩下的元素与该元素进行比较，将该元素放到正确的位置，然后再对两边的数组进行快排
        long chosen = arr[start];
        int j = start;
        for (int i = start + 1;i <= end;i ++) {
            if (arr[i] < chosen) {
                CommonUtils.swap(arr, i, ++ j);
            }
        }
        CommonUtils.swap(arr, start, j);
        return j;
    }
}
