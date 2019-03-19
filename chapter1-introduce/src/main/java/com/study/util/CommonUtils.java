package com.study.util;

import java.util.Random;

/**
 * 算法工具类
 * @Author Created by Daniel
 */
public class CommonUtils {

    /**
     * 检测数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(long[] arr, boolean increment) {
        if (increment) {
            for (int i = 1;i < arr.length;i ++) {
                if (arr[i - 1] > arr[i]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 1;i < arr.length;i ++) {
                if (arr[i - 1] < arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 动态生成[rangeLeft,rangeRight]，长度为arrayLength的数组
     * @param rangeLeft
     * @param rangeRight
     * @param arrayLength
     * @return  生成好的数组
     */
    public static long[] randomArray(int rangeLeft, int rangeRight, int arrayLength) {
        long[] result = new long[arrayLength];
        for (int i = 0;i < arrayLength;i ++) {
            result[i] = (long) (Math.random() * (rangeRight - rangeLeft) + rangeLeft);
        }

        return result;
    }

    /**
     * 遍历输出数组
     * @param arr
     */
    public static void printArray(long[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n\t");
        for (int i = 0;i < arr.length;i ++) {
            sb.append("(");
            sb.append(i);
            sb.append(",");
            sb.append(arr[i]);
            if (i == arr.length - 1) {
                sb.append(")");
            } else {
                sb.append("),");
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
}
