package com.study.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * @Author Created by Daniel
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        Node(E e) {
            this.e = e;
            this.left = this.right = null;
        }
    }

    private Node root;

    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        // 循环终止条件
        // 如果当前node为空，则返回一个新的节点
        if (node == null) {
            size ++;
            return new Node(e);
        }

        // 如果e小于当前node.e
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrderInLoop() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E minimum() {
        if (size == 0) {
            return null;
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            return null;
        }

        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
         if (node == null) {
             return null;
         }

         if (e.compareTo(node.e) < 0) {
             node.left = remove(node.left, e);
             return node;
         } else if (e.compareTo(node.e) > 0) {
             node.right = remove(node.right, e);
             return node;
         } else {
             if (node.left == null) {
                 Node rightNode = node.right;
                 node.right = null;
                 size --;
                 return rightNode;
             }

             if (node.right == null) {
                 Node leftNode = node.left;
                 node.left = null;
                 size --;
                 return leftNode;
             }

             // 当要删除的节点同时存在左右子节点的时候
             // 先找到当前节点的后继结点（比当前节点大的最小的节点）
             // 然后将当前节点的removeMin()之后的右子树赋值给后继结点的右子树
             // 然后将当前节点的左子树赋值给后继结点的左子树
             // 最后将当前节点删除，并返回新的子树
             Node successor = minimum(node.right);
             successor.right = removeMin(node.right);
             successor.left = node.left;

             node.left = node.right = null;
             return successor;
         }
    }
}
