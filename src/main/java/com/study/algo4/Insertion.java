package com.study.algo4;

/**
 * 插入排序
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/23 </a>
 * @see "./insertion.txt"
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Insertion {

    public static void main(String[] args) throws Exception {
    }

    public static void _sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && SortTemplate.less(a[j], a[j - 1]); j--) {
                // 升序排序
                SortTemplate.exchange(a, j, j - 1);
            }
        }
    }

    /**
     * 通过减少元素的交换次数来提高算法的运行效率
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            // 记录cur元素
            Comparable cur = a[i];
            int j;
            for (j = i; j > 0 && SortTemplate.less(cur, a[j - 1]); j--) {
                // 如果当前元素大于cur，那么将当前元素往后移动一位
                // 这样可以不必每次都交换元素，提高排序的效率
                a[j] = a[j - 1];
            }
            a[j] = cur;
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            // 记录cur元素
            Comparable cur = a[i];
            int j;
            for (j = i; j > 0 && SortTemplate.less(cur, a[j - 1]); j--) {
                // 如果当前元素大于cur，那么将当前元素往后移动一位
                // 这样可以不必每次都交换元素，提高排序的效率
                a[j] = a[j - 1];
            }
            a[j] = cur;
        }
    }
}
