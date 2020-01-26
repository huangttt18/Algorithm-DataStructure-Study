package com.study.practice.jan.jan26;

import java.util.Arrays;

/**
 * 高度检查器
 *
 * @author Daniel 2020/1/26
 */
public class LeetCode1051 {

    public static int heightChecker(int[] heights) {
        int step = 0;
        return step;
    }

    private static void swap(int[] arr, int minIndex, int maxIndex) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
//        swap(heights, 1, 2);
        Arrays.stream(heights).forEach(System.out::println);
        System.out.print("step: ");
        System.out.println(heightChecker(heights));
    }
}
