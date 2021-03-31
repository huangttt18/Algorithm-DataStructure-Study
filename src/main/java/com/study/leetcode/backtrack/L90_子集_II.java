package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/31 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L90_子集_II {

    static List<List<Integer>> ans;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        // 回溯方法
        subsetsWithDup(nums, new ArrayList<>(), 0);
        return ans;
    }

    private static void subsetsWithDup(int[] nums, List<Integer> path, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            subsetsWithDup(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
