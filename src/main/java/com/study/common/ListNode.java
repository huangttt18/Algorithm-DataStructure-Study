package com.study.common;

/**
 * 链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/28 </a>
 * @since <span>1.0</span>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public void append(int x) {
        ListNode tmp = this;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = new ListNode(x);
    }

    public static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        sb.append(" -> ");
        ListNode traverseHead = head.next;
        while (traverseHead != null) {
            sb.append(traverseHead.val);
            sb.append(" -> ");
            traverseHead = traverseHead.next;
        }

        sb.append("null\n");

        System.out.println(sb.toString());
    }

    public static ListNode buildLinkedList(int size) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        for (int i = 0; i < size; i++) {
            head.next = new ListNode(i + 1);
            head = head.next;
        }
        return dummyHead.next;
    }

    public static ListNode buildLinkedList(int... arr) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return dummyHead.next;
    }
}
