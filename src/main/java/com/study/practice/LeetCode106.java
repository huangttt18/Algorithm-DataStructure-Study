package com.study.practice;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class LeetCode106 {

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    // [start, end]
    static TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd)
            return null;
        int rootVal = postorder[postEnd];

        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        // 构造左子树
        // left 9, root 3, right 15,20,7
        // left 9, right 15,7,20, root 3
        int leftSize = rootIndex - inStart;
        root.left = build(inOrder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftSize - 1);
        // 构造右子树
        root.right = build(inOrder, rootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        // 中序遍历，左子树 -> root -> 右子树
        int[] inOrder = new int[] {9,3,15,20,7};
        // 后序遍历，左子树 -> 右子树 -> root
        int[] postOrder = new int[] {9,15,7,20,3};
        TreeNode root = buildTree(inOrder, postOrder);
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
