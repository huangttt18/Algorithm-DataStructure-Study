package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * //实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：单向链表a->b->c->d->e->f中的节点c
 * //结果：不返回任何数据，但该链表变为a->b->d->e->f
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 面试题0203删除中间节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(5);
        ListNode next3 = new ListNode(7);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        deleteNode(next1);
        ListNode.printLinkedList(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
