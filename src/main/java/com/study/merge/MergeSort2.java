package com.study.merge;

import com.study.insertion.InsertionSort;

import java.util.Arrays;

/**
 * @author Daniel 2020/1/31
 */
public class MergeSort2 {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        // 如果left >= right表示当前数组为空或只有一个元素
        if (left >= right) {
            return;
        }
        if (left - right <= 15) {
            InsertionSort.sort2(arr);
            return;
        }

        // 取中间数
        int mid = left + (right - left) / 2;
        // 分别排序左右两部分数组
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // 进行归并
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] < aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }
}
