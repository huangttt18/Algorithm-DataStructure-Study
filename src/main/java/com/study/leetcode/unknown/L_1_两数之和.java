package com.study.leetcode.unknown;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/31 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1_两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> help = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (help.containsKey(target - nums[i])) {
                return new int[] {help.get(target - nums[i]), i};
            }
            help.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        for (int an : ans) {
            System.out.print(an);
            System.out.println(" ");
        }
    }
}
