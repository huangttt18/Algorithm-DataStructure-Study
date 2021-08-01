package com.study.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/8/1</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1337_矩阵中战斗力最弱的K行 {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        Map<int[], Integer> map = new HashMap<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            map.put(mat[i], i);
        }
        Arrays.sort(mat, (a, b) -> {
            if (Arrays.stream(a).sum() == Arrays.stream(b).sum()) {
                return map.get(a) - map.get(b);
            }
            return Arrays.stream(a).sum() - Arrays.stream(b).sum();
        });
        for (int i = 0; i < k; i++) {
            ans[i] = map.get(mat[i]);
        }
        return ans;
    }

    /**
     * 寻找最后一个1的位置
     */
    private static int bs1(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return arr[l] == 1 ? l + 1 : l;
    }

    public static int[] kWeakestRows2(int[][] mat, int k) {
        int[] ans = new int[k];
        // aux[i][0] == mat[i]的索引
        // aux[i][1] == mat[i]的1的数量
        int n = mat.length;
        int[][] aux = new int[n][2];
        for (int i = 0; i < n; i++) {
            aux[i][0] = i;
            aux[i][1] = bs1(mat[i]);
        }

        Arrays.sort(aux, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            ans[i] = aux[i][0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        for (int i : kWeakestRows2(mat, 3)) {
            System.out.println(i);
        }
    }
}
