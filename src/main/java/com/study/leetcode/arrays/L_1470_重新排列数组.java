package com.study.leetcode.arrays;

/**
 * 1470. 重新排列数组
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/16 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1470_重新排列数组 {

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int lo = 0;
        int mid = n;
        int index = 0;
        while (lo < n) {
            ans[index++] = nums[lo++];
            ans[index++] = nums[mid++];
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
