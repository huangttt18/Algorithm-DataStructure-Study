package com.study.leetcode.linkedlist;

import com.study.common.ListNode;
import com.study.common.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/28 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class 剑指_Offer_06_从尾到头打印链表 {

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] ans = new int[list.size()];
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans[index++] = list.get(i);
        }

        return ans;
    }

    static List<Integer> list = new ArrayList<>();

    public static int[] reversePrint2(ListNode head) {
        reverse(head);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public static void reverse(ListNode head) {
        if (head == null)
            return;

        reverse(head.next);
        list.add(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(5);
        ListNode next3 = new ListNode(7);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;

        CommonUtils.printArray(reversePrint(head));
        CommonUtils.printArray(reversePrint2(head));
    }
}
