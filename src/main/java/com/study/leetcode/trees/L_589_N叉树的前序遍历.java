package com.study.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/22 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_589_N叉树的前序遍历 {

    List<Integer> ans;

    public List<Integer> preorder2(Node root) {
        if (root == null) {
            ans = new ArrayList<>();
            return ans;
        }
        ans = new ArrayList<>();
        ans.add(root.val);
        postOrder(root.children);
        return ans;
    }

    public void postOrder(List<Node> nodes) {
        if (nodes == null)
            return;
        for (Node node : nodes) {
            ans.add(node.val);
            postOrder(node.children);
        }
    }

//    public List<Integer> preorder(Node root) {
//
//    }

    public static void main(String[] args) {

    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
