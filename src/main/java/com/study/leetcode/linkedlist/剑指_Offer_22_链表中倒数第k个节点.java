package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 剑指_Offer_22_链表中倒数第k个节点 {

    /**
     * 解法：快慢指针，快指针先走k步，然后快慢指针同时移动，当快指针为尾节点时，
     * 也就是快指针.next == null时，此时慢指针所在的位置就是倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(5);
        ListNode next3 = new ListNode(7);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        ListNode kthFromEnd = getKthFromEnd(head, 2);
        ListNode.printLinkedList(kthFromEnd);
    }
}
