package com.study.practice.jan20;

/**
 * 奇数值单元格的数目
 *
 * @author Daniel 2020/1/20
 */
public class LeetCode1252 {

    public static int oddCells(int n, int m, int[][] indices) {
        int[][] oldArray = new int[n][m];

        for (int[] index : indices) {
            // 0
            int row = index[0];
            // 1
            int col = index[1];
            for (int i = 0; i < oldArray[row].length; i++) {
                oldArray[row][i] += 1;
            }
            for (int i = 0; i < oldArray.length; i++) {
                oldArray[i][col] += 1;
            }
        }

        int oddCount = 0;
        for (int[] array : oldArray) {
            for (int i : array) {
                if (i % 2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

    public static void main(String[] args) {
//        int[][] indices = new int[][]{{0, 1}, {1, 1}};
        int[][] indices = new int[][]{{1, 1}, {0, 0}};
//        System.out.println(oddCells(2, 3, indices));
        System.out.println(oddCells(2, 2, indices));
    }
}
