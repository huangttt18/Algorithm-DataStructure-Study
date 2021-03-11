package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 160. 相交链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/11 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_160_相交链表 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }
        return tmpA;
    }

    public static void main(String[] args) {

    }
}
