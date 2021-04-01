package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 46. 全排列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_46_全排列 {

    static boolean[] usedMap;

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        usedMap = new boolean[nums.length];
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> path, int[] nums, int start) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (usedMap[i])
                continue;
            path.add(nums[i]);
            usedMap[i] = true;
            backtrack(ans, path, nums, start + 1);
            path.remove(path.size() - 1);
            usedMap[i] = false;
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private static void backtrack2(List<List<Integer>> ans, List<Integer> path, int[] nums, int start) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backtrack(ans, path, nums, start + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
