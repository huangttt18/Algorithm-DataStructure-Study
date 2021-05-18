package com.study.leetcode.everyday;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/18</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1442_形成两个异或相等数组的三元组数目 {

    public static int countTriplets(int[] arr) {
        int ans = 0;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int sum = 0;
            for (int k = i; k < len; k++) {
                sum ^= arr[k];
                if (sum == 0 && k > i)
                    ans += (k - i);
            }
        }
        return ans;
    }

    public static int countTriplets2(int[] arr) {
        int ans = 0;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int sum = arr[i];
            for (int k = i + 1; k < len; k++) {
                sum ^= arr[k];
                if (sum == 0)
                    ans += (k - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
