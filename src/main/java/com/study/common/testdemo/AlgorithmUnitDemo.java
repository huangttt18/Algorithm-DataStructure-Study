package com.study.common.testdemo;

import com.study.binarysearch.BinarySearch;
import com.study.common.util.CommonUtils;
import com.study.insertion.InsertionSort;
import com.study.merge.MergeSort;
import com.study.merge.MergeSort2;
import com.study.selection.SelectionSort;

import java.util.Arrays;

/**
 * 用于做算法测试的类
 * 在类中构建算法对应的内部类来进行算法测试
 * @author Created by Daniel
 */
public class AlgorithmUnitDemo {

    static class BinarySearchTestClass {
        public static void main(String[] args) {
            long[] array = CommonUtils.randomArray(10, 100, 20);
            CommonUtils.printArray(array);
            Arrays.sort(array);
            System.out.println(BinarySearch.search(array, 0, array.length, 10));
        }
    }

    static class SelectionSortTestClass {
        public static void main(String[] args) {
//            long[] array = CommonUtils.randomArray(10, 100, 10);
//            CommonUtils.printArray(array);
//            SelectionSort.sort(array);
//            CommonUtils.printArray(array);
            int[] array = CommonUtils.randomArrayInt(10, 100, 10);
            CommonUtils.printArray(array);
            SelectionSort.sort2(array);
            CommonUtils.printArray(array);
        }
    }

    static class InsertionSortTestClass {
        public static void main(String[] args) {
            long[] array = CommonUtils.randomArray(10, 100, 10);
            CommonUtils.printArray(array);
            InsertionSort.sort(array);
            CommonUtils.printArray(array);
        }
    }

    static class MergeSortTestClass {
        public static void main(String[] args) {
//            long[] array = CommonUtils.randomArray(10, 100, 10);
            int[] array = CommonUtils.randomArrayInt(10, 100, 10);
            CommonUtils.printArray(array);
            MergeSort2.mergeSort(array);
            CommonUtils.printArray(array);
        }
    }
}
