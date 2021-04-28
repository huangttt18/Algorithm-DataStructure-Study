package com.study.leetcode.everyday;

/**
 * 91. 解码方法
 * 11106
 * 1 -> 1106
 *  1 -> 106
 *   1 -> 06
 *    0 -> 6
 *     6
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/21 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_91_解码方法 {

    public static int numDecodings(String s) {
        int length = s.length();
        s = " " + s;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            int a = s.charAt(i) - '0';
            int b = (s.charAt(i - 1) - '0') * 10 + a;
            if (a >= 1 && a <= 9)
                dp[i] = dp[i - 1];
            if (b >= 10 && b <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[length];
    }

    public static int numDecodings2(String s) {
        int length = s.length();
        s = " " + s;
        int[] dp = new int[3];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            dp[i % 3] = 0;
            int a = s.charAt(i) - '0';
            int b = (s.charAt(i - 1) - '0') * 10 + a;
            if (a >= 1 && a <= 9)
                dp[i % 3] = dp[(i - 1) % 3];
            if (b >= 10 && b <= 26)
                dp[i % 3] += dp[(i - 2) % 3];
        }
        return dp[length % 3];
    }

    public static int numDecodings3(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int pre = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    cur = pre;
                else
                    return 0;
            } else if (s.charAt(i - 1) == '1') {
                cur += pre;
            } else if (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                cur += pre;
            }
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        String s = "10";
        System.out.println(numDecodings3(s));
    }
}
