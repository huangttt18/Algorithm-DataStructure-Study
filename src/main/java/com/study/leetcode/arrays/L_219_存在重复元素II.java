package com.study.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/19 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_219_存在重复元素II {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * set存储不重复的数字
     * 如果当前考察的数字已经存在于set中，那么返回true
     * 如果当前考察的数字不存在于set中，那么将当前数字添加到set中并检查set的size是否小于等于k
     *      如果不是，则将位于set最前面的也就是数组的第[i - k]个元素从set中移除
     * 遍历如果结束，返回false
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            // 保证i - j <= k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1,2,3};
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
