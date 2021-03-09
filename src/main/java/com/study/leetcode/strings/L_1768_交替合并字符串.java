package com.study.leetcode.strings;

/**
 * 1768. 交替合并字符串
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/9 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1768_交替合并字符串 {

    /**
     * 双指针解法
     *
     * @param word1
     * @param word2
     * @return
     */
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int w1 = 0, w2 = 0;
        while (w1 < word1.length() && w2 < word2.length()) {
            res.append(word1.charAt(w1));
            res.append(word2.charAt(w2));
            w1++;
            w2++;
        }

        if (w1 < word1.length()) {
            res.append(word1.substring(w1));
        }

        if (w2 < word2.length()) {
            res.append(word2.substring(w2));
        }

        return res.toString();
    }

    public static void main(String[] args) {
//        String word1 = "abc", word2 = "pqr";
//        String word1 = "ab", word2 = "pqrs";
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }
}
