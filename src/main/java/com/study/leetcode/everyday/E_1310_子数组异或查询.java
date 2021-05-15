package com.study.leetcode.everyday;

/**
 * 1310. 子数组异或查询
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/12 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1310_子数组异或查询 {

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int row = queries.length;
        int[] ans = new int[row];
        for (int i = 0; i < row; i++) {
            int tmp = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                tmp ^= arr[j];
            }
            ans[i] = tmp;
        }

        return ans;
    }

    /**
     * 前缀和
     */
    public static int[] xorQueries2(int[] arr, int[][] queries) {
        int row = queries.length;
        int len = arr.length;
        int[] ans = new int[row];
        int[] memo = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            memo[i] = memo[i - 1] ^ arr[i - 1];
        }

        for (int i = 0; i < row; i++) {
            ans[i] = memo[queries[i][0]] ^ memo[queries[i][1] + 1];
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
