package com.study.practice.jan.jan27;

/**
 * 删除排序数组中的重复项 II
 * 双指针法
 *
 * @author Daniel 2020/1/27
 */
public class LeetCode80 {

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                if (count != 2) {
                    nums[++index] = nums[i];
                    count++;
                }
            } else if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
                count = 1;
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5};
        System.out.println(removeDuplicates(nums));
    }
}
