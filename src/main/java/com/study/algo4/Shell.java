package com.study.algo4;

/**
 * 希尔排序
 *
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Shell {

    public static void sort(Comparable[] a) {
        int length = a.length;
        int gap = 1;
        while (gap < length / 3)
            gap = 3 * gap + 1;

        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && SortTemplate.less(a[j], a[j - gap]); j -= gap) {
                    SortTemplate.exchange(a, j, j - gap);
                }
            }
            gap /= 3;
        }
    }

    public static void sort2(Comparable[] a) {
        int length = a.length;
        int gap = 1;
        while (gap < length / 3)
            gap = 3 * gap + 1;

        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                // 这里可以和插入排序同样进行优化，移动元素而不交换元素
                // 尽量减少元素的交换次数来提高算法的运行效率
                Comparable tmp = a[i];
                int j;
                for (j = i; j >= gap && SortTemplate.less(tmp, a[j - gap]); j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
            gap /= 3;
        }
    }

    public static void main(String[] args) {
        Double[] array = SortTemplate.randomArray(10000000);
        sort2(array);
//        SortTemplate.show(array);
        System.out.println(SortTemplate.isSorted(array));
    }
}
