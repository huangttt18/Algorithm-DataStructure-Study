package com.study.leetcode.arrays;

/**
 * 1486. 数组异或操作
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/19 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1486_数组异或操作 {

    public static int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= (start + 2 * i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }
}
