package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 86. 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/5 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_86_分隔链表 {

    /**
     * 快排分区解法
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode minDummyHead = new ListNode(0);
        ListNode minTmp = minDummyHead;
        ListNode maxDummyHead = new ListNode(0);
        ListNode maxTmp = maxDummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                minTmp.next = new ListNode(cur.val);
                minTmp = minTmp.next;
            } else {
                maxTmp.next = new ListNode(cur.val);
                maxTmp = maxTmp.next;
            }
            cur = cur.next;
        }

        minTmp.next = maxDummyHead.next;

        return minDummyHead.next;
    }

    public static void main(String[] args) {

    }
}
