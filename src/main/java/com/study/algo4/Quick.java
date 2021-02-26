package com.study.algo4;

import java.lang.reflect.Method;

/**
 * 快速排序
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/26 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Quick {

    private static final int INSERTION_THRESHOLD = 15;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo + INSERTION_THRESHOLD >= hi) {
            // 当数组元素足够小时，可以使用插入排序来提高排序效率
            // 因为对于小数组来说，插入排序的效率是非常高的，快速排序还需要进行递归调用等操作
            Insertion.sort(a, lo, hi);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 对[lo...hi]执行分区操作
     *
     * @param a
     * @param lo
     * @param hi
     * @return 返回当前指定元素的位置
     */
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            // 找到第一个大于v的元素
            while (SortTemplate.less(a[++i], v))
                if (i == hi)
                    break;
            // 循环结束后，a[i] > v
            // 找到第一个小于v的元素
            while (SortTemplate.less(v, a[--j]))
                if (j == lo)
                    break;
            // 循环结束后，a[j] < v
            // 如果 i == j表示当前数组已经遍历完成了
            if (i >= j)
                break;
            // 此时交换a[j] 和 a[i]
            SortTemplate.exchange(a, i, j);
        }

        SortTemplate.exchange(a, j, lo);
        return j;
    }

    public static void main(String[] args) throws Exception {
        Double[] array = SortTemplate.randomArray(10000000);
        Method sortMethod = Quick.class.getDeclaredMethod("sort", Comparable[].class);
        SortTemplate.measureSortCost(Quick.class.newInstance(), sortMethod, array);
//        SortTemplate.show(array);
        System.out.println(SortTemplate.isSorted(array));
    }
}
