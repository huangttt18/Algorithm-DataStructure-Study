package com.study.practice;

/**
 * LeetCode#125：回文字符串 - 只考虑数字和字母
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2020/11/16 </a>
 * @since <span>1.0</span>
 */
public class LeetCode125 {

    public static boolean isPalindrome(String sentence) {

        // 过滤掉所有的非数字和字母
        String filteredString = filterNumberAndCharacter(sentence);

        // 反转字符串并与之前的字符串进行对比，如果相等则返回true
        return filteredString.equalsIgnoreCase(reversedString(filteredString));
    }

    private static String reversedString(String filteredString) {
        StringBuilder sb = new StringBuilder();
        char[] filteredCharArray = filteredString.toCharArray();
        for (int i = filteredCharArray.length - 1; i >= 0; i--) {
            sb.append(filteredCharArray[i]);
        }
        return sb.toString();
    }

    private static String filterNumberAndCharacter(String sentence) {
        StringBuilder sb = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String toBeChecked = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(toBeChecked));
    }
}
