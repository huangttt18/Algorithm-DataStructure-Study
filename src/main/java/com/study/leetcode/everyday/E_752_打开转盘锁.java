package com.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/25</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_752_打开转盘锁 {

    public static int openLock(String[] deadends, String target) {
        if ("0000".equals(target))
            return 0;

        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }

        // 如果deadends中包含初始值，那么返回-1，锁无法转动
        if (set.contains("0000"))
            return -1;

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> found = new HashSet<>();
        found.add("0000");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (String p : get(poll)) {
                    if (!set.contains(p) && !found.contains(p)) {
                        if (p.equals(target))
                            return step;
                        queue.offer(p);
                        found.add(p);
                    }
                }
            }
        }

        return -1;
    }

    /**
     * 针对当前给定的数字锁枚举出所有可能的下一个数字锁
     */
    static List<String> get(String s) {
        List<String> ret = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char cur = chars[i];
            chars[i] = next(cur);
            ret.add(new String(chars));
            chars[i] = prev(cur);
            ret.add(new String(chars));
            chars[i] = cur;
        }

        return ret;
    }

    static char next(char cur) {
        return cur == '9' ? '1' : (char) (cur + 1);
    }

    static char prev(char cur) {
        return cur == '0' ? '9' : (char) (cur - 1);
    }

    public static void main(String[] args) {

    }
}
