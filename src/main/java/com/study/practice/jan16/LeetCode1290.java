package com.study.practice.jan16;

/**
 * 二进制链表转整数
 *
 * @author Daniel 2020/1/16
 */
public class LeetCode1290 {

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            int value = head.val;
            sb.append(value);
            head = head.next;
        }

        return bin2d(sb.toString());
    }

    public static int bin2d(String binaryValue) {
        char[] charArray = binaryValue.toCharArray();
        int num = 0;
        int powNum = 0;
        for (int i = 0; i < charArray.length; i++) {
            powNum = charArray.length - 1 - i;
            int current = charArray[i] == '1' ? 1 : 0;
            num += (current * Math.pow(2, powNum));
        }
        return num;
    }

    public static void main(String[] args) {
        // 1,0,0,1,0,0,1,1,1,0,0,0,0,0,0
        ListNode root = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(0);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(1);
        ListNode node9 = new ListNode(1);
        ListNode node10 = new ListNode(0);
        ListNode node11 = new ListNode(0);
        ListNode node12 = new ListNode(0);
        ListNode node13 = new ListNode(0);
        ListNode node14 = new ListNode(0);
        ListNode node15 = new ListNode(0);
        root.next = second;
        second.next = third;
        third.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        System.out.println(getDecimalValue(root));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
