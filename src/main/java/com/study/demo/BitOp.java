package com.study.demo;

/**
 * 位运算的一些技巧
 * <ul>
 *     <li>判断n是否为2的非负整数幂: n > 0 && (n & (n - 1)) == 0</li>
 *     <li>逆运算：已知m，k，有n ^ m = k 则 n = m ^ k</li>
 *     <li>一个数异或自己等于0：n ^ n == 0</li>
 *     <li>一个数异或0等于自己：n ^ 0 = n</li>
 *     <li>不使用额外空间交换两个数字的位置: n ^ m = k, m ^ k = n, n ^ k = m</li>
 * </ul>
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
public class BitOp {

    public static void main(String[] args) {
        // 判断n是否为2的非负整数幂: n > 0 && (n & (n - 1)) == 0
        System.out.println(6 & 5);
        System.out.println(4 & 3);
        // 已知m，k，有n ^ m = k 则 n = m ^ k
        // 6 = 4 ^ n
        // 110 = 100 ^ 10
        // 110 ^ 100 = 10
        System.out.println(6 ^ 4);
        // 一个数异或自己等于0：n ^ n == 0
        System.out.println(2 ^ 2);
        // 一个数异或0等于自己：n ^ 0 = n


        // 不使用额外空间交换两个数字的位置
        // n ^ m = k, m ^ k = n, n ^ k = m
        // 1 ^ 2 = 3, 2 ^ 3 = 1, 1 ^ 3 = 2
    }
}
