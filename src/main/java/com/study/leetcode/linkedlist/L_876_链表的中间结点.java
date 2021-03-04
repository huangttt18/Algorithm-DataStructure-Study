package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 876. 链表的中间结点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/4 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_876_链表的中间结点 {

    /**
     * 双指针法
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // 满足条件fast == null表示当前链表结点数为偶数
        // 满足条件fast.next == null表示当前链表结点数为奇数
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
//        ListNode next5 = new ListNode(6);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
//        next4.next = next5;
        ListNode.printLinkedList(middleNode(head));
    }
}
