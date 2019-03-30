package com.study.practice.firstday;

/**
 * @Author Created by Daniel
 */
public class LeetCode704 {

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
    }

    public static int search(int[] nums, int target) {
        // 数组为空，不存在target，返回-1
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // 为了防止int型数据相加溢出
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
