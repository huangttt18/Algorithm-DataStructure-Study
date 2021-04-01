package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_47_全排列_II {

    static boolean[] usedMap;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        usedMap = new boolean[nums.length];
        Arrays.sort(nums);
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
            // 如果nums[i] == nums[i - 1]表示当前元素和之前的元素一样
            // 由于在调用backtrack方法之前已经对元素进行了排序，那么在这种情况下，元素的组合应该是一样的
            // 同时如果前一个元素已经被使用过了，那么表示其对应的组合已经存放到ans中了
            // 因此这里可以直接跳过
            // 这就是剪枝，减掉已经被选过的
            if (i > 0 && nums[i] == nums[i - 1] && !usedMap[i - 1])
                continue;
            path.add(nums[i]);
            usedMap[i] = true;
            backtrack(ans, path, nums, start + 1);
            path.remove(path.size() - 1);
            usedMap[i] = false;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 1, 2};
        int[] nums = {1, 1, 2, 2};
        System.out.println(permuteUnique(nums));
    }
}
