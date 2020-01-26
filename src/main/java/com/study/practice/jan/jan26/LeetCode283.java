package com.study.practice.jan.jan26;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author Daniel 2020/1/26
 */
public class LeetCode283 {

    public static void moveZeroes(int[] nums) {
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

    public static void moveZeroes2(int[] nums) {
        int[] tempArr = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tempArr[index++] = nums[i];
            }
        }

        for (int i = 0; i < tempArr.length; i++) {
            nums[i] = tempArr[i];
        }
    }

    public static void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }

    public static void moveZeroes4(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 如果整个数组全是0，那么每次都会
                if (i != index) {
                    swap(nums, index++, i);
                } else {
                    index++;
                }
            }
        }
    }

    private static void swap(int[] arr, int leftIndex, int rightIndex) {
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes3(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
