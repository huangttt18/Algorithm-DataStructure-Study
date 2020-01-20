package com.study.practice.jan20;

import java.util.Arrays;

/**
 * 和为零的N个唯一整数
 *
 * @author Daniel 2020/1/20
 */
public class LeetCode1304 {

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        result[0] = -sum;

        for (int i = 1; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    public static int[] sumZero2(int n) {
        int[] result = new int[n];
        if (n % 2 == 0) {
            result[n - 1] = 0;
        }

        // (n / 2) 整除 * 2取到n - 1的个数
        for (int i = 0; i < n / 2 * 2; i += 2) {
            result[i] = i + 1;
            result[i + 1] = -result[i];
        }

        return result;
    }

    public static void main(String[] args) {
//        Arrays.stream(sumZero(10)).forEach(System.out::println);
        Arrays.stream(sumZero2(11)).forEach(System.out::println);
    }
}
