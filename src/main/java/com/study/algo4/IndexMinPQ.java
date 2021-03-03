package com.study.algo4;

/**
 * 索引优先队列(最小堆)
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class IndexMinPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int size;

    public IndexMinPQ(int capacity) {
        pq = (Item[]) new Comparable[capacity];
        size = 0;
    }

    /**
     * 插入一个元素，并和索引k关联
     *
     * @param k
     * @param item
     */
    public void insert(int k, Item item) {

    }

    /**
     * 将索引为k的元素设置为item
     *
     * @param k
     * @param item
     */
    public void change(int k, Item item) {

    }

    /**
     * 是否存在索引为k的元素
     *
     * @param k
     */
    public boolean contains(int k) {
        return false;
    }

    /**
     * 删除索引为k的元素及其相关联的元素
     *
     * @param k
     */
    public void delete(int k) {

    }

    /**
     * 返回最小元素
     */
    public Item min() {
        return null;
    }

    /**
     * 返回最小元素所在的索引
     */
    public int minIndex() {
        return 0;
    }

    /**
     * 删除最小元素并返回其索引
     */
    public int delMin() {
        return 0;
    }

    /**
     * 索引优先队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 索引优先队列的元素个数
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
        Item tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}
