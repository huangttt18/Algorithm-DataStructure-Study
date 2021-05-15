package com.study.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 1832. 判断句子是否为全字母句
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/30 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1832_判断句子是否为全字母句 {

    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }

    public static boolean checkIfPangram2(String sentence) {
        int i = 0x3FFFFFF;
        for (char c : sentence.toCharArray()) {
            // 将第c - 'a'位置为0
            i &= ~(1 << c - 'a');
        }
        return i == 0;
    }

    public static boolean checkIfPangram3(String sentence) {
        int i = 0x3FFFFFF;
        for (char c : sentence.toCharArray()) {
            // 将第c - 'a'位置为0
            i &= ~(1 << c - 'a');
            if (i == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram2("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram2("leetcode"));
    }
}
