package com.study.algo4;

/**
 * 最大堆(最大优先队列 Max Priority Queue)
 * <p>
 * 当一棵二叉树的每个结点都大于等于它的两个子结点时，这棵二叉树被称为<b>堆有序</b>
 * <p>
 * 在一颗二叉树中，若除最后一层外的其余层都是满的，并且最后一层要么是满的，要么在右边缺少连续若干节点，则此二叉树为完全二叉树
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int size;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        size = 0;
    }

    /**
     * 新增一个元素
     */
    public void insert(Key key) {
        // 将新的元素插入pq数组
        pq[++size] = key;
        // reheapifying
        swim(size);
    }

    /**
     * 返回最大堆的最大元素
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 删除最大元素
     */
    public Key delMax() {
        Key max = pq[1];
        // 交换最后一个元素和第一个元素
        exchange(1, size);
        // 将最后一个元素删除
        pq[size] = null;
        // reheapifying
        sink(1);
        // 维护size
        size--;

        return max;
    }

    /**
     * 判断最大堆是否为空堆
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取最大堆的长度
     */
    public int size() {
        return size;
    }

    /**
     * 当插入一个新的结点时，需要调整最大堆的顺序，保证最大堆的性质(根结点比子结点大)
     * 该操作可以称为[上浮]，也叫堆有序化(reheapifying)
     *
     * @param k
     */
    private void swim(int k) {
        // 最大堆中，k结点的两个子结点的位置分别为2k 和 2k + 1，k的根结点则为 k / 2
        // 如果当前结点的根结点小于当前结点，交换其位置
        while (k > 1 && less(k / 2, k)) {
            // 当该结点的根结点小于该结点时，交换其位置
            exchange(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 当调用{@link #delMax()}方法时，最大元素将被删除，此时最大堆的特性可能会被破坏
     * 因此我们需要提升新的元素作为新的根结点
     * 操作过程：将最大元素和最后一个元素交换，然后移除掉最大元素，接着对最后一个元素执行下沉(sink)操作，即将元素放置到它应该存在的位置(reheapifying)
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                // 比较j元素和j + 1元素大小，j = 大的元素所在的位置
                j++;
            }
            if (less(k, j))
                // 如果k元素小于j元素，表示元素还可以下沉，交换两个元素的位置
                exchange(k, j);
            // 将k交换为j
            k = j;
        }
    }

    /**
     * 比较最大堆中的两个元素的大小
     *
     * @param i
     * @param j
     * @return 当pq[i] < pq[j]时返回true
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换最大堆中的两个元素
     *
     * @param i
     * @param j
     */
    private void exchange(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}
