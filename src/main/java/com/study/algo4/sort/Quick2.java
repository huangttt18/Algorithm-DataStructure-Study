package com.study.algo4.sort;

import com.study.algo4.utils.SortTemplate;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 快速排序2
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/31</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Quick2 {

    public static final int LENGTH = (int) 1e6 + 10;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        Comparable v = a[l];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (SortTemplate.less(a[i], v));

            do {
                j--;
            } while (SortTemplate.less(v, a[j]));

            if (i < j) {
                SortTemplate.exchange(a, i, j);
            }
        }

        sort(a, l, j);
        sort(a, j + 1, r);
    }

    public static void main(String[] args) throws Exception {
//        Double[] array = SortTemplate.randomArray(10);
//        Method sortMethod = Quick2.class.getDeclaredMethod("sort", Comparable[].class);
//        SortTemplate.measureSortCost(Quick2.class.newInstance(), sortMethod, array);
//        SortTemplate.show(array);
//        System.out.println(SortTemplate.isSorted(array));
        int[] arr = new int[LENGTH];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(" 1 2 3 4 5 ".split(" ")).forEach(System.out::println);
//        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(v -> {
//            if (!v.equals(" ")) {
//                return Integer.parseInt(v);
//            }
//        }).toArray();
        br.close();
    }
}
