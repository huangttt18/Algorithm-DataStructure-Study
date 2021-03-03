package com.study.leetcode.everyday;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/2 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_304_二维区域和检索_矩阵不可变 {

    class NumMatrix {

        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int length = matrix.length;
            if (length > 0) {
                int col = matrix[0].length + 1;
                preSum = new int[length][col];

                for (int r = 0; r < length; r++) {
                    for (int c = 1; c < col; c++) {
                        preSum[r][c] = preSum[r][c - 1] + matrix[r][c - 1];
                    }
                }
            }
        }

        /**
         * 求每一行的preSum，再相加即可
         *
         * @param row1
         * @param col1
         * @param row2
         * @param col2
         * @return
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += preSum[i][col2 + 1] - preSum[i][col1];
            }
            return sum;
        }
    }

    /**
     * TODO 二维矩阵前缀和
     */
    class NumMatrix2 {

        int[][] preSum;

        public NumMatrix2(int[][] matrix) {
            int length = matrix.length;
            if (length > 0) {
                int row = length + 1;
                int col = matrix[0].length + 1;
                preSum = new int[row][col];
                for (int r = 1; r < row; r++) {
                    for (int c = 1; c < col; c++) {
                        preSum[r][c] = preSum[r - 1][c] + preSum[r][c - 1] - preSum[r - 1][c - 1] + matrix[r - 1][c - 1];
                    }
                }
            }
        }

        /**
         * 二维矩阵前缀和
         *
         * @param row1
         * @param col1
         * @param row2
         * @param col2
         * @return
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] + preSum[row1][row2] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1];
        }
    }
}
