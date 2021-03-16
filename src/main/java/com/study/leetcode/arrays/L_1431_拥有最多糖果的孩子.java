package com.study.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/16 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1431_拥有最多糖果的孩子 {


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        List<Boolean> ans = new ArrayList<>(length);
        int max = 0;
        for (int candy : candies) {
            if (max < candy)
                max = candy;
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                ans.add(i, true);
            else
                ans.add(i, false);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
