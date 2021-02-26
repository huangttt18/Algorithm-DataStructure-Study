package com.study.leetcode.sort;

/**
 * 148. 排序链表
 *
 * 在仅使用常数级额外空间的情况下对链表进行排序
 *
 * 使用自底向上的归并排序思想
 *
 * 比如对于链表 5 -> 2 -> 3 -> 1 -> 6 -> 4 -> null
 *
 * 当步长 = 1时，遍历链表并交换所有互为一组的子链表
 *
 * 2-5 | 1-3 | 4-6
 *
 * 步长 = 步长 * 2
 *
 * 步长 = 4
 *
 * 1-2-3-5 | 4-6
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
public class LeetCode148 {

    public static Node sort(Node head) {
        if (head == null)
            return null;

        int length = length(head);

        Node dummyHead = new Node(0);
        dummyHead.next = head;

        for (int size = 1; size < length; size *= 2) {
            Node pre = dummyHead;
            Node cur = dummyHead.next;

            while (cur != null) {
                // 拆分链表
                Node left = cur;
                Node right = cut(left, size);
                cur = cut(right, size);
                // 对拆分后的链表执行归并操作
                // 将归并后的链表接在原链表的后面
                pre.next = merge(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }

        return dummyHead.next;
    }

    /**
     * 断链：将链表根据传入size拆分为两部分，长度分别为size / length - size + 1
     * @param node
     * @param size
     * @return
     */
    public static Node cut(Node node, int size) {
        if (node == null)
            return null;

        Node head = node;

        for (int i = 1; i < size && head.next != null; i++) {
            head = head.next;
        }

        Node ret = head.next;
        head.next = null;
        return ret;
    }

    /**
     * 归并链表：按照升序归并
     * @param node1
     * @param node2
     * @return
     */
    private static Node merge(Node node1, Node node2) {
        Node dummyHead = new Node(0);
        Node tmp = dummyHead;

        while (node1 != null && node2 != null) {
            // 遍历两条链表并比较元素大小，然后执行合并操作
            if (node1.val < node2.val) {
                tmp.next = node1;
                node1 = node1.next;
            } else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }

        if (node1 != null) {
            tmp.next = node1;
        }

        if (node2 != null) {
            tmp.next = node2;
        }

        return dummyHead.next;
    }

    public static int length(Node head) {
        if (head == null)
            return 0;

        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public static void printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        sb.append(" -> ");
        Node traverseHead = head.next;
        while (traverseHead != null) {
            sb.append(traverseHead.val);
            sb.append(" -> ");
            traverseHead = traverseHead.next;
        }

        sb.append("null\n");

        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        Node next1 = new Node(2);
        Node next2 = new Node(3);
        Node next3 = new Node(1);
        Node next4 = new Node(6);
        Node next5 = new Node(4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;

        printLinkedList(head);
        Node sort = sort(head);
        printLinkedList(sort);
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
