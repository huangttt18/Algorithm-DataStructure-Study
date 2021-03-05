package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

import java.util.*;

/**
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * <p>
 * 示例1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/5 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_82_删除排序链表中的重复元素II {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmpDummy = dummyHead;
        Map<Integer, Integer> tmpMap = new HashMap<>();
        List<Integer> tmpList = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            if (tmpMap.get(val) == null)
                tmpMap.put(val, 1);
            else
                tmpMap.put(val, tmpMap.get(val) + 1);
            head = head.next;
        }

        for (Integer i : tmpMap.keySet()) {
            if (tmpMap.get(i) == 1)
                tmpList.add(i);
        }

        Collections.sort(tmpList);

        for (Integer i : tmpList) {
            tmpDummy.next = new ListNode(i);
            tmpDummy = tmpDummy.next;
        }

        return dummyHead.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (pre.next.val != cur.next.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                while (cur != null && cur.next != null && pre.next.val == cur.next.val)
                    cur = cur.next;
                pre.next = cur.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3};
        ListNode head = ListNode.buildLinkedList(arr);
        ListNode.printLinkedList(deleteDuplicates2(head));
    }
}
