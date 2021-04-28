package com.study.leetcode.everyday;

import java.util.Arrays;

/**
 * 179. 最大数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/12 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_179_最大数 {

    public static String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, (pre, nxt) -> {
            return (nxt + pre).compareTo(pre + nxt);
        });

        if ('0' == numStr[0].charAt(0))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : numStr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(largestNumber(nums));
    }
}
