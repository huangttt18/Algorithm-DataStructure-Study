package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/11 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 剑指_Offer_18_删除链表的节点 {

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;
        ListNode l = head;
        while (l != null) {
            if (l.val != val) {
                tmp.next = new ListNode(l.val);
                tmp = tmp.next;
            }
            l = l.next;
        }

        return dummyHead.next;
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(4, 1, 5, 9);
        ListNode head1 = ListNode.buildLinkedList(-3, 5, -99);
        ListNode head2 = ListNode.buildLinkedList(4, 1, 5, 9);
        ListNode.printLinkedList(deleteNode(head, 1));
        ListNode.printLinkedList(deleteNode2(head1, -99));
        ListNode.printLinkedList(deleteNode2(head2, 5));
    }
}
