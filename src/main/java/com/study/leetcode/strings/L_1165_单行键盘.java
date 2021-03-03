package com.study.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 1165. 单行键盘
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/2 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1165_单行键盘 {

    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int steps = 0;
        char lastChar = keyboard.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            steps += Math.abs(map.get(cur) - map.get(lastChar));
            lastChar = cur;
        }

        return steps;
    }

    public static void main(String[] args) {
//        String keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba";
        String keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode";
        System.out.println(calculateTime(keyboard, word));
    }
}
