package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/5 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_83_删除排序链表中的重复元素 {

    /**
     * [排序]链表：意味着相同的元素都会被连续排列，那么我们只需要取第一个即可
     * 1 -> 1 -> 2 -> 3 -> null
     * 1 == 1 ? 1 = 1.next => 2
     * 2 == 3 ? 2 = 2.next => 3
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val)
                // 此时当前结点等于next结点，保留当前结点
                // 当前结点.next指针往后移动
                cur.next = cur.next.next;
            // 此时当前结点不等于next结点
            // 当前结点往后移动
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.append(1);
        listNode.append(1);
        listNode.append(2);
        listNode.append(3);
        ListNode.printLinkedList(deleteDuplicates(listNode));
    }
}
