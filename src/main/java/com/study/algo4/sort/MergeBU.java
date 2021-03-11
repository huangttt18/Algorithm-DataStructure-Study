package com.study.algo4.sort;

import com.study.algo4.utils.SortTemplate;

/**
 * 归并排序：自底向上
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class MergeBU {

    // 辅助数组，用于归并逻辑
    public static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        // size = 子数组大小
        for (int size = 1; size < n; size *= 2) {
            for (int i = 0; i < n - size; i += 2 * size) {
                // 归并[i...i + size - 1]和[i + size...min(i + 2 * size - 1, n - 1))两个子数组
                // 比如当size = 1，那么此时要归并的子数组为[0, 0]和[1, 1]
                // merge(a, 0, 0, 1)
                // 当size = 2，那么此时要归并的子数组为[0, 1]和[2, 3]
                // merge(a, 0, 1, 3)
                merge(a, i, i + size - 1, Math.min(i + 2 * size - 1, n - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将原数组中的元素都存入aux数组中
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int k = lo;
        int m = mid + 1;

        // 遍历aux数组，比较两个子数组的元素大小并存入原数组
        for (int i = lo; i <= hi; i++) {
            if (k > mid)
                // 当k大于mid时，表示左半边数组已经归并完成，此时只需要将右半边的元素填充过来即可
                a[i] = aux[m++];
            else if (m > hi)
                // 当m大于hi时，表示右半边数组已经归并完成，此时只需要将左半边的元素填充过来即可
                a[i] = aux[k++];
            else if (SortTemplate.less(aux[k], aux[m]))
                // 比较左半边数组元素和右半边数组元素的大小，将小的存入原数组
                a[i] = aux[k++];
            else
                // 如果右半边数组元素小于左半边数组元素，将右半边数组元素存入到原数组
                a[i] = aux[m++];
        }
    }

    public static void main(String[] args) {
        Long[] array = SortTemplate.randomArray(0, 200, 1000);
//        SortTemplate.show(array);
        sort(array);
//        SortTemplate.show(array);
        System.out.println(SortTemplate.isSorted(array));
    }

}
