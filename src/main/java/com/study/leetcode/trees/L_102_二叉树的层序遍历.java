package com.study.leetcode.trees;

import com.study.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_102_二叉树的层序遍历 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        ans.add(first);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    list.add(poll.right.val);
                }
            }
            if (list.size() != 0)
                ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
