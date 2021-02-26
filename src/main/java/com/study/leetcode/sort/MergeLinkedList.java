package com.study.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个有序链表，要求不改变原链表的结构
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class MergeLinkedList {

    public static Node merge(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        List<Integer> list = new ArrayList<>();
        Node tmp = node1;
        Node tmp2 = node2;
        while (tmp != null && tmp2 != null) {
            if (tmp.val <= tmp2.val) {
                list.add(tmp.val);
                tmp = tmp.next;
            } else {
                list.add(tmp2.val);
                tmp2 = tmp2.next;
            }
        }

        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        while (tmp2 != null) {
            list.add(tmp2.val);
            tmp2 = tmp2.next;
        }

        Node newNode = new Node(list.get(0));
        Node temp = newNode;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new Node(list.get(i));
            temp = temp.next;
        }

        printLinkedList(node1);
        printLinkedList(node2);

        return newNode;
    }

    /**
     * 不破坏原链表结构的情况下合并两条链表
     */
    public static Node merge2(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        Node dummyHead = new Node(0);
        Node tmp = dummyHead;

        Node tempNode1 = node1;
        Node tempNode2 = node2;

        while (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.val <= tempNode2.val) {
                tmp.next = new Node(tempNode1.val);
                tempNode1 = tempNode1.next;
            } else {
                tmp.next = new Node(tempNode2.val);
                tempNode2 = tempNode2.next;
            }
            tmp = tmp.next;
        }

        if (tempNode1 != null) {
            tmp.next = tempNode1;
        } else {
            tmp.next = tempNode2;
        }

        printLinkedList(node1);
        printLinkedList(node2);

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node next1 = new Node(3);
        Node next2 = new Node(5);

        Node next3 = new Node(1);
        Node next4 = new Node(4);
        Node next5 = new Node(6);
        head.next = next1;
        next1.next = next2;

        next3.next = next4;
        next4.next = next5;

        printLinkedList(head);
        Node merged = merge2(head, next3);
        printLinkedList(merged);
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
