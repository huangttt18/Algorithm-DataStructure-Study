package com.study.leetcode.everyday;

/**
 * 74. 搜索二维矩阵
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/30 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_74_搜索二维矩阵 {

    /**
     * 将二维数组转按顺序换为一维数组，那么一维数组就是有序数组，因此可以使用二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int tempLength = m * n;
        int[] tempArr = new int[tempLength];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tempArr[index++] = matrix[i][j];
            }
        }

        int start = 0;
        int end = tempLength - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < tempArr[mid]) {
                end = mid - 1;
            } else if (target > tempArr[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
