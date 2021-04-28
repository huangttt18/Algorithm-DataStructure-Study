package com.study.leetcode.slidingwindow;

/**
 * 1208. 尽可能使字符串相等
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/20 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1208_尽可能使字符串相等 {

    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int sum = 0, ans = 0;
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            right++;
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
