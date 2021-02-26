package com.study.algo4;

/**
 * 归并排序：自顶向下
 * 时间：Onlgn
 * 空间：On
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Merge {

    // 辅助数组，用于归并逻辑
    public static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        // OPTMIZE: 对于小规模的数组，使用插入排序的效率会更高
        if (a.length <= 15) {
            Insertion.sort(a);
            return;
        }

        if (lo >= hi)
            // 此时表示所有的子数组已经排序好了，直接返回即可
            return;

        // 获取mid位置
        int mid = lo + (hi - lo) / 2;
        // 对[lo ... mid]区间的数组进行排序，即对数组的左半部分进行排序
        sort(a, lo, mid);
        // 对[mid + 1, hi]区间的数组进行排序，即对数组的右半部分进行排序
        sort(a, mid + 1, hi);
        // OPTMIZE: 如果mid所在元素小于mid+1所在元素，那么我们认为此时数组已经是有序的了，就不需要执行merge
        if (SortTemplate.less(a[mid], a[mid + 1])) {
            return;
        }
        // 排序完成之后将左右两部分归并
        merge(a, lo, mid, hi);
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
        Long[] array = SortTemplate.randomArray(0, 20, 10000000);
//        SortTemplate.show(array);
        sort(array);
//        SortTemplate.show(array);
        System.out.println(SortTemplate.isSorted(array));
    }
}
