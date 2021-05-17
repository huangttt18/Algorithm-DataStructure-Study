package com.study.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_429_N_叉树的层序遍历 {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                for (Node child : poll.children) {
                    queue.offer(child);
                }
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

    private static class Node {

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
