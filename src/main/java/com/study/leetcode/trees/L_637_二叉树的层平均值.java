package com.study.leetcode.trees;

import com.study.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_637_二叉树的层平均值 {

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
            ans.add((double) sum / size);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
