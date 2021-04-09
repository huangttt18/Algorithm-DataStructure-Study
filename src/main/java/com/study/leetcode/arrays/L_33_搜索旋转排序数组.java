package com.study.leetcode.arrays;

/**
 * 33. 搜索旋转排序数组
 * nums = [4,5,6,7,0,1,2]
 * target = 0
 * 题目要求最好能用<b>O(logn)</b>的时间复杂度，因此很容易就想到使用binarySearch
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/7 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_33_搜索旋转排序数组 {

    /**
     * 输入数组是由一个有序数组在某个位置k旋转而来，因此具有特性：
     * [0...k - 1]是升序数组
     * [k...n]是升序数组
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            // 右边有序
            if (nums[mid] < nums[high]) {
                // 目标值在右边
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                    // 目标值在左边
                } else {
                    high = mid - 1;
                }
                // 左边有序
            } else {
                // 目标值在左边
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                    // 目标值在右边
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
