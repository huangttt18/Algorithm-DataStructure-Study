package com.study.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/19 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_217_存在重复元素 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }
        return false;
    }

    /**
     * 排序后，找重复
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
