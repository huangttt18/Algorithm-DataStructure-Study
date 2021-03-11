package com.study.algo4.utils;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Method;

/**
 * 排序算法模版类
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/23 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class SortTemplate {

    private static final double NANO_TO_SECOND = 1_000_000_000.0;

    /**
     * 比较 v 和 w的大小
     * @param v
     * @param w
     * @return 当v < w时返回true
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中两个元素的位置
     * @param a
     * @param i 索引位置1
     * @param j 索引位置2
     */
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 打印数组
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void measureSortCost(Object target, Method method, Object param) {
        try {
            long start = System.nanoTime();
            method.invoke(target, param);
            long timeDiff = System.nanoTime() - start;
            System.out.println("Cost: " + timeDiff / NANO_TO_SECOND + "s");
        } catch (Exception e) {
            e.printStackTrace();
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
    public static Long[] randomArray(int rangeLeft, int rangeRight, int arrayLength) {
        Long[] result = new Long[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = (long) (Math.random() * (rangeRight - rangeLeft) + rangeLeft);
        }

        return result;
    }

    public static Double[] randomArray(int arrayLength) {
        Double[] result = new Double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = Math.random();
        }

        return result;
    }
}
