package com.study.leetcode.everyday;

import com.study.common.ListNode;

/**
 * 92. 反转链表 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/18 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_92_反转链表II {

    /**
     * 拿到头链表，反转后的中间链表，尾链表，然后拼接
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
        // 如果left == 1，那么表示要反转的链表为头结点到right索引所在的结点
            return reverseN(head, right);
        }
        // 头链表为head
        ListNode tmpHead = head;
        int index = 1;
        while (index++ < left && tmpHead != null) {
            tmpHead = tmpHead.next;
        }

        // 常规的反转链表
        // pre就是反转后的链表
        ListNode pre = null;
        ListNode cur = tmpHead;
        // 需要记录后继结点，后面需要拼接
        ListNode successor = null;
        index = left;
        while (index++ <= right && cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
            successor = tempNext;
        }
        // 拼接链表
        ListNode tmpPre = pre;
        while (tmpPre.next != null) {
            tmpPre = tmpPre.next;
        }
        tmpPre.next = successor;

        ListNode t = head;
        index = 1;
        while (++index < left) {
            t = t.next;
        }
        t.next = pre;

        return head;
    }

    private static ListNode reverseN(ListNode head, int right) {
        int index = 1;
        ListNode pre = null;
        ListNode cur = head;
        ListNode successor = null;
        while (index++ <= right && cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
            successor = tempNext;
        }

        ListNode temp = pre;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = successor;

        return pre;
    }

    /**
     * // 思路：head表示需要反转的头节点，pre表示需要反转头节点的前驱节点
     * // 我们需要反转n-m次，我们将head的next节点移动到需要反转链表部分的首部，需要反转链表部分剩余节点依旧保持相对顺序即可
     * // 比如1->2->3->4->5,m=1,n=5
     * // 第一次反转：1(head) 2(next) 3 4 5 反转为 2 1 3 4 5
     * // 第二次反转：2 1(head) 3(next) 4 5 反转为 3 2 1 4 5
     * // 第三次发转：3 2 1(head) 4(next) 5 反转为 4 3 2 1 5
     * // 第四次反转：4 3 2 1(head) 5(next) 反转为 5 4 3 2 1
     *     ListNode* reverseBetween(ListNode* head, int m, int n) {
     *         ListNode *dummy = new ListNode(-1);
     *         dummy->next = head;
     *         ListNode *pre = dummy;
     *         for (int i = 1; i < m; ++i)
     *             pre = pre->next;
     *
     *         // 找到要反转的链表的头结点
     *         head = pre->next;
     *         for (int i = m; i < n; ++i){
     *         // 2
     *             ListNode *tempHeadNext = head->next;
     *
     *         // head节点连接tempHeadNext节点之后链表部分，也就是向后移动一位
     *         // 2.next = 2.next = 3
     *             head->next = tempHeadNext->next;
     *
     *         // tempHeadNext节点移动到需要反转链表部分的首部
     *         // 2.next = 1
     *             tempHeadNext->next = pre->next;
     *
     *         // pre继续为需要反转头节点的前驱节点
     *         // pre.next =
     *             pre->next = tempHeadNext;
     *         }
     *         return dummy->next;
     *     }
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        // 找到要反转的链表的头结点
        int index = 1;
        while (index++ < left) {
            pre = pre.next;
        }
        head = pre.next;

        // 反转链表
        for (int i = left; i < right; i++) {
            ListNode tempHeadNext = head.next;
            head.next = tempHeadNext.next;
            tempHeadNext.next = pre.next;
            pre.next = tempHeadNext;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.buildLinkedList(1, 2, 3, 4, 5);
        ListNode.printLinkedList(reverseBetween2(node, 1, 5));
    }
}
