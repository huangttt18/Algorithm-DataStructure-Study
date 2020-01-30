package com.study.insertion;

import com.study.common.util.CommonUtils;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 *
 * @Author Created by Daniel
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void sort(long[] arr) {
        for (int i = 1; i < arr.length; i++) {
            long temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            // 此时j为temp元素需要插入索引
            arr[j] = temp;
        }
    }

    public static void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                CommonUtils.swap(arr, j, j - 1);
            }
        }
    }
}
