package com.study.practice.jan.jan27;

import java.util.Arrays;

/**
 * 颜色分类
 * 三路快排
 * 也可以使用计数排序
 *
 * @author Daniel 2020/1/27
 */
public class LeetCode75 {

    /**
     * 因为只有3个元素，所以我们可以使用三路快排的思想来解决
     * 3路分别为0....1....2
     * 定义两个辅助索引,zero -> 0元素的边界[0 ... zero] , two -> 2元素的边界[two ... n - 1]
     * 1元素[zero + 1 ... two - 1]
     * 遍历数组
     * 当nums[i] == 0时，swap(i, ++zero)
     * 当nums[i] == 1时, i++
     * 当nums[i] == 2时, swap(i++, --two)
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else if (nums[i] == 0) {
                swap(nums, i++, ++zero);
            }
        }
    }

    private static void swap(int[] arr, int leftIndex, int rightIndex) {
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
