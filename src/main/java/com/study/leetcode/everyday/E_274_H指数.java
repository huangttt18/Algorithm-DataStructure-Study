package com.study.leetcode.everyday;

import java.util.Arrays;

/**
 * 274. H 指数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/11</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_274_H指数 {

    /**
     * citations = [3,0,6,1,5]
     * citations = [3,0,6,1,5]
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        int l = citations.length - 1;

        while (l >= 0 && citations[l] > ans) {
            ans++;
            l--;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {100};
        System.out.println(hIndex(citations));
    }

}
