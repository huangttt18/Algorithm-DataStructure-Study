package com.study.common.util;

import java.lang.reflect.Method;

/**
 * 算法工具类
 *
 * @Author Created by Daniel
 */
public class CommonUtils {

    /**
     * 检测数组是否有序
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(long[] arr, boolean increment) {
        if (increment) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] < arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 动态生成[rangeLeft,rangeRight]，长度为arrayLength的数组
     *
     * @param rangeLeft
     * @param rangeRight
     * @param arrayLength
     * @return 生成好的数组
     */
    public static long[] randomArray(int rangeLeft, int rangeRight, int arrayLength) {
        long[] result = new long[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = (long) (Math.random() * (rangeRight - rangeLeft) + rangeLeft);
        }

        return result;
    }

    public static int[] randomArrayInt(int rangeLeft, int rangeRight, int arrayLength) {
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = (int) (Math.random() * (rangeRight - rangeLeft) + rangeLeft);
        }

        return result;
    }

    /**
     * 遍历输出数组
     *
     * @param arr
     */
    public static void printArray(long[] arr) {
        if (arr.length > 100) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n\t");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append("，");
            }
            if ((i + 1) % 10 == 0) {
                if (i == (arr.length - 1)) {
                    sb.append("\n");
                } else {
                    sb.append("\n\t");
                }
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void printArray(int[] arr) {
        if (arr.length > 100) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append("，");
            }
            if ((i + 1) % 10 == 0) {
                if (i == (arr.length - 1)) {
                    sb.append("\n");
                } else {
                    sb.append("\n\t");
                }
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 交换数组中的元素
     *
     * @param arr
     * @param indexSmall
     * @param indexLarge
     */
    public static void swap(long[] arr, int indexSmall, int indexLarge) {
        long temp = arr[indexSmall];
        arr[indexSmall] = arr[indexLarge];
        arr[indexLarge] = temp;
    }

    public static void swap(int[] arr, int indexSmall, int indexLarge) {
        int temp = arr[indexSmall];
        arr[indexSmall] = arr[indexLarge];
        arr[indexLarge] = temp;
    }

    public static void measureCost(Object target, Method method, Object params) {
        try {
            long start = System.nanoTime();
            method.invoke(target, params);
            System.out.println("Cost: " + (System.nanoTime() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CommonUtils commonUtils = new CommonUtils();
        Method test = commonUtils.getClass().getDeclaredMethod("test");
//        CommonUtils.measureCost(commonUtils, test);
    }

    public void test() throws Exception {
        Thread.sleep(1000);
    }
}
