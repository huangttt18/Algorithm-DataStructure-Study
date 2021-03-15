package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 02.06. 回文链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/12 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 面试题_02_06_回文链表 {

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            if (list.get(lo) != list.get(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }

    /**
     * 解题思路：快慢指针断链 + 反转右边子链表，再遍历左右两个子链表进行比较
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断链 + 反转链表
        ListNode right = reverseListInRecursion(slow.next);
        slow.next = null;

        ListNode tmpLeft = head;
        ListNode tmpRight = right;

        boolean result = true;

        while (result && tmpRight != null) {
            if (tmpLeft.val != tmpRight.val) {
                return false;
            }
            tmpLeft = tmpLeft.next;
            tmpRight = tmpRight.next;
        }

        return result;
    }

    /**
     * 迭代反转链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    /**
     * 递归反转链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseListInRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverseListInRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(-127, -127);
//        ListNode head = ListNode.buildLinkedList(1, 2);
//        ListNode head = ListNode.buildLinkedList(1, 2, 2, 1);
//        ListNode head = null;
//        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));
    }
}
