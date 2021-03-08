package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/8 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 面试题_02_01_移除重复节点 {

    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(0);
        ListNode tmpDummy = dummyHead;
        ListNode tmp = head;
        while (tmp != null) {
            if (!set.contains(tmp.val)) {
                set.add(tmp.val);
                tmpDummy.next = new ListNode(tmp.val);
                tmpDummy = tmpDummy.next;
            }
            tmp = tmp.next;
        }

        return dummyHead.next;
    }

    public static ListNode removeDuplicateNodes2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmpDummy = dummyHead;
        ListNode tmp = head;

        while (tmp != null) {
            ListNode node = dummyHead.next;
            boolean flag = false;
            while (node != null) {
                if (node.val == tmp.val) {
                    flag = true;
                    break;
                }
                node = node.next;
            }
            if (!flag) {
                tmpDummy.next = new ListNode(tmp.val);
                tmpDummy = tmpDummy.next;
            }
            tmp = tmp.next;
        }

        return dummyHead.next;
    }

    /**
     * 双重循环：内循环以当前结点为起始位置，移除后面所有与当前结点值相等的节点
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes3(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            ListNode inner = tmp;
            while (inner.next != null) {
                if (inner.next.val == tmp.val) {
                    // 保留当前结点，将当前结点的next指针指向next.next
                    inner.next = inner.next.next;
                } else {
                    inner = inner.next;
                }
            }
            // 维护指针
            tmp = tmp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.buildLinkedList(new int[]{1, 1, 1, 2, 3});
        ListNode.printLinkedList(node);
        removeDuplicateNodes2(node);
    }
}
