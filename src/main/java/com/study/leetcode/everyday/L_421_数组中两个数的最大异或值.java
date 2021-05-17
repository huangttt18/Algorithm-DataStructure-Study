package com.study.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/16</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_421_数组中两个数的最大异或值 {

    /**
     * O(n^2) ：暴力解超时
     */
    public static int findMaximumXOR(int[] nums) {
        int ans = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                ans = Math.max(nums[i] ^ nums[j], ans);
            }
        }
        return ans;
    }

    /**
     * 为了找到数组中所有两个数异或的最大值，那么就需要尽可能的将每一位置为一
     */
    public static int findMaximumXOR2(int[] nums) {
        int ans = 0;
        final int HIGH_BIT = 30;
        for (int k = HIGH_BIT; k >= 0; k--) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num >> k);
            }

            int next = ans * 2 + 1;
            boolean found = false;

            for (int num : nums) {
                if (set.contains(next ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found)
                ans = next;
            else
                ans = next - 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
