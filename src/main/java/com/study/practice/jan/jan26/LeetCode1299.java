package com.study.practice.jan.jan26;

import java.util.Arrays;

/**
 * 将每个元素替换为右侧最大元素
 *
 * @author Daniel 2020/1/26
 */
public class LeetCode1299 {

    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
                break;
            }
            int j = i + 1;
            int max = arr[j];
            for (; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }

        return arr;
    }

    public static int[] replaceElements2(int[] arr) {
        int[] result = new int[arr.length];
        int max = arr[arr.length - 1];
        result[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            result[i] = max;
            max = Math.max(max, arr[i]);
        }

        return result;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 10, 2, 6, 3};
        int[] res = replaceElements(arr);
        Arrays.stream(res).forEach(System.out::println);
    }
}
