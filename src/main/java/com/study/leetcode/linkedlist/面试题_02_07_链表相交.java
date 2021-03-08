package com.study.leetcode.linkedlist;

import com.study.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.07. 链表相交
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/8 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 面试题_02_07_链表相交 {

    /**
     * 双指针解法：两条链表相交，也就是链表中有相同结点(引用)
     * 只要利用双指针不断的遍历两条链表，直到他们相等即可
     * 会有两种情况：
     *      1. 两条链表长度一致：
     *          在这种情况下，我们只需要每次都将指向两条链表的指针往后移动直到他们有一个结点相等即可
     *      2. 两条链表长度不一致：
     *          在这种情况下，假设链表A短，链表B长，那么在移动指针的过程中，如果链表A已经到结尾还没有找到和链表B相交的结点时
     *              此时需要将指针重新指向链表B，再继续移动指针，只要链表有相交的结点，那么总会移动到两条链表相等的时候
     *              同理，当链表B的指针到了结尾还没有找到和链表A中相交的结点，那么就将链表B的指针指向链表A，再继续移动即可
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA, tmpB = headB;

        while (tmpA != tmpB) {
            if (tmpA == null)
                tmpA = headB;
            else
                tmpA = tmpA.next;
            if (tmpB == null)
                tmpB = headA;
            else
                tmpB = tmpB.next;
        }
        return tmpA;
    }

    /**
     * 哈希表解法：假设有链表A、链表B
     *  先遍历一条链表，将该链表中的所有结点都存入哈希表中，接着遍历另一条链表，如果有相等的结点存在于哈希表中，则表示两条链表有相交的结点
     *
     * 注意：不能改变原链表结构
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmpA = headA;
        while (tmpA != null) {
            set.add(tmpA);
            tmpA = tmpA.next;
        }

        ListNode tmpB = headB;
        while (tmpB != null) {
            if (set.contains(tmpB))
                return tmpB;
            tmpB = tmpB.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
