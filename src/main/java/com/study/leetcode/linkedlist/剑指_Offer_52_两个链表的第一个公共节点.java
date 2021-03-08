package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/8 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 剑指_Offer_52_两个链表的第一个公共节点 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA, tmpB = headB;

        while (tmpA != tmpB) {
            if (tmpA == null)
                tmpA = headB;
            else
                tmpA = tmpA.next;
            if (tmpB == null)
                tmpB = headA;
            else
                tmpB = tmpB.next;
        }
        return tmpA;
    }

    public static void main(String[] args) {

    }
}
