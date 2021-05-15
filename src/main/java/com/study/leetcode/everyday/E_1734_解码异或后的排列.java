package com.study.leetcode.everyday;

/**
 * 1734. 解码异或后的排列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/11 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1734_解码异或后的排列 {

    public static int[] decode(int[] encoded) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        int total = 0;
        for (int i = 1; i <= n + 1; i++) {
            total ^= i;
        }
        int e1 = 0;
        for (int i = 1; i < n; i += 2) {
            e1 ^= encoded[i];
        }
        ans[0] = total ^ e1;
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] encoded = {3, 1};
        for (int i : decode(encoded)) {
            System.out.println(i);
        }
    }
}
