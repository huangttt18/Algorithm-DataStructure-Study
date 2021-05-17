package com.study.leetcode.everyday;

import com.study.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_993_二叉树的堂兄弟节点 {

    /**
     * bfs
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int levelX = 0;
        int levelY = 0;
        TreeNode rootX = root;
        TreeNode rootY = root;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    if (poll.left.val == x) {
                        levelX = level;
                        rootX = poll;
                    }
                    if (poll.left.val == y) {
                        levelY = level;
                        rootY = poll;
                    }
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    if (poll.right.val == x) {
                        levelX = level;
                        rootX = poll;
                    }
                    if (poll.right.val == y) {
                        levelY = level;
                        rootY = poll;
                    }
                }
            }
        }

        return levelX == levelY && rootX != rootY;
    }

    public static void main(String[] args) {

    }

}
