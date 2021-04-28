package com.study.leetcode.trees;

import com.study.common.TreeNode;

/**
 * 1302. 层数最深叶子节点的和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1302_层数最深叶子节点的和 {

    public static int deepestLeavesSum(TreeNode root) {
        return dfs(root, depth(root, 0), 0);
    }

    private static int depth(TreeNode root, int depth) {
        if (root == null)
            return depth - 1;
        return Math.max(depth, Math.max(depth(root.left, depth + 1), depth(root.right, depth + 1)));
    }

    private static int dfs(TreeNode root, int depth, int curDep) {
        if (root == null)
            return 0;
        if (curDep == depth)
            return root.val;
        return dfs(root.left, depth, curDep + 1) + dfs(root.right, depth, curDep + 1);
    }

    public static void main(String[] args) {

    }
}
