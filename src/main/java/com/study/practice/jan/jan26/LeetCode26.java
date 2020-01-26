package com.study.practice.jan.jan26;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * 双指针法
 * @author Daniel 2020/1/26
 */
public class LeetCode26 {

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                // 当前元素不等于index位置元素时，表示当前元素与之前的元素都不重复
                // 将index+1位置的元素替换为当前元素
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::println);
    }
}
