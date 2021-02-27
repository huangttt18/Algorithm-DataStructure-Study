package com.study.leetcode.strings;

import java.util.Arrays;
import java.util.List;

/**
 * 1119. 删去字符串中的元音
 * 
 * 给你一个字符串S，请你删去其中的所有元音字母（'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 *
 * 示例 1：
 *
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 *
 * 输入："aeiou"
 * 输出：""
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-vowels-from-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/27 </a>
 * @since <span>1.0</span>
 */
public class LeetCode1119 {

    public static String removeVowels(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i)))
                ans.append(s.charAt(i));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        String ans = removeVowels(s);
        System.out.println(ans);
        System.out.println("ltcdscmmntyfrcdrs".equals(ans));
    }
}
