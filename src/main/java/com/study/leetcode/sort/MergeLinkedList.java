package com.study.leetcode.sort;

import com.study.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个有序链表，要求不改变原链表的结构
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class MergeLinkedList {

    public static ListNode merge(com.study.common.ListNode ListNode1, ListNode ListNode2) {
        if (ListNode1 == null) {
            return ListNode2;
        }

        if (ListNode2 == null) {
            return ListNode1;
        }

        List<Integer> list = new ArrayList<>();
        ListNode tmp = ListNode1;
        ListNode tmp2 = ListNode2;
        while (tmp != null && tmp2 != null) {
            if (tmp.val <= tmp2.val) {
                list.add(tmp.val);
                tmp = tmp.next;
            } else {
                list.add(tmp2.val);
                tmp2 = tmp2.next;
            }
        }

        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        while (tmp2 != null) {
            list.add(tmp2.val);
            tmp2 = tmp2.next;
        }

        ListNode newListNode = new ListNode(list.get(0));
        ListNode temp = newListNode;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }

        ListNode.printLinkedList(ListNode1);
        ListNode.printLinkedList(ListNode2);

        return newListNode;
    }

    /**
     * 不破坏原链表结构的情况下合并两条链表
     */
    public static ListNode merge2(ListNode ListNode1, ListNode ListNode2) {
        if (ListNode1 == null) {
            return ListNode2;
        }

        if (ListNode2 == null) {
            return ListNode1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;

        ListNode tempListNode1 = ListNode1;
        ListNode tempListNode2 = ListNode2;

        while (tempListNode1 != null && tempListNode2 != null) {
            if (tempListNode1.val <= tempListNode2.val) {
                tmp.next = new ListNode(tempListNode1.val);
                tempListNode1 = tempListNode1.next;
            } else {
                tmp.next = new ListNode(tempListNode2.val);
                tempListNode2 = tempListNode2.next;
            }
            tmp = tmp.next;
        }

        if (tempListNode1 != null) {
            tmp.next = tempListNode1;
        } else {
            tmp.next = tempListNode2;
        }

        ListNode.printLinkedList(ListNode1);
        ListNode.printLinkedList(ListNode2);

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(5);

        ListNode next3 = new ListNode(1);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(6);
        head.next = next1;
        next1.next = next2;

        next3.next = next4;
        next4.next = next5;

        ListNode.printLinkedList(head);
        ListNode merged = merge2(head, next3);
        ListNode.printLinkedList(merged);
    }
}
