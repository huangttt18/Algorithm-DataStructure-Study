package com.study.practice;

/**
 * 654. 最大二叉树
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class LeetCode654 {

    static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    static TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right)
            return null;

        // 找出nums中最大的元素做为root
        // 该位置左边为左子树，右边为右子树
        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (maxVal < nums[i]) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }


        TreeNode root = new TreeNode(maxVal);
        // 构造左子树
        root.left = constructMaximumBinaryTree(nums, left, maxIndex - 1);
        // 构造右子树
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
        System.out.println();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
