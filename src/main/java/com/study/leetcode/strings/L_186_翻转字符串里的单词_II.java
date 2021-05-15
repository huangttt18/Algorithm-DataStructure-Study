package com.study.leetcode.strings;

/**
 * 186. 翻转字符串里的单词 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/30 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_186_翻转字符串里的单词_II {

    public static void reverseWords(char[] s) {
        int first = 0;
        int last = s.length - 1;
        while (first < last) {
            char f;
            while ((f = s[first]) != ' ')
                first++;

            char l;
            while ((l = s[last]) != ' ')
                last--;



            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();
    }
}
