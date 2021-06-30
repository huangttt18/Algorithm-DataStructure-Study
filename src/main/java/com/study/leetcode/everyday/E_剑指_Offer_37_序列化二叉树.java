package com.study.leetcode.everyday;

import com.study.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/30</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_剑指_Offer_37_序列化二叉树 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        TreeNode deserialize = codec.deserialize2(serialize);
        TreeNode.printTreeLevel(deserialize);
    }

    static class Codec {

        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
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
            return ans.substring(0, ans.length() - 1).toString();
        }

        public TreeNode deserialize2(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }

            String[] split = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (!("null".equals(split[i]))) {
                    poll.left = new TreeNode(Integer.parseInt(split[i]));
                    queue.offer(poll.left);
                }
                i++;
                if (!("null".equals(split[i]))) {
                    poll.right = new TreeNode(Integer.parseInt(split[i]));
                    queue.offer(poll.right);
                }
                i++;
            }
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] split = data.split(",");
            return build(split, 0);
        }

        public TreeNode build(String[] split, int start) {
            if (start >= split.length || "null".equals(split[start])) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(split[start]));
            root.left = build(split, 2 * start + 1);
            root.right = build(split, 2 * start + 2);

            return root;
        }
    }
}
