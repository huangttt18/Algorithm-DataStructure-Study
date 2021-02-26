package com.study.practice;

/**
 * 25.K个一组翻转链表（困难）
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/21 </a>
 * @since <span>1.0</span>
 */
public class LeetCode25 {

    /**
     * 翻转[head, right)节点所在的链表
     */
    static ListNode reverse(ListNode head, ListNode right) {
        if (head == null)
            return head;
        ListNode dummyHead = null;
        ListNode cur = head;
        while (cur != right) {
            ListNode temp = cur.next;
            cur.next = dummyHead;
            dummyHead = cur;
            cur = temp;
        }
        return dummyHead;
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            if (right == null)
                return head;
            right = right.next;
        }

        ListNode newHead = reverse(left, right);
        left.next = reverseKGroup(right, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
//        ListNode reversed = reverse(head, next2);
        ListNode reversed = reverseKGroup(head, 3);
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
