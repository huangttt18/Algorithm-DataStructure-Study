package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_938_二叉搜索树的范围和 {

    public static int rangeSumBST(TreeNode root, int low, int high) {
        return sum(root, low, high);
    }

    /**
     * BST，所以root.val > root.left.val，root.val < root.right.val
     * if (low > root.val) 表示左子树肯定都比low小，因此只需要搜索右子树
     * if (high < root.val) 表示右子树肯定都比high大，因此只需要搜索左子树
     * 否则搜索整个树
     */
    public static int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val < low)
            return rangeSumBST2(root.right, low, high);
        if (root.val > high)
            return rangeSumBST2(root.left, low, high);
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
    }

    private static int sum(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        return (root.val >= low && root.val <= high ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

    }
}
