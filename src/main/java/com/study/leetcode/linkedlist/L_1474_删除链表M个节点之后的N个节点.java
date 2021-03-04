package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 1474. 删除链表 M 个节点之后的 N 个节点
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/4 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1474_删除链表M个节点之后的N个节点 {

    /**
     * 暴力解法：
     *      遍历链表头，直到链表头为null
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;
        while (head != null) {
            int tempM = m;
            int tempN = n;
            while (tempM-- > 0 && head != null) {
                // 注意：这里不能直接让tmp.next = head
                // 否则下一轮操作tmp时其实就是在操作head
                tmp.next = new ListNode(head.val);
                head = head.next;
                tmp = tmp.next;
            }

            while (tempN-- > 0 && head != null) {
                head = head.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        ListNode next5 = new ListNode(6);
        ListNode next6 = new ListNode(7);
        ListNode next7 = new ListNode(8);
        ListNode next8 = new ListNode(9);
        ListNode next9 = new ListNode(10);
        ListNode next10 = new ListNode(11);
        ListNode next11 = new ListNode(12);
        ListNode next12 = new ListNode(13);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = next6;
        next6.next = next7;
        next7.next = next8;
        next8.next = next9;
        next9.next = next10;
        next10.next = next11;
        next11.next = next12;
        ListNode.printLinkedList(deleteNodes(head, 2, 3));
    }
}
