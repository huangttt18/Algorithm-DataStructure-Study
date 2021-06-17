package com.study.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/3</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_525_连续数组 {

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1)
                counter++;
            else
                counter--;

            if (map.containsKey(counter))
                ans = Math.max(ans, i - map.get(counter));
            else
                map.put(counter, i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
