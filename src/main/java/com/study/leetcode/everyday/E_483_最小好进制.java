package com.study.leetcode.everyday;

/**
 * 483. 最小好进制
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/18</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_483_最小好进制 {

    public static String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        long ans = Long.MAX_VALUE;
        for (int i = 1; i < 64; i++) {
            long l = 2, r = num;
            while (l < r) {
                long mid = (l + r) >>> 1;
                long power = check(mid, i);
                if (power == num) {
                    ans = Math.min(ans, mid);
                    break;
                } else if (power < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }

        return String.valueOf(ans);
    }

    public static String smallestGoodBase2(String n) {
        long num = Long.parseLong(n);
        for (int i = 59; i > 1; i--) {
            long k = (long) Math.pow(num, 1.0 / i);
            if (k <= 1)
                continue;
            long s = 0;
            for (int j = 0; j <= i; j++) {
                s = s * k + 1;
            }

            if (s == num)
                return String.valueOf(k);
        }

        return String.valueOf(num - 1);
    }

    static long check(long mid, long index) {
        long ret = 0;
        for (int i = 0; i <= index; i++) {
            ret = ret * mid + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        long n = 4681;
        System.out.println(smallestGoodBase2(String.valueOf(n)));
//        for (int i = 59; i > 1; i--) {
//            System.out.println((long) Math.pow(n, 1.0 / i));
//        }
    }

}
