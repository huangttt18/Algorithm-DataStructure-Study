package com.study.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/2 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_120_三角形最小路径和 {

    static Integer[][] memoMin;

    /**
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 记忆化搜索
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        memoMin = new Integer[triangle.size()][triangle.size()];
        return memo(triangle, 0, 0);
    }

    private static int memo(List<List<Integer>> triangle, int curIndex, int curHeight) {
        if (curHeight == triangle.size())
            return 0;

        if (memoMin[curHeight][curIndex] == null)
            memoMin[curHeight][curIndex] = Math.min(
                    memo(triangle, curIndex, curHeight + 1),
                    memo(triangle, curIndex + 1, curHeight + 1)) + triangle.get(curHeight).get(curIndex);

        return memoMin[curHeight][curIndex];
    }

    /**
     * 动态规划
     * @param triangle
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        // dp[i][j] 表示Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle.get(i).get(j)
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j + 1], dp[i + 1][j]);
            }
        }

        return dp[0][0];
    }



    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                t.add((int) (Math.random() * 10 + 1));
            }
            triangle.add(t);
        }

        System.out.println(triangle);
        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal2(triangle));
    }
}
