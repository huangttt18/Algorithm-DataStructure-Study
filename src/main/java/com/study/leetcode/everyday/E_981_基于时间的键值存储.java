package com.study.leetcode.everyday;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 981. 基于时间的键值存储
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/10</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_981_基于时间的键值存储 {

    static class TimeMap {

        final String DEFAULT_RETURN_VALUE = "";

        Map<String, List<String>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            // key = key
            // value = value + "," + timestamp
            String inValue = value + "," + timestamp;
            List<String> vals = map.getOrDefault(key, new ArrayList<>());
            vals.add(inValue);
            map.putIfAbsent(key, vals);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                List<String> vals = map.get(key);
                int maxIndex = -1;
                int max = -1;
                for (int i = 0; i < vals.size(); i++) {
                    String[] split = vals.get(i).split(",");
                    int ts = Integer.parseInt(split[1]);
                    if (ts <= timestamp && ts > max) {
                        maxIndex = i;
                        max = ts;
                    }
                }
                if (maxIndex != -1) {
                    return vals.get(maxIndex).split(",")[0];
                }
            }
            return DEFAULT_RETURN_VALUE;
        }
    }

    static class TimeMap2 {

        final String DEFAULT_RETURN_VALUE = "";

        Map<String, List<Node>> map;

        /** Initialize your data structure here. */
        public TimeMap2() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Node> vals = map.getOrDefault(key, new ArrayList<>());
            vals.add(new Node(key, value, timestamp));
            map.putIfAbsent(key, vals);
        }

        public String get(String key, int timestamp) {
            // 由题意得timestamp是严格递增的
            // 因此可以对vals采用二分查找的方式来查找到对应的值
            if (map.containsKey(key)) {
                List<Node> vals = map.get(key);
                int l = 0, r = vals.size() - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (vals.get(mid).timestamp <= timestamp) {
                        // 此时mid满足条件，所以不需要跳过mid
                        l = mid;
                    } else {
                        // 此时mid不满足条件，此时应该跳过mid
                        r = mid - 1;
                    }
                }
                return vals.get(r).timestamp <= timestamp ? vals.get(r).value : DEFAULT_RETURN_VALUE;
            }
            return DEFAULT_RETURN_VALUE;
        }

        class Node {
            String key;
            String value;
            int timestamp;

            public Node(String key, String value, int timestamp) {
                this.key = key;
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }

    public static void main(String[] args) {
        String key = "foo";
        String value = "bar";
        int timestamp = 1;
        TimeMap2 timeMap = new TimeMap2();
        timeMap.set(key, value, timestamp);
        value = "bar";
        timestamp = 2;
        timeMap.set(key, value, timestamp);
        value = "bar2";
        timestamp = 4;
        timeMap.set(key, value, timestamp);
        value = "bar2";
        timestamp = 5;
        timeMap.set(key, value, timestamp);
        System.out.println(timeMap.get(key, 5));

        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        queue.offer(1);
        queue.offer(3);
        queue.offer(4);
        queue.offer(2);
        queue.offer(5);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
