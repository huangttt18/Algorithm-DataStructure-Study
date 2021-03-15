package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

/**
 * 1669. 合并两个链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/12 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1669_合并两个链表 {

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode tmpList1 = list1;
        // 这里必须让index在循环体内自增，保证在第二次遍历时索引位置是正确的
        // 遍历到a - 1，保证下一次遍历时从需要被移除的节点开始遍历
        while (index < a - 1 && tmpList1 != null) {
            tmpList1 = tmpList1.next;
            index++;
        }

        // index == a
        // 断链
        // 这里只需要让下一次被遍历的链表等于tmpList1即可，因为上面保证了tmpList1的头结点是需要被移除的结点
        ListNode list1Right = tmpList1;

        // 遍历右子链表
        ListNode tmpList1Right = list1Right;
        // 这里index可以直接++，因为index在后面用不到了
        while (index++ < b && tmpList1Right != null) {
            tmpList1Right = tmpList1Right.next;
        }

        // index == b
        // 这里遍历list2，目的是获得list2的尾结点
        ListNode tmpList2 = list2;
        while (tmpList2.next != null) {
            tmpList2 = tmpList2.next;
        }
        // 断链
        tmpList2.next = tmpList1Right.next;
        // 接入新的链表list2到list1链表的next结点
        tmpList1.next = list2;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.buildLinkedList(0, 1, 2, 3, 4, 5, 6);
//        ListNode list1 = ListNode.buildLinkedList(0, 1, 2, 3, 4, 5);
        ListNode list2 = ListNode.buildLinkedList(10000, 10001, 10002, 10003, 10004);
//        ListNode list2 = ListNode.buildLinkedList(10000, 10001, 10002);
        ListNode.printLinkedList(mergeInBetween(list1, 2, 5, list2));
//        ListNode.printLinkedList(mergeInBetween(list1, 3, 4, list2));
    }
}
