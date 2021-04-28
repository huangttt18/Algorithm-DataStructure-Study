package com.study.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/21 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_494_目标和 {

    static int ans;

    public static int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        backtrack(nums, target, 0);
        return ans;
    }

    private static void backtrack(int[] nums, int target, int start) {
        if (start == nums.length) {
            if (target == 0)
                ans++;
            return;
        }

        target += nums[start];
        backtrack(nums, target, start + 1);
        target -= nums[start];

        target -= nums[start];
        backtrack(nums, target, start + 1);
        target += nums[start];
    }

    static Map<String, Integer> memo;

    public static int findTargetSumWays2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        memo = new HashMap<>();
        return backtrack2(nums, target, 0);
    }

    private static int backtrack2(int[] nums, int target, int start) {
        if (start == nums.length) {
            if (target == 0)
                return 1;
            return 0;
        }

        String key = start + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = backtrack2(nums, target + nums[start], start + 1) + backtrack2(nums, target - nums[start], start + 1);
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays2(nums, target));
    }
}
