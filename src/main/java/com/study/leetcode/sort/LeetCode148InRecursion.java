package com.study.leetcode.sort;

/**
 * 148. 排序链表 Onlogn
 *
 * 递归排序链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/25 </a>
 * @since <span>1.0</span>
 */
public class LeetCode148InRecursion {

    public static Node sort(Node head) {
        if (head == null || head.next == null)
            return head;

        // 寻找链表中点

        // 快慢指针法寻找中点
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            // 链表还未遍历完毕
            // 慢指针每次走一步
            slow = slow.next;
            // 快指针每次走两步
            fast = fast.next.next;
        }

        // 当遍历结束后，慢指针应位于链表中点出，则慢指针.next应该是需要被归并的另一部分链表
        // 根据中点拆分当前链表为两部分
        Node right = slow.next;
        slow.next = null;

        // 对拆分后的链表执行排序和归并操作

        Node l = sort(head);
        Node r = sort(right);

        return merge(l, r);
    }

    /**
     * 归并链表：按照升序归并
     * @param node1
     * @param node2
     * @return
     */
    private static Node merge(Node node1, Node node2) {
        Node dummyHead = new Node(0);
        Node tmp = dummyHead;

        while (node1 != null && node2 != null) {
            // 遍历两条链表并比较元素大小，然后执行合并操作
            if (node1.val < node2.val) {
                tmp.next = node1;
                node1 = node1.next;
            } else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }

        if (node1 != null) {
            tmp.next = node1;
        } else if (node2 != null) {
            tmp.next = node2;
        }

        return dummyHead.next;
    }

    public static void printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        sb.append(" -> ");
        Node traverseHead = head.next;
        while (traverseHead != null) {
            sb.append(traverseHead.val);
            sb.append(" -> ");
            traverseHead = traverseHead.next;
        }

        sb.append("null\n");

        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        Node next1 = new Node(2);
        Node next2 = new Node(3);
        Node next3 = new Node(1);
        Node next4 = new Node(6);
        Node next5 = new Node(4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;

        printLinkedList(head);
        Node sort = sort(head);
        printLinkedList(sort);
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
