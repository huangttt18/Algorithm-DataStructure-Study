package com.study.leetcode.sort;

/**
 * 1370. 上升下降字符串
 * 
 * 给你一个字符串s，请你根据下面的算法重新构造字符串：
 *
 * 从 s中选出 最小的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s中选择字符。
 * 从 s中选出 最大的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
 * 重复步骤 5，直到你没法从 s中选择字符。
 * 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将s中字符重新排序后的 结果字符串 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
public class LeetCode1370 {

    public static String sortString(String s) {
        if (s == null || s.length() == 0)
            return null;
        // 从题意可知，字符为a - z
        // 因此可以遍历字符串，并将每一个字符的数量存放到一个长度为26的桶数组的对应索引(字符 - 'a')的位置上
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        // 当res长度小于原字符串长度时
        while (res.length() < s.length()) {
            // 从前往后(挑选最小的且比上次添加的字符大的字符)遍历并将当前位置不等于0的字符拼接到res字符串尾部
            for (int i = 0; i < 26; i++) {
                if (bucket[i]-- > 0) {
                    res.append((char) (i + 'a'));
                    // 每次添加完之后将当前桶数组对应的位置的值减一
                }
            }

            // 从后往前(挑选最大的且比上次添加的字符小的字符)遍历并将当前位置不等于0的字符拼接到res字符串尾部
            for (int i = 25; i >= 0; i--) {
                // bucket[i]-- > 0
                // 当该条件满足时，该字符会被添加到res中
                if (bucket[i]-- > 0) {
                    res.append((char) (i + 'a'));
                    // 每次添加完之后将当前桶数组对应的位置的值减一
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortString("spo"));
    }
}
