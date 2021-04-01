package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/31 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_78_子集 {

    static List<List<Integer>> ans;

    public static List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    private static void backtrack(int[] nums, List<Integer> path, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
