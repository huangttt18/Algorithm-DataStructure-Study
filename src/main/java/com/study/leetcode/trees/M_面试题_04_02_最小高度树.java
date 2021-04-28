package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 面试题 04.02. 最小高度树
 *
 * [-10,-3,0,5,9]
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class M_面试题_04_02_最小高度树 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return createMinimalTree(nums, 0, nums.length);
    }

    private static TreeNode createMinimalTree(int[] nums, int left, int right) {
        // 退出条件
        if (left >= right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createMinimalTree(nums, left, mid);
        root.right = createMinimalTree(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums));
    }
}
