package com.study.recursion;

/**
 * @Author Created by Daniel
 */
public class RecursionDemo {

    public static void main(String[] args) {

        int[] arr = new int[1000];
        for (int i = 0;i < arr.length;i ++) {
            arr[i] = i + 1;
        }
        System.out.println(sum(arr));
        long startTime = System.nanoTime();
        sum1();
        long endTime = System.currentTimeMillis();
        System.out.println("Cost: " + (endTime - startTime));
        System.out.println(sum1());
    }

    public static void sum() {
        int i = 0;
        int sum = 0;
        long startTime = System.nanoTime();
        while (i++ < 1000) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Cost: " + (endTime - startTime));
    }

    public static int sum1() {
        int l = 0;
        int r = 1000;
        int multi = (l + (r - l)) / 2;
        return multi * (l + r) + multi;
    }

    public static int sum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return (arr[0] + sum(arr, 1, arr.length - 1));
    }

    private static int sum(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return arr[endIndex];
        }

        return arr[startIndex] + sum(arr, startIndex + 1, endIndex);
    }
}
