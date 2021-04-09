package com.study.leetcode.everyday;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/9 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_154_寻找旋转排序数组中的最小值II {

    /**
     * {3, 3, 1, 3}
     * l = 0, r = 3, mid = 1
     * nums[mid] = 3, nums[right] = 3
     * nums[mid] == nums[right] => 此时表示原数组在当前元素之后所有的元素都被旋转了
     *      => 又因为数组是升序的，所以此时nums[0...mid] >= nums[right]
     *      => 因此最小值应该位于[left...right -1]
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
        while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
            int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
            if (nums[mid] > nums[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */
                left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else if (nums[mid] < nums[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
            } else {
                // 此时nums[mid...right] == nums[right]
                right = right - 1;
            }
        }
        return nums[left];
    }

    public static int findMin2(int[] nums) {
        int n0 = nums[0];
        int rightIndex = nums.length - 1;
        int nLen = nums[rightIndex];
        if (n0 < nLen) {
            return n0;
        }
        while (n0 >= nLen && rightIndex > 0) {
            n0 = nLen;
            nLen = nums[--rightIndex];
        }

        return n0;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5};
//        int[] nums = {3};
        int[] nums = {1, 3, 3};
//        int[] nums = {3, 3, 1, 3};
//        int[] nums = {3, 3, 3, 3};
//        int[] nums = {4, 5, 6, 7, 0, 1, 4};
//        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(findMin(nums));
    }
}
