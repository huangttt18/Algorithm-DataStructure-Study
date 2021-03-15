package com.study.algo4.search;

/**
 * 二叉查找树
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/12 </a>
 * @since <span>1.0</span>
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            return get(x.right, key);
        else if (cmp < 0)
            return get(x.left, key);
        else
            return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            put(x.right, key, val);
        else if (cmp < 0)
            put(x.left, key, val);
        else
            x.val = val;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node x) {
        if (x == null)
            return null;
        if (x.left != null)
            return min(x.left);
        else
            return x.key;
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node x) {
        if (x == null)
            return null;
        if (x.right != null)
            return max(x.right);
        else
            return x.key;
    }

    /**
     * 获取比当前key小的最大key
     *
     * @param key key
     * @return 比当前key小的最大key
     */
    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            return floor(x.right, key);
        else if (cmp < 0)
            return floor(x.left, key);
        else
            return x.key;
    }

    /**
     * 获取比当前key大的最小key
     *
     * @param key key
     * @return 比当前key大的最小key
     */
    public Key cell(Key key) {
        return cell(root, key);
    }

    private Key cell(Node x, Key key) {
        // TODO
        return null;
    }

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }
}
