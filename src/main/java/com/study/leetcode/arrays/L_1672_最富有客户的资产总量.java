package com.study.leetcode.arrays;

/**
 * 1672. 最富有客户的资产总量
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/15 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1672_最富有客户的资产总量 {

    public static int maximumWealth(int[][] accounts) {
        int ans = 0;
        int row = accounts.length;
        int col = accounts[0].length;
        for (int i = 0; i < row; i++) {
            int tempMax = 0;
            for (int j = 0; j < col; j++) {
                tempMax += accounts[i][j];
            }
            ans = Math.max(ans, tempMax);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
