package com.study.leetcode.everyday;

import com.study.common.TreeNode;

/**
 * 897. 递增顺序搜索树
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_897_递增顺序搜索树 {

    static TreeNode newTree = new TreeNode();
    static TreeNode newRoot = newTree;

    public static TreeNode increasingBST(TreeNode root) {
        build(root);
        return newRoot.right;
    }

    private static void build(TreeNode root) {
        if (root == null)
            return;
        build(root.left);
        newTree.right = new TreeNode(root.val);
        newTree = newTree.right;
        build(root.right);
    }

    public static void main(String[] args) {

    }
}
