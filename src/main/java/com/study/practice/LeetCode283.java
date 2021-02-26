package com.study.practice;

import java.util.Arrays;

/**
 * 移动零：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2020/11/17 </a>
 * @since <span>1.0</span>
 */
public class LeetCode283 {

    /**
     * 在原数组中操作
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }

    private static void swap(int[] source, int leftIndex, int rightIndex) {
        int temp = source[leftIndex];
        source[leftIndex] = source[rightIndex];
        source[rightIndex] = temp;
    }

    /**
     * 开辟了一个新的数组空间，将不等于0的元素全部放入新的数组中
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int[] moveZeroes2(int[] nums) {
        int[] copy = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                copy[index++] = nums[i];
            }
        }

        return copy;
    }

    /**
     * 双指针：将不为0的元素移动到前面，并且记录当前不为0的元素下标最大值，然后从最大值开始遍历到数组长度(不包括)，所有元素赋0即可
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 12};
//        moveZeroes(nums);
//        int[] result = moveZeroes2(nums);
        moveZeroes3(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
