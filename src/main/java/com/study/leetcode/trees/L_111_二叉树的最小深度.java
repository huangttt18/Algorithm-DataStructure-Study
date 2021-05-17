package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_111_二叉树的最小深度 {

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }

}
