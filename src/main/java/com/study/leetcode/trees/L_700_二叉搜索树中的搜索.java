package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/22 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_700_二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
            if (root == null)
                return null;
            if (val < root.val) {
                return searchBST(root.left, val);
            } else if (val > root.val) {
                return searchBST(root.right, val);
            } else {
                return root;
            }
    }

    public static void main(String[] args) {

    }
}
