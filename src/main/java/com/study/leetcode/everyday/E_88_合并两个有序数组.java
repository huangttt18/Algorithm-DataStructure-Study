package com.study.leetcode.everyday;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/5 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_88_合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
    }
}
