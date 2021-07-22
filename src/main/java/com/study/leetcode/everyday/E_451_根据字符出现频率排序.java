package com.study.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/3</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_451_根据字符出现频率排序 {

    /**
     * 优先队列
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxQueue = new PriorityQueue<>((c1, c2) -> {
            return map.get(c1) == map.get(c2) ? map.get(c1) - map.get(c2) : map.get(c2) - map.get(c1);
        });

        for (char c : map.keySet()) {
            maxQueue.offer(c);
        }

        StringBuilder ans = new StringBuilder();
        while (!maxQueue.isEmpty()) {
            char c = maxQueue.poll();
            int times = map.get(c);
            for (int i = 0; i < times; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

}
