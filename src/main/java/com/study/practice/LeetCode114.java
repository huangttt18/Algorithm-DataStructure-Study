package com.study.practice;

import javax.swing.tree.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/21 </a>
 * @since <span>1.0</span>
 */
public class LeetCode114 {

    static void flatten(TreeNode root) {
        if (root == null)
            return;

        // 展开整个树
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将left替换到right并将left置为null
        root.right = left;
        root.left = null;

        // 将右子树接到当前右子树的尾部
        while (root.right != null)
            root = root.right;
        root.right = right;
    }

    public static void main(String[] args) {

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
