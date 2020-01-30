package com.study.bubble;

import com.study.common.util.CommonUtils;

/**
 * @author Daniel 2020/1/28
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    CommonUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = CommonUtils.randomArrayInt(10, 100, 10);
        CommonUtils.printArray(array);
        sort(array);
        CommonUtils.printArray(array);
    }
}
