package com.study.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 403. 青蛙过河
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/29 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_403_青蛙过河 {

    static Map<String, Boolean> memo;

    /**
     * 如果想要知道第i个位置能不能过，就要知道第i - 1个位置能不能过， diff(i - 1, i) in [k - 1, k + 1]
     */
    public static boolean canCross(int[] stones) {
        memo = new HashMap<>();
        return cross(stones, 0, 0);
    }

    private static boolean cross(int[] stones, int start, int k) {
        String key = start + "_" + k;
        if (memo.containsKey(key))
            return false;
        else
            memo.put(key, true);
        for (int i = start + 1; i < stones.length; i++) {
            int diff = stones[i] - stones[start];
            if (diff >= k - 1 && diff <= k + 1)
                if (cross(stones, i, diff))
                    return true;
            else if (diff > k + 1)
                break;
        }
        return start == stones.length - 1;
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));
    }
}
