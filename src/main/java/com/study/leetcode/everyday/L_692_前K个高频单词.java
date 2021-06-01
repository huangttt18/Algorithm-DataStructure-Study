package com.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. 前K个高频单词
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/5/20</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_692_前K个高频单词 {

    /**
     * 哈希表
     */
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));

        map.forEach((key, v) -> ans.add(key));

        ans.sort((s1, s2) -> map.get(s1) == map.get(s2) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));

        return ans.subList(0, k);
    }

    public static List<String> topKFrequent2(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));

        PriorityQueue<String> heap = new PriorityQueue<>((s1, s2) -> map.get(s1) == map.get(s2) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));

        map.keySet().forEach(key -> {
            heap.offer(key);
            if (heap.size() > k)
                heap.poll();
        });

        while (heap.size() > 0) {
            ans.add(heap.poll());
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent2(words, k));
    }

}
