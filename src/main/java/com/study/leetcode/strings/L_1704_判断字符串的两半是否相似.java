package com.study.leetcode.strings;

import java.util.Arrays;
import java.util.List;

/**
 * 1704. 判断字符串的两半是否相似
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/9 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1704_判断字符串的两半是否相似 {

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public static boolean halvesAreAlike(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int vowelPre = 0, vowelNext = 0;
        int low = 0, high = s.length();
        while (low != high) {
            char lowChar = s.charAt(low++);
            char highChar = s.charAt(--high);
            if (vowels.contains(lowChar))
                vowelPre++;
            if (vowels.contains(highChar))
                vowelNext++;
        }
        return vowelPre == vowelNext;
    }

    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }
}
