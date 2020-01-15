package com.study.practice.jan15;

import java.util.Arrays;

/**
 * 统计[位数]为偶数的数字
 *
 * @author Daniel 2020/1/15
 */
public class LeetCode1295 {

    public static int findNumbers(int[] nums) {
        // 0000 0000 0000 0000 0000 0000 0000 0000
        long start = System.nanoTime();
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        System.out.println("Cost: " + (System.nanoTime() - start));
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1111, 231234112, 123123, 1};
        System.out.println(findNumbers(nums));
    }
}
