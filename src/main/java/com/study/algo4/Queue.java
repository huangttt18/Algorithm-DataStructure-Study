package com.study.algo4;

/**
 * 链表实现队列
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class Queue {

    private Node head;
    private Node tail;
    private int size;

    Queue() {
    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public void enqueue(int val) {
        Node newTail = new Node(val);
        if (isEmpty()) {
            head = tail = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            return 0xFFFFFFFF;
        }
        Node oldHead = head;
        int ret = oldHead.val;
        head = head.next;
        // help gc!
        oldHead.next = null;
        size--;
        return ret;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void traverse() {
        Node traverseHead = head;
        while (traverseHead != null) {
            System.out.print(traverseHead.val);
            System.out.print(" -> ");
            traverseHead = traverseHead.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.traverse();
        queue.dequeue();
        queue.traverse();
    }
}
