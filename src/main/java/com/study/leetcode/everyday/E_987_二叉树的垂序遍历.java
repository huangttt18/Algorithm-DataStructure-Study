package com.study.leetcode.everyday;

import com.study.common.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 987. 二叉树的垂序遍历
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/31</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_987_二叉树的垂序遍历 {

    /**
     * key = col，value = 该col下的所有treeNode列表
     */
    private static Map<Integer, List<TreeNode>> map;
    /**
     * key = treeNode，value = treeNode对应的row
     */
    private static Map<TreeNode, Integer> map3;
    /**
     * key = treeNode值的list，value = col，用于对外层list进行排序，排序规则为按col大小排序
     */
    private static Map<List<Integer>, Integer> map2;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        map3 = new HashMap<>();
        map2 = new HashMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list;
        for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            list = new ArrayList<>();
            List<TreeNode> treeNodes = entry.getValue();
            // 给treeNode列表以升序排序，排序规则为
            // 如果treeNode1的row == treeNode2的row，那么返回它们的值的大小
            // 否则返回它们的row的大小
            treeNodes.sort((t1, t2) -> {
                int a = map3.get(t1);
                int b = map3.get(t2);
                if (a == b) {
                    return t1.val - t2.val;
                } else {
                    return a - b;
                }
            });
            for (TreeNode treeNode : treeNodes) {
                list.add(treeNode.val);
            }
            map2.put(list, entry.getKey());
            ans.add(list);
        }
        ans.sort((a, b) -> map2.get(a) - map2.get(b));
        return null;
    }

    /**
     * 中序遍历
     */
    private static void dfs(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        dfs(root.left, row + 1, col - 1);
        if (map.containsKey(col)) {
            map.get(col).add(root);
        } else {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            map.put(col, list);
        }
        map3.put(root, row);
        dfs(root.right, row + 1, col + 1);
    }

    /**
     * 对于每个节点TreeNode，用数组来记录其row，col，value
     */
    private static Map<TreeNode, int[]> m = new HashMap<>();

    /**
     * 对于col不同的节点，按col升序排序，对于col相同的节点，按row升序排序
     */
    public static List<List<Integer>> verticalTraversal2(TreeNode root) {
        m.put(root, new int[] { 0, 0, root.val});
        dfs2(root);
        List<int[]> list = new ArrayList<>(m.values());
        list.sort((a, b) -> {
            // 对于col不同的节点，按col升序排序
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            // 对于col相同，row不同的节点，按row升序排序
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            // 对于col相同，row相同的节点，按值升序排序
            return a[2] - b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < list.size();) {
            List<Integer> l = new ArrayList<>();
            int j;
            for (j = i; j < list.size() && list.get(j)[1] == list.get(i)[1]; j++) {
                l.add(list.get(j)[2]);
            }
            ans.add(l);
            i = j;
        }
        return ans;
    }

    private static void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }

        int[] info = m.get(root);
        int row = info[0], col = info[1], value = info[2];
        if (root.left != null) {
            m.put(root.left, new int[] { row + 1, col - 1, root.left.val });
            dfs2(root.left);
        }

        if (root.right != null) {
            m.put(root.right, new int[] { row + 1, col + 1, root.right.val});
            dfs2(root.right);
        }
    }

    public static void main(String[] args) {

    }

}
