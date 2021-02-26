package com.study.practice;

import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/21 </a>
 * @since <span>1.0</span>
 */
public class ReverseLinkedList {

    static ListNode successor = null;

    /**
     * 双指针法
     */
    static ListNode reverseInLoop(ListNode node) {
        if (node == null)
            return node;
        ListNode head = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }

    static ListNode reverseNInLoop(ListNode node, int n) {
        if (node == null)
            return node;
        ListNode head = null;
        ListNode reverse = node;
        ListNode cur = node;
        for (int i = 0; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        reverse.next = cur;
        return head;
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode reverseN(ListNode head, int n) {
        if (head == null)
            return head;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return head;
        if (left == 1)
            return reverseN(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
        ListNode reversed = reverse(head);
//        ListNode reversed = reverseN(head, 2);
//        ListNode reversed = reverseInLoop(head);
//        ListNode reversed = reverseNInLoop(head, 2);
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
