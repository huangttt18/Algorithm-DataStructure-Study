package com.study.leetcode.bitcalc;

/**
 * 面试题 16.01. 交换数字
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/29 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 面试题16_01_交换数字 {

    public static int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }

    public static int[] swapNumbers2(int[] nums) {
        nums[0] ^= nums[1];
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        swapNumbers(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
