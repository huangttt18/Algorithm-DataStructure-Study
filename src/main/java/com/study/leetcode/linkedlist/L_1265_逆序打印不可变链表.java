package com.study.leetcode.linkedlist;

/**
 * 1265. 逆序打印不可变链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1265_逆序打印不可变链表 {

    public static void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null)
            return;

        printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    public static void main(String[] args) {

    }

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }
}
