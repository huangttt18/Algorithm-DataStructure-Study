package com.study.leetcode.everyday;

import com.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/10 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_872_叶子相似的树 {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ret1 = new ArrayList<>();
        List<Integer> ret2 = new ArrayList<>();
        collectLeaf(ret1, root1);
        collectLeaf(ret2, root2);
        return ret1.equals(ret2);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void collectLeaf(List<Integer> ret, TreeNode root) {
        if (root == null)
            return;

        if (isLeaf(root)) {
            ret.add(root.val);
            return;
        }

        collectLeaf(ret, root.left);
        collectLeaf(ret, root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);
        System.out.println(leafSimilar(root1, root2));
        char[] val = new char[Integer.MAX_VALUE - 1];
        String s = new String(val);
    }
}
