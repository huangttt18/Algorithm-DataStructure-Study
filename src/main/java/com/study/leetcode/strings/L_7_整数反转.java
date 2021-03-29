package com.study.leetcode.strings;

/**
 * 7. 整数反转
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/29 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_7_整数反转 {

    public static int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
