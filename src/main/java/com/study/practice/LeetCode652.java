package com.study.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652. 寻找重复的子树
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class LeetCode652 {

    static HashMap<String, Integer> map = new HashMap<>();
    static List<TreeNode> duplicatedSubTrees = new ArrayList<>();

    static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return duplicatedSubTrees;
    }

    static String traverse(TreeNode root) {
        if (root == null)
            return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);

        // 将树序列化成字符串
        String subTree = left + "," + right + "," + root.val;

        // 检查当前子树是否存在于map中
        int times = map.getOrDefault(subTree, 0);
        if (times == 1)
            // 如果存在，就将该子树加入到重复子树list中
            duplicatedSubTrees.add(root);
        // 该子树重复次数++
        map.put(subTree, ++times);
        return subTree;
    }

    public static void main(String[] args) {

        System.out.println();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
