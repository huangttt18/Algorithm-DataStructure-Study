package com.study.merge;

import com.study.insertion.InsertionSort;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 *
 * @Author Created by Daniel
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void sort(long[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 对[start,end]进行排序，闭区间
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void sort(long[] arr, int start, int end) {
        // 当start >= end时，表示当前数组已经为空不需要排序了
//        if (start >= end) {
//            return;
//        }
        // 当数组的数据量较小时，直接调用插入排序，速度更快
        if (end - start <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        // 因为两个数组都是有序的，所以，只有当左边数组最大的数比右边数组最小的数大的时候才进行归并操作
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, start, mid, end);
        }
    }

    /**
     * 对排序后的数组进行归并[start,mid]-[mid + 1,end]
     *
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(long[] arr, int start, int mid, int end) {
        long[] aux = new long[end - start + 1];
        for (int i = start; i <= end; i++) {
            aux[i - start] = arr[i];
        }

        // 开始比较两个数组的各个元素的大小并复制到新的数组中
        // 1 2 4 6 | 3 5 7 8
        // 从两个数组的首元素开始比较，小的元素先放入新数组，然后将相应的索引值+1，再继续比较
        int i = start;
        int j = mid + 1;
        // k 为dest数组的索引
        for (int k = start; k <= end; k++) {
            // 如果i越界，则新数组的剩下的元素全部为第二个数组的元素
            if (i > mid) {
                arr[k] = aux[j - start];
                j++;
            } else if (j > end) {
                // 如果j越界，则新数组的剩下的元素全部为第一个数组的元素
                arr[k] = aux[i - start];
                i++;
            } else if (aux[i - start] < aux[j - start]) {
                arr[k] = aux[i - start];
                i++;
            } else {
                arr[k] = aux[j - start];
                j++;
            }
        }
    }
}
