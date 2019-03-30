package com.study.bst;

/**
 * 二分搜索树
 * @Author Created by Daniel
 */
public class BinarySearchTree {

    private Node root;

    class Node<K, V> {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }


}
