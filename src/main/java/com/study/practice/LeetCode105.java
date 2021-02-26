package com.study.practice;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class LeetCode105 {

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    static TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;

        // rootVal是preOrder的第一个元素
        int rootVal = preOrder[preStart];
        // 寻找rootVal在inOrder中的索引位置
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIndex = i;
            }
        }

        // 构造root节点
        TreeNode root = new TreeNode(rootVal);

        // root 3, 左子树 9 , 右子树 20,15,7
        // 左子树 9, root 3 , 右子树 15,20,7
        // 构造左子树[preStart + 1, rootIndex - inStart], [inStart, rootIndex - 1]，构造时不需要考虑原root
        root.left = build(preOrder, preStart + 1, preStart + rootIndex - inStart,
                inOrder, inStart, rootIndex - 1);

        // 构造右子树[preStart + rootIndex - inStart + 1, preEnd], [rootIndex + 1, inEnd]，同样的，也不需要考虑原root
        root.right = build(preOrder, preStart + rootIndex - inStart + 1, preEnd,
                inOrder, rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        // 前序遍历，preOrder[0] == root
        int[] preOrder = new int[] {3,9,20,15,7};
        // 中序遍历，左子树 -> root -> 右子树
        int[] inOrder = new int[] {9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
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
