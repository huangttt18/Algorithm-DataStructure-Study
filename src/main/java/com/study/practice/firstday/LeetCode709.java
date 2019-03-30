package com.study.practice.firstday;

/**
 * @Author Created by Daniel
 */
public class LeetCode709 {

    public static void main(String[] args) {
        System.out.println(toLowerCase("4g3hGGG"));
    }

    public static String toLowerCase(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0;i < str.length();i ++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            } else {
                chars[i] = ch;
            }
        }
        return String.valueOf(chars);
    }
}
