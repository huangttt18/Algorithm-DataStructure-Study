package com.study.algo4;

/**
 * 选择排序
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/23 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Selection {

    public static void main(String[] args) throws Exception {
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            // 找出最小元素
            int min = i;
            for (int j = 1; j < a.length; j++) {
                // 升序排序
                if (SortTemplate.less(a[i], a[j]))
                    min = j;
            }
            if (min != i)
                SortTemplate.exchange(a, i, min);
        }
    }
}
