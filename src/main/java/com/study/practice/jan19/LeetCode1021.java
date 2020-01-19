package com.study.practice.jan19;

/**
 * 删除最外层的括号
 *
 * @author Daniel 2020/1/19
 */
public class LeetCode1021 {

    public static final String LEFT_QUOTE = "(";
    public static final String RIGHT_QUOTE = ")";

    public static String removeOuterParentheses(String S) {
        int num = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            // 左括号，num++
            if (S.charAt(i) == '(') {
                num++;
            }

            // 右括号，表示匹配到了，num--
            if (S.charAt(i) == ')') {
                num--;
            }


            if (num == 1 && S.charAt(i) == '(') {
                index = i;
            }

            if (num == 0) {
                sb.append(S, index + 1, i);
            }
        }

        return sb.toString();
    }

    public static String remove(String S) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    /**
     * int level = 0;
     * for (char c : S.toCharArray()) {
     * if (c == ')') --level;
     * if (level >= 1) sb.append(c);
     * if (c == '(') ++level;
     * }
     * ( 1
     * ( 2 sb.append
     * ) 1 sb.append
     * ( 2 sb.append
     * ) 1 sb.append
     * ) 0
     * ( 1
     * ( 2 sb.append
     * ) 1 sb.append
     * ) 0
     */
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
}
