package com.study.algo4;

import java.lang.reflect.Method;

/**
 * 三路快速排序
 * <p>
 * 将原数组分为3个部分，分别是[小于选定元素的数组 lo...lt]、[等于选定元素的数组 i]、[大于选定元素的数组 gt...hi]
 * <p>
 * 适用场景：如果数组中重复元素过多，则使用三路快排的效率会更高
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/26 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Quick3Way {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        // 选定元素v
        Comparable v = a[lo];
        // < lt的元素被认为是小于被选定元素v的
        int lt = lo;
        // [lt...gt]之间的元素被认为是等于选定元素v的
        int i = lo + 1;
        // > gt的元素被认为是大于被选定元素v的
        int gt = hi;
        // 因此我们的循环条件为 i <= gt
        // 即如果i超过了gt，因为gt之后的元素都是大于v的，所以表示这一轮排序已经完成
        while (i <= gt) {
            if (a[i].compareTo(v) < 0)
                // 此时a[i] < v
                // 交换a[i]和v
                // lt指针++；i指针++
                SortTemplate.exchange(a, i++, lt++);
            else if (a[i].compareTo(v) > 0)
                // 此时a[i] > v
                // 交换a[gt]和a[i]
                // gt指针--
                SortTemplate.exchange(a, i, gt--);
            else
                // 此时a[i] == v
                // i指针++即可
                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) throws Exception {
        Double[] array = SortTemplate.randomArray(1000000);
        Method sortMethod = Quick3Way.class.getDeclaredMethod("sort", Comparable[].class);
        SortTemplate.measureSortCost(Quick3Way.class.newInstance(), sortMethod, array);
//        SortTemplate.show(array);
        System.out.println(SortTemplate.isSorted(array));
    }
}
