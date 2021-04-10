package com.study.leetcode.everyday;

/**
 * 263. 丑数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/10 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_263_丑数 {

    public static boolean isUgly(int n) {
        if (n <= 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1;
    }

    private static boolean isPrime(int t) {
        if (t <= 3)
            return true;
        if (t % 6 != 1 && t % 6 != 5)
            return false;
        int sqrt = (int) Math.sqrt(t);
        for (int i = 5; i <= sqrt; i += 6) {
            if (t % i == 0 ||  t % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(73));
        System.out.println(isPrime(8));
    }
}
