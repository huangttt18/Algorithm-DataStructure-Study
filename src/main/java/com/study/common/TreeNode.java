package com.study.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树结点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/12 </a>
 * @since <span>1.0</span>
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(int... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i : arr) {
            if (root.val < i) {
                root.right = new TreeNode(root.val);
            } else {
                root.left = new TreeNode(root.val);
            }
        }
        return root;
    }


    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.val + ",");
        printTree(root.right);
    }

    public static void printTreeLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                ans.append(poll.val).append(',');
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                ans.append("null").append(',');
            }
        }
        String[] split = ans.substring(0, ans.length() - 1).split(",");
        int i;
        for (i = split.length - 1; i >= 0 && "null".equals(split[i]); i--)
            ;

        for (int j = 0; j <= i; j++) {
            System.out.print(split[j]);
            if (j != i)
                System.out.print(',');
        }
        System.out.println();
    }
}
