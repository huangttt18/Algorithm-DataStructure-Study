package com.study.practice.jan.jan26;

import java.util.Arrays;

/**
 * 移除元素
 * 双指针法
 *
 * @author Daniel 2020/1/26
 */
public class LeetCode27 {

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // 当前元素不等于指定元素val时
                // 将当前元素放到index位置
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
//        System.out.println();
        removeElement(nums, val);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
