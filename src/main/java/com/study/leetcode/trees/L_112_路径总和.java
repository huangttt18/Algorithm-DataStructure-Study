package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 112. 路径总和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/23 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_112_路径总和 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (!hasChild(root)) {
            return root.val == targetSum;
        }

        boolean hasLeft = hasPathSum(root.left, targetSum - root.val);
        boolean hasRight = hasPathSum(root.right, targetSum - root.val);
        return hasLeft || hasRight;
    }

    public static boolean hasChild(TreeNode root) {
        return root.right != null || root.left != null;
    }

    public static void main(String[] args) {
    }
}
