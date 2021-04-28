package com.study.leetcode.binarysearch;

/**
 * 35. 搜索插入位置
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/26 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_35_搜索插入位置 {

    /**
     * {1,3,5,6},0
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
