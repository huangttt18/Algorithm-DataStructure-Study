package com.study.selection;

import com.study.common.util.CommonUtils;

/**
 * 选择排序
 * 时间复杂度:   O(n^2)
 * @Author Created by Daniel
 */
public class SelectionSort {

    /**
     * 从小到大排序
     * @param arr
     */
    public static void sort(long[] arr) {
        for (int i = 0;i < arr.length;i ++) {
            int min = i;
            for (int j = i + 1;j < arr.length;j ++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                CommonUtils.swap(arr, min, i);
            }
        }
    }
}
