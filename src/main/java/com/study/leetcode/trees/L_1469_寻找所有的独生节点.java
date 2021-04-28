package com.study.leetcode.trees;

import com.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1469. 寻找所有的独生节点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1469_寻找所有的独生节点 {

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.right == null && root.left != null)
            ans.add(root.left.val);
        else if (root.right != null && root.left == null)
            ans.add(root.right.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
