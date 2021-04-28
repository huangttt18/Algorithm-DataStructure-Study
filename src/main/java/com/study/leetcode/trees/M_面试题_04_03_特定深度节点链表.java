package com.study.leetcode.trees;

import com.study.common.ListNode;
import com.study.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class M_面试题_04_03_特定深度节点链表 {

    public static ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            ListNode dummy = new ListNode(-1);
            ListNode tmp = dummy;
            // 重点：必须要将size计算出来，不能在循环内计算
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tree = queue.poll();
                tmp.next = new ListNode(tree.val);
                tmp = tmp.next;
                if (tree.left != null)
                    queue.offer(tree.left);
                if (tree.right != null)
                    queue.offer(tree.right);
            }
            list.add(dummy.next);
        }
        ListNode[] ans = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
