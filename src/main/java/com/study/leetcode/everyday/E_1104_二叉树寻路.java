package com.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1104. 二叉树寻路
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/29</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1104_二叉树寻路 {

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        ans.add(label);
        // 计算出label所在层数
        int level = findLevel(label);
        level -= 2;
        // 二叉树中每个节点k的父节点 = k / 2
        while (level >= 0) {
            label /= 2;
            int newLabel = (1 << level) + (1 << level + 1) - 1 - label;
            ans.add(newLabel);
            label = newLabel;
            level--;
        }
        Collections.reverse(ans);
        return ans;
    }

    public static List<Integer> pathInZigZagTree2(int label) {
        List<Integer> ans = new ArrayList<>();
        while (label != 1) {
            ans.add(label);
            label >>= 1;
            label = label ^ (1 << lengthOfBit(label) - 1) - 1;
            System.out.println(label);
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

    private static int lengthOfBit(int label) {
        int length = 1;
        while ((1 << length) <= label) {
            length++;
        }
        return length;
    }

    private static int findLevel(int label) {
        int level = 0;
        while (label != 0) {
            level++;
            label >>= 1;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(26));
        System.out.println(pathInZigZagTree(14));
        System.out.println(pathInZigZagTree2(14));
        System.out.println(lengthOfBit(14));
    }
}
