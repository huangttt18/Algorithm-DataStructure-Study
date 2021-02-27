package com.study.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 1684. 统计一致字符串的数目
 * <p>
 * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回words数组中一致字符串 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class LeetCode1684 {

    public static int countConsistentStrings(String allowed, String[] words) {
        List<Character> characters = new ArrayList<>(allowed.length());
        for (char c : allowed.toCharArray()) {
            characters.add(c);
        }

        int count = 0;
        boolean flag = false;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++)
                if (!characters.contains(words[i].charAt(j))) {
                    flag = true;
                    break;
                }
            if (flag) {
                count++;
                flag = false;
            }
        }

        return words.length - count;
    }

    /**
     * 由条件可知，allowed字符串中所有的字符都不重复，那么也就是allowed最多只有26位
     * 因此可以将allowed以二进制int的方式来表示，比如对于allowed = "ab"，则其对应的二进制int为00 0000 0000 0000 0000 0000 0011
     * 那么对于words中的字符串也可以这样转换
     * 转换后将bin(words[i])和bin(allowed)进行位与(&)操作，如果结果等于bin(words[i])，则表示words[i]中的字符都存在于allowed中
     * 否则表示words[i]中有不存在于allowed中的字符
     *
     * 比如bin(words[i]) = 00 0000 0000 0000 0000 0000 0111，即words[i] = "abc"
     * 那么此时bin(words[i]) & bin(allowed)的结果为
     * 00 0000 0000 0000 0000 0000 0011
     *
     * @param allowed
     * @param words
     * @return
     */
    public static int countConsistentStrings2(String allowed, String[] words) {
        int ans = 0;
        int solve = solve(allowed);
        for (String word : words) {
            int res = solve(word);
            if ((solve & res) == res)
                ans++;
//            if ((solve & res) == solve)
//                break;
//            ans++;
        }
        return ans;
    }

    public static int solve(String s) {
        int res = 0;
        for (char c : s.toCharArray())
            res |= (1 << (c - 'a'));

        return res;
    }

    public static int countConsistentStrings3(String allowed, String[] words) {
        int[] arr = new int[26];
        // 将allowed中的所有字符存入一个长度为26的int数组中
        // 该数组的index位置的元素如果等于1则表示allowed字符串中存在(index + 'a')字符
        for (char c : allowed.toCharArray()) {
            arr[c - 'a'] = 1;
        }

        int ans = 0;

        for (String word : words) {
            int i;
            for (i = 0; i < word.length(); i++) {
                // 判断word字符串中的每一个字符在allowed字符串对应数组中的对应位置的值是否为0
                // 如果为0，表示word中有不存在于allowed字符串中的字符
                if (arr[word.charAt(i) - 'a'] == 0)
                    break;
            }
            // 检查i和word字符串的长度是否相等，如果相等，表示当前word被遍历完，并且没有发现不存在于allowed字符串中的字符
            if (i == word.length())
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(countConsistentStrings(allowed, words));
        System.out.println(countConsistentStrings2(allowed, words));
        System.out.println(countConsistentStrings3(allowed, words));
    }
}
