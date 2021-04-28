package com.study.leetcode.everyday;

import com.study.common.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/13 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_783_二叉搜索树节点最小距离 {

    /**
     * 记录前一个节点的值
     */
    static int pre;
    /**
     * 答案，初始化为MAX_VALUE
     */
    static int ans;

    /**
     * BST：有序，所以最小距离一定是相邻元素之间的距离
     */
    public static int minDiffInBST(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    /**
     * 中序遍历，每次遍历记录当前节点的值，用于下一次遍历进行比较
     */
    private static void dfs(TreeNode root) {
        // 递归退出条件
        if (root == null)
            return;
        // 遍历左子树
        dfs(root.left);
        // 遍历根节点
        if (pre == -1)
            // 如果pre == -1，表示第一次遍历，此时记录当前节点的值
            pre = root.val;
        else {
            // 计算当前最小距离
            ans = Math.min(ans, root.val - pre);
            // 记录当前节点的值
            pre = root.val;
        }
        // 遍历右子树
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
