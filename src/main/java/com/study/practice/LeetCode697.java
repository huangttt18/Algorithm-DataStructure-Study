package com.study.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 697：数组的度
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/20 </a>
 * @since <span>1.0</span>
 */
public class LeetCode697 {

    static int[] arr = {1, 2, 2, 3, 1, 4, 2};
    static int[] arr2 = {1, 2, 2, 3, 1};

    public static int findShortestSubArray(int[] nums) {
        // 首先求出nums的度
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int d = -1;
        int max = -1;
        for (Integer i : map.keySet()) {
            Integer maxI = map.get(i);
            if (max < maxI) {
                d = i;
                max = maxI;
            }
        }
        // 接着寻找度与nums相等的子串
        int count = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (start == -1 && nums[i] == d) {
                start = i;
                count++;
            } else if (nums[i] == d) {
                count++;
            }
            if (count == max) {
                end = i;
            }
        }
        return (end - start) + 1;
    }

    public static void main(String[] args) {
//        System.out.println(findShortestSubArray(arr));
        System.out.println(findShortestSubArray(arr2));
    }
}
