package com.study.leetcode.everyday;

/**
 * 633. 平方数之和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_633_平方数之和 {

    public static boolean judgeSquareSum(int c) {
        for (int i = 0; i < Math.sqrt(c) + 1; i++) {
            for (int j = i; j < Math.sqrt(c) + 1; j++) {
                if (i * i + j * j == c)
                    return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c) {
        for (long i = 0; i * i <= c; i++) {
            double b = Math.sqrt(c - i * i);
            if (b == (int) b)
                return true;
        }
        return false;
    }

    public static boolean judgeSquareSum3(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c)
                return true;
            if (sum < c)
                left++;
            else if (sum > c)
                right++;
        }
        return false;
    }

    /**
     * 费马平方和：当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数幂均为偶数时，该自然数才能被表示为两个平方数之和
     */
    public static boolean judgeSquareSum4(int c) {
        for (int i = 2; i * i <= c; i++) {
            // 排除非因子
            if (c % i != 0)
                continue;

            // 质因数分解
            int exp = 0;
            while (c % i == 0) {
                c /= i;
                exp++;
            }

            // 质因数是否满足 4k + 3 => i % 4 == 3
            // 是否满足幂为偶数 => exp % 2 == 0, 如果不满足，表示该数不能被表示为两个平方数之和
            if (i % 4 == 3 && exp % 2 != 0)
                return false;
        }

        return c % 4 != 3;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum2(5));
        System.out.println(judgeSquareSum4(11));
    }
}
