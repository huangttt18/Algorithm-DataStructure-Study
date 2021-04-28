package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Offer_剑指Offer_55_I_二叉树的深度 {

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
