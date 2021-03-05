package com.study.leetcode.sort;

import com.study.common.ListNode;

/**
 * 148. 排序链表 Onlogn
 * <p>
 * 递归排序链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class LeetCode148InRecursion {

    public static com.study.common.ListNode sort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 寻找链表中点

        // 快慢指针法寻找中点
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            // 链表还未遍历完毕
            // 慢指针每次走一步
            slow = slow.next;
            // 快指针每次走两步
            fast = fast.next.next;
        }

        // 当遍历结束后，慢指针应位于链表中点出，则慢指针.next应该是需要被归并的另一部分链表
        // 根据中点拆分当前链表为两部分
        ListNode right = slow.next;
        slow.next = null;

        // 对拆分后的链表执行排序和归并操作

        ListNode l = sort(head);
        ListNode r = sort(right);

        return merge(l, r);
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
        } else if (ListNode2 != null) {
            tmp.next = ListNode2;
        }

        return dummyHead.next;
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
