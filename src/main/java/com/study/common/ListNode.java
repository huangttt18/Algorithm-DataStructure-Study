package com.study.common;

/**
 * TODO
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
}
