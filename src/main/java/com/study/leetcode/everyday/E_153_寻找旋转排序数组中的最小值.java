package com.study.leetcode.everyday;

import java.util.Arrays;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/8 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_153_寻找旋转排序数组中的最小值 {

    public static int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public static int findMin2(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }

    /**
     * 比较nums[0]和nums[n...0)
     * 每次比较
     *      如果nums[0] > nums[n]，那么将nums[0]修改为nums[n]，n--，继续比较前一个元素
     *      当nums[0] < nums[n]时，此时表示将nums[n + 1]再一次移动到数组头部时，数组已经有序，那么返回当前的nums[0]即可
     * @param nums
     * @return
     */
    public static int findMin3(int[] nums) {
        int n0 = nums[0];
        int rightIndex = nums.length - 1;
        int nLen = nums[rightIndex];
        if (n0 < nLen) {
            return n0;
        }
        while (n0 > nLen && rightIndex > 0) {
            n0 = nLen;
            nLen = nums[--rightIndex];
        }

        return n0;
    }

    /**
     * 二分查找：[4, 5, 6, 7, 0, 1, 2]
     *      l = 0, r = 6, mid = 3
     *      nums[mid] > nums[r] => 原数组升序 => 最小值在右边 => l = mid + 1 = 4
     *      l = 4, r = 6, mid = 5
     *      nums[mid] < nums[r] => 原数组升序 => 最小值在左边 => r = mid = 5
     *      l = 4, r = 5, mid = 4
     *      nums[mid] < nums[r] => 原数组升序 => 最小值在左边 => r = mid = 4
     *      l == r => 循环结束，最小值为nums[mid]，nums[r]，nums[l]
     * @param nums
     * @return
     */
    public static int findMin4(int[] nums) {
        int left = 0;
        int right = nums.length - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
        while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
            int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
            if (nums[mid] > nums[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */
                left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else if (nums[mid] < nums[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {11,13,15,17};
//        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin4(nums));
    }
}
