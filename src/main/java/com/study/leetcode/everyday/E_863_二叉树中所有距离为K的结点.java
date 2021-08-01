package com.study.leetcode.everyday;

import com.study.common.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. 二叉树中所有距离为 K 的结点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/28</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_863_二叉树中所有距离为K的结点 {

    private static List<Integer> ans = new ArrayList<>();
    private static Map<Integer, TreeNode> parents = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        dfs(target, null, k, 0);
        return ans;
    }

    private static void findParents(TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParents(root.left);
        }

        if (root.right != null) {
            parents.put(root.right.val, root);
            findParents(root.right);
        }
    }

    private static void dfs(TreeNode root, TreeNode from, int k, int depth) {
        if (root == null) {
            return;
        }

        if (depth == k) {
            ans.add(root.val);
            return;
        }

        if (root.left != from) {
            dfs(root.left, root, k, depth + 1);
        }

        if (root.right != from) {
            dfs(root.right, root, k, depth + 1);
        }

        if (parents.get(root.val) != from) {
            dfs(parents.get(root.val), root, k, depth + 1);
        }
    }

    public static void main(String[] args) {

    }
}
