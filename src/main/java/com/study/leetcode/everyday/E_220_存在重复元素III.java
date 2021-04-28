package com.study.leetcode.everyday;

import java.util.Set;
import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/17 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_220_存在重复元素III {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> sortedSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long u = nums[i] * 1L;
            Long l = sortedSet.floor(u);
            Long r = sortedSet.ceiling(u);
            if (l != null && u - l <= t)
                return true;
            if (r != null && r - u <= t)
                return true;
            sortedSet.add(u);
            if (i >= k)
                sortedSet.remove(nums[i - k] * 1L);
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> sortedSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long u = nums[i] * 1L;
            Long l = sortedSet.floor(u);
            Long r = sortedSet.ceiling(u);
            if (l != null && u - l <= t)
                return true;
            if (r != null && r - u <= t)
                return true;
            sortedSet.add(u);
            if (i >= k)
                sortedSet.remove(nums[i - k] * 1L);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
