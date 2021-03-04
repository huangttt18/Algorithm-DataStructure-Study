package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 206. 反转链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/4 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_206_反转链表 {

    /**
     * 递归解法：递归到底，再依次连接
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 迭代解法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode tmp = curNode.next;
            curNode.next = newHead;
            newHead = curNode;
            curNode = tmp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        ListNode next5 = new ListNode(6);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        ListNode.printLinkedList(reverseList1(head));
    }
}
