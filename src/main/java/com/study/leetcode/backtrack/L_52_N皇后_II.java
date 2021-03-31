package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N皇后 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/31 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_52_N皇后_II {

    static int countOfAns = 0;

    public static int totalNQueens(int n) {
        char[][] help = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                help[i][j] = '.';
            }
        }

        solveNQueens(help, 0, n);
        return countOfAns;
    }

    private static void solveNQueens(char[][] help, int row, int n) {
        if (row == n) {
            countOfAns++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(help, row, i, n)) {
                help[row][i] = 'Q';
                solveNQueens(help, row + 1, n);
                help[row][i] = '.';
            }
        }
    }

    private static List<String> buildList(char[][] help) {
        List<String> res = new ArrayList<>();
        for (char[] chars : help) {
            res.add(new String(chars));
        }
        return res;
    }

    private static boolean valid(char[][] help, int row, int col, int n) {
        // 判断同一行是否有Q存在
        for (int i = 0; i < row; i++) {
            if (help[i][col] == 'Q') {
                return false;
            }
        }
        // 判断斜上方是否有Q存在
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (help[i][j] == 'Q') {
                return false;
            }
        }
        // 判断斜下方是否有Q存在
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (help[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
