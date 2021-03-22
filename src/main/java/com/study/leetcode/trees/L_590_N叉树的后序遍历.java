package com.study.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/22 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_590_N叉树的后序遍历 {

   static List<Integer> ans;

    public static List<Integer> postorder(Node root) {
        if (root == null) {
            ans = new ArrayList<>();
            return ans;
        }
        ans = new ArrayList<>();
        postOrder(root.children);
        ans.add(root.val);
        return ans;
    }

    public static void postOrder(List<Node> nodes) {
        if (nodes == null)
            return;
        for (Node node : nodes) {
            postOrder(node.children);
            ans.add(node.val);
        }
    }

    public static void main(String[] args) {

    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
