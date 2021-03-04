package com.study.leetcode.strings;

/**
 * 1662. 检查两个字符串数组是否相等
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/3 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1662_检查两个字符串数组是否相等 {

    /**
     * 时间复杂度O(n)
     * @param word1
     * @param word2
     * @return
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1Len = word1.length, w2Len = word2.length;
        int i = 0, j = 0;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (i < w1Len && j < w2Len) {
            s1.append(word1[i++]);
            s2.append(word2[j++]);
        }

        if (i < w1Len)
            while (i < w1Len)
                s1.append(word1[i++]);
        else if (j < w2Len)
            while (j < w2Len)
                s2.append(word2[j++]);
        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "cb"}, word2 = {"ab", "c"};
        String[] word3 = {"abc", "d", "defg"}, word4 = {"abcddefg"};
        System.out.println(arrayStringsAreEqual(word1, word2));
        System.out.println(arrayStringsAreEqual(word3, word4));
    }
}
