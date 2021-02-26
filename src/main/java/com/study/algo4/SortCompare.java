package com.study.algo4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 排序算法执行效率比较
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equalsIgnoreCase("Insertion"))
            Insertion.sort(a);
        if (alg.equalsIgnoreCase("Selection"))
            Selection.sort(a);
        if (alg.equalsIgnoreCase("Shell"))
            Shell.sort2(a);
        if (alg.equalsIgnoreCase("Merge"))
            Merge.sort(a);
        if (alg.equalsIgnoreCase("MergeBU"))
            MergeBU.sort(a);
        if (alg.equalsIgnoreCase("Quick"))
            Quick.sort(a);
        if (alg.equalsIgnoreCase("Quick3Way"))
            Quick3Way.sort(a);
        return timer.elapsedTime();
    }

    /**
     * 生成t个长度为n的Double数组并对其按照指定的算法执行排序
     *
     * @param alg
     * @param n
     * @param t
     * @return
     */
    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a;
        for (int i = 0; i < t; i++) {
            a = (Double[]) SortTemplate.randomArray(n);
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int t = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        StdOut.printf("For %d random Doubles\n  %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s", t2 / t1, alg2);
    }
}
