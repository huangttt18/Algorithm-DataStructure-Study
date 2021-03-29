package com.study.leetcode.strings;

/**
 * 9. 回文数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/29 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_9_回文数 {

    public static boolean isPalindrome(int x) {
        if (x > 0) {
            return false;
        }
        return x == reverse(x);
    }

    private static int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }

    public static void main(String[] args) {

    }
}
