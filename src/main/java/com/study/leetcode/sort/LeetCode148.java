package com.study.leetcode.sort;

import com.study.common.ListNode;

/**
 * 148. 排序链表
 * <p>
 * 在仅使用常数级额外空间的情况下对链表进行排序
 * <p>
 * 使用自底向上的归并排序思想
 * <p>
 * 比如对于链表 5 -> 2 -> 3 -> 1 -> 6 -> 4 -> null
 * <p>
 * 当步长 = 1时，遍历链表并交换所有互为一组的子链表
 * <p>
 * 2-5 | 1-3 | 4-6
 * <p>
 * 步长 = 步长 * 2
 * <p>
 * 步长 = 4
 * <p>
 * 1-2-3-5 | 4-6
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class LeetCode148 {

    public static ListNode sort(ListNode head) {
        if (head == null)
            return null;

        int length = length(head);

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        for (int size = 1; size < length; size *= 2) {
            ListNode pre = dummyHead;
            ListNode cur = dummyHead.next;

            while (cur != null) {
                // 拆分链表
                ListNode left = cur;
                ListNode right = cut(left, size);
                cur = cut(right, size);
                // 对拆分后的链表执行归并操作
                // 将归并后的链表接在原链表的后面
                pre.next = merge(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }

        return dummyHead.next;
    }

    /**
     * 断链：将链表根据传入size拆分为两部分，长度分别为size / length - size + 1
     *
     * @param ListNode
     * @param size
     * @return
     */
    public static ListNode cut(ListNode ListNode, int size) {
        if (ListNode == null)
            return null;

        ListNode head = ListNode;

        for (int i = 1; i < size && head.next != null; i++) {
            head = head.next;
        }

        ListNode ret = head.next;
        head.next = null;
        return ret;
    }

    /**
     * 归并链表：按照升序归并
     *
     * @param ListNode1
     * @param ListNode2
     * @return
     */
    private static ListNode merge(ListNode ListNode1, ListNode ListNode2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;

        while (ListNode1 != null && ListNode2 != null) {
            // 遍历两条链表并比较元素大小，然后执行合并操作
            if (ListNode1.val < ListNode2.val) {
                tmp.next = ListNode1;
                ListNode1 = ListNode1.next;
            } else {
                tmp.next = ListNode2;
                ListNode2 = ListNode2.next;
            }
            tmp = tmp.next;
        }

        if (ListNode1 != null) {
            tmp.next = ListNode1;
        }

        if (ListNode2 != null) {
            tmp.next = ListNode2;
        }

        return dummyHead.next;
    }

    public static int length(ListNode head) {
        if (head == null)
            return 0;

        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(1);
        ListNode next4 = new ListNode(6);
        ListNode next5 = new ListNode(4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;

        ListNode.printLinkedList(head);
        ListNode sort = sort(head);
        ListNode.printLinkedList(sort);
    }
}
