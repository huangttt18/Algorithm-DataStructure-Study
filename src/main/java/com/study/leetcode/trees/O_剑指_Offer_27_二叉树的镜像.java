package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class O_剑指_Offer_27_二叉树的镜像 {

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = mirrorTree(root.right);
        newRoot.right = mirrorTree(root.left);
        return newRoot;
    }

    public static void main(String[] args) {

    }
}
