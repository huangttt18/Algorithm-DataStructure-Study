package com.study.leetcode.trees;

import com.study.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_107_二叉树的层序遍历_II {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans.addFirst(list);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
