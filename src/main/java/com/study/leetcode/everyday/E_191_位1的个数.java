package com.study.leetcode.everyday;

/**
 * 191. 位1的个数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/22 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_191_位1的个数 {

    public static int hammingWeight(int x) {
        String s = Integer.toBinaryString(x);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1')
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = -3;
        while (x != 0) {
            System.out.println(Integer.toBinaryString(x));
            System.out.println(Integer.toBinaryString(x - 1));
            x &= (x - 1);
            System.out.println(x);
        }

        System.out.println();
    }
}
