package com.study.leetcode.bitcalc;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/30 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_面试题_08_04_幂集 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int length = nums.length;
        ans.add(new ArrayList());

        for (int num : nums) {
            for (int i = 0, j = ans.size(); i < j; i++) {
                List<Integer> list = new ArrayList<>(ans.get(i));
                list.add(num);
                ans.add(list);
            }
        }

        return ans;
    }

    /**
     * 位运算：每一个元素都有两种状态，选中(1)，不选中(0)，那么如果有3个元素，一共就有2^3种可能
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        int length = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>(length);
        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1)
                    // 如果当前最后一位为1，则表示当前位置的元素被选中
                    temp.add(nums[j]);
            }
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets2(nums);
        System.out.print((1 >> 0) & 1);
        System.out.print(" ");
        System.out.print((1 >> 1) & 1);
        System.out.print(" ");
        System.out.print((1 >> 2) & 1);
        System.out.print(" | ");
        System.out.print((2 >> 0) & 1);
        System.out.print(" ");
        System.out.print((2 >> 1) & 1);
        System.out.print(" ");
        System.out.print((2 >> 2) & 1);
        System.out.print(" | ");
        System.out.print((3 >> 0) & 1);
        System.out.print(" ");
        System.out.print((3 >> 1) & 1);
        System.out.print(" ");
        System.out.print((3 >> 2) & 1);
        System.out.print("\n");
    }
}
