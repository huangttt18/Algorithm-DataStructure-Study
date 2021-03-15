package com.study.leetcode.arrays;

/**
 * 1512. 好数对的数目
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/15 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1512_好数对的数目 {

    public static int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j])
                    ans++;
            }
        }

        return ans;
    }

    public static int numIdenticalPairs2(int[] nums) {
        int[] hash = new int[100];
        int ans = 0;
        for (int num : nums) {
            ans += hash[num - 1]++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
