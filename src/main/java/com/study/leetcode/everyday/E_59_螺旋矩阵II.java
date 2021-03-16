package com.study.leetcode.everyday;

import com.study.common.util.CommonUtils;

/**
 * 59. 螺旋矩阵 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/16 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_59_螺旋矩阵II {

    public static int[][] generateMatrix(int n) {
        int row = n;
        int col = n;
        int[][] ans = new int[row][col];
        int totalLevel = (n + 1) / 2;
        int curLevel = 0;
        int num = 1;
        while (curLevel < totalLevel) {
            for (int i = curLevel; i < col - curLevel; i++) {
                ans[curLevel][i] = num++;
            }

            for (int i = curLevel + 1; i < row - curLevel; i++) {
                ans[i][col - 1 - curLevel] = num++;
            }

            for (int i = col - 1 - curLevel - 1; i >= curLevel && col - 1 - curLevel != curLevel; i--) {
                ans[row - 1 - curLevel][i] = num++;
            }

            for (int i = row - 1 - curLevel - 1; i >= curLevel + 1 && row - 1 - curLevel != curLevel; i--) {
                ans[i][curLevel] = num++;
            }

            curLevel++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        CommonUtils.printArray(generateMatrix(n));
    }
}
