package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 剑指_Offer_24_反转链表 {

    public static ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }

        return dummyHead.next;
    }

    /**
     * 双指针法
     * pre指向dummyHead
     * cur指向head
     * 两个指针同时往前移动，cur.next = pre
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode last = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(5);
        ListNode next3 = new ListNode(7);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;

//        ListNode.printLinkedList(reverseList(head));
//        ListNode.printLinkedList(reverseList2(head));
        ListNode.printLinkedList(reverseList3(head));
    }
}
