package com.study.leetcode.everyday;

/**
 * 137. 只出现一次的数字 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/30 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_137_只出现一次的数字_II {

    public static int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for(int x : nums){
            one = one ^ x & ~two;
            two = two ^ x & ~one;
        }
        return one;
    }

    public static void main(String[] args) {

    }
}
