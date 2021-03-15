package com.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/15 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_54_螺旋矩阵 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0)
            return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int level = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int totalLevel = (Math.min(row, col) + 1) / 2;
        //从外部向内部遍历，逐层打印数据
        while (level < totalLevel) {
            for (int i = level; i < col - level; i++) {
                list.add(matrix[level][i]);
            }
            for (int i = level + 1; i < row - level; i++) {
                list.add(matrix[i][(col - 1) - level]);
            }

            for (int i = (col - 1) - (level + 1); i >= level && (row - 1 - level != level); i--) {
                list.add(matrix[(row - 1) - level][i]);
            }
            for (int i = (row - 1) - (level + 1); i >= level + 1 && (col - 1 - level) != level; i--) {
                list.add(matrix[i][level]);
            }
            level++;
        }
        return list;
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        // 矩阵一共有多少层
        int totalLevel = (Math.min(row, col) + 1) / 2;
        // 当前遍历的层数
        int level = 0;

        while (level < totalLevel) {
            // 从左往右遍历
            for (int i = level; i < col - level; i++) {
                ans.add(matrix[level][i]);
            }
            // 从上至下遍历
            for (int i = level + 1; i < row - level; i++) {
                ans.add(matrix[i][col - 1 - level]);
            }
            // 从右往左遍历
            for (int i = col - 1 - level - 1; i >= level && (row - 1 - level != level); i--) {
                ans.add(matrix[row - 1 - level][i]);
            }
            // 从下至上遍历
            for (int i = row - 1 - level - 1; i >= level + 1 && (col - 1 - level != level); i--) {
                ans.add(matrix[i][level]);
            }

            level++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder2(matrix));
        System.out.println(spiralOrder2(matrix2));
    }
}
