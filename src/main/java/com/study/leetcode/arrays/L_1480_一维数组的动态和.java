package com.study.leetcode.arrays;

import com.study.common.util.CommonUtils;

/**
 * 1480. 一维数组的动态和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/15 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1480_一维数组的动态和 {

    static int[] preSum;

    public static int[] runningSum(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        System.arraycopy(preSum, 1, nums, 0, nums.length);
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        CommonUtils.printArray(runningSum(arr));
    }
}
