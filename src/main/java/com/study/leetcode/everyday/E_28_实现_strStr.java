package com.study.leetcode.everyday;

/**
 * 28. 实现 strStr()
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/20 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_28_实现_strStr {

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * 当 needle 是空字符串时我们应当返回 0
     */
    public static int strStr2(String haystack, String needle) {
        if (needle == null || "".equals(needle))
            return 0;

        int hLen = haystack.length();
        int nLen = needle.length();
        // 最多遍历这么多次，保证haystack剩余的长度大于等于needle，如果超过该次数则haystack长度小于needle
        // 如果hLen < nLen，那么直接不会走循环，所以考虑到了haystack比needle短的情况
        int maxReverseCount = hLen - nLen;

        int n = 0;
        char first = needle.charAt(n);
        for (int i = 0; i <= maxReverseCount; i++) {
            if (haystack.charAt(i) != first)
                // 找到第一个等于first的位置
                while (++i <= maxReverseCount && haystack.charAt(i) != first);
            if (i <= maxReverseCount) {
                // 此时表示字符串还没有遍历完成并且当前遍历到的字符等于needle的第一个字符
                // haystack起始位置，i已经被检查过了
                int k = i + 1;
                // 遍历终止位置，因为此时已经遍历了一个元素，所以终止位置等于k + nLen，并且由于索引从0开始，所以end = k + nLen - 1
                int end = k + nLen - 1;
                // j => needle遍历起始位置, n已经被检查过了
                for (int j = n + 1; k < end && haystack.charAt(k) == needle.charAt(j); j++, k++);
                if (k == end)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "", needle = "1";
        String haystack = "abc", needle = "bc";
        System.out.println(strStr2(haystack, needle));
    }
}
