package com.study.leetcode.everyday;

/**
 * 190. 颠倒二进制位
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/29 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_190_颠倒二进制位 {

    public static int reverseBits(int n) {
        final int M1 = 0x55555555; // 01010101010101010101010101010101
        final int M2 = 0x33333333; // 00110011001100110011001100110011
        final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
        final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    public static int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(reverseBits(n));
    }
}
