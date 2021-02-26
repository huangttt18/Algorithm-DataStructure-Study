package com.study.leetcode.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
public class LeetCode349 {

    /**
     * 时间：On^2
     * 空间：On
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    set.add(num1);
                    break;
                }
            }
        }

        int[] ans = new int[set.size()];
        int index = 0;

        for (Integer i : set) {
            ans[index++] = i;
        }

        return ans;
    }

    /**
     * 时间：On
     * 空间：n^2
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }

        int[] ans = new int[list.size()];
        int index = 0;

        for (Integer i : list) {
            ans[index++] = i;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersection = intersection2(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }
    }
}
