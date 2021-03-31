package com.study.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/31 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_17_电话号码的字母组合 {

    static List<String> ans;

    static String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        findCombinations(digits, 0, "");
        return ans;
    }

    private static void findCombinations(String digits, int start, String curString) {
        if (start == digits.length()) {
            ans.add(curString);
            return;
        }

        String letters = letterMap[digits.charAt(start) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, start + 1, curString + letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
