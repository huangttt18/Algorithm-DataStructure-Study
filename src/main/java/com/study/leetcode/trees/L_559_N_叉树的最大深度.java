package com.study.leetcode.trees;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_559_N_叉树的最大深度 {

    public static int maxDepth(Node root) {
        return depth(root, 0);
    }

    private static int depth(Node root, int curDepth) {
        if (root == null)
            return 0;

        List<Node> children = root.children;
        int maxDepth = Integer.MIN_VALUE;
        for (int i = 0; i < children.size(); i++) {
            maxDepth = Math.max(depth(children.get(i), curDepth + 1), maxDepth);
        }
        return maxDepth;
    }


    public static void main(String[] args) {

    }

    private static class Node {
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
