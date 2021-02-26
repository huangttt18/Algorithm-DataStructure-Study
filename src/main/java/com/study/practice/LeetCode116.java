package com.study.practice;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/21 </a>
 * @since <span>1.0</span>
 */
public class LeetCode116 {

    static Node connect(Node root) {
        if (root == null)
            return null;
        connect(root.left, root.right);
        return root;
    }

    static void connect(Node left, Node right) {
        if (left == null || right == null)
            return;

        left.next = right;

        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }

    public static void main(String[] args) {

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
