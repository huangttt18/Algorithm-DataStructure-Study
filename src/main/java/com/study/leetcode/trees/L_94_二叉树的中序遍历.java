package com.study.leetcode.trees;

import com.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_94_二叉树的中序遍历 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(ans, root);
        return ans;
    }

    private static void inOrder(List<Integer> ans, TreeNode root) {
        if (root == null)
            return;
        inOrder(ans, root.left);
        ans.add(root.val);
        inOrder(ans, root.right);
    }

    public static void main(String[] args) {

    }
}
