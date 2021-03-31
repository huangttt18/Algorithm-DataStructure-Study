package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12. 八皇后(N皇后)
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/31 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 面试题_08_12_八皇后 {

    static List<List<String>> ans;

    public static List<List<String>> solveNQueens(int n) {
        char[][] help = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                help[i][j] = '.';
            }
        }

        ans = new ArrayList<>(n);
        solveNQueens(help, 0, n);
        return ans;
    }

    private static void solveNQueens(char[][] help, int row, int n) {
        if (row == n) {
            ans.add(buildList(help));
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
        System.out.println(solveNQueens(4));
    }
}
