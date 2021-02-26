package com.study.leetcode.sort;

/**
 * 1446. 连续字符
 *
 * 对于给定字符串，返回其最长的重复子串的长度
 *
 * 比如：abbcccddddeeeeefdea，返回5，最长重复子串为'eeeee'
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
public class FindEnergy {

    public static int energy(String s) {
        // abbcccddddeeeeefdea
        // 解法：双指针
        int left = 0;
        int right = 1;
        int maxRepeatLength = 1;
        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                // 当right指针位置的字符与left指针的字符不同时
                // 接着改变left指针，下一次需要读取新的字符了
                left = right;
            }
            // 移动right指针
            right++;
            // 计算当前重复的长度，并与之前的最长重复字符串长度进行对比，将最大的值赋予maxRepeatLength
            maxRepeatLength = Math.max(right - left, maxRepeatLength);
        }
        return Math.max(right - left, maxRepeatLength);
    }

    public static void main(String[] args) {
        System.out.println(energy("leetcode"));
    }
}
