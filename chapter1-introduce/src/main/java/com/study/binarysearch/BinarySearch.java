package com.study.binarysearch;

import com.study.util.CommonUtils;

/**
 * 二分查找
 * 时间复杂度：O(log(n))
 * @Author Created by Daniel
 */
public class BinarySearch {

    private BinarySearch() { }

    /**
     * 在[low,high]之间查找
     * @param arr
     */
    public static int search(long[] arr, int startIndex, int endIndex, int target) {
        // 判断数组是否有序（从小到大），无序则直接返回 -1
        if (!CommonUtils.isSorted(arr, true)) {
            return -1;
        }
        int low = startIndex;
        int high = endIndex - 1;

        while (low <= high) {
            // 保证low + high不会越界
            int mid = low + ((high - low) >>> 1);

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            }

            if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        // 没有查找到
        return -1;
    }
}
