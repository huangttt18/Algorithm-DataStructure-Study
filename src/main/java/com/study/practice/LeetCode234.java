package com.study.practice;

/**
 * 234. 回文链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/21 </a>
 * @since <span>1.0</span>
 */
public class LeetCode234 {

    public static ListNode left;

    public static boolean traverse(ListNode right) {
        if (right == null)
            return true;
        boolean result = traverse(right.next);
        result = result && (left.val == right.val);
        left = left.next;
        return result;
    }

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(1);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        System.out.println(isPalindrome(head));
    }

    private static class ListNode {
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
