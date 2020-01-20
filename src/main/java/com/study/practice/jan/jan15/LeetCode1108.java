package com.study.practice.jan.jan15;

/**
 * IP 地址无效化
 *
 * @author Daniel 2020/1/15
 */
public class LeetCode1108 {

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = address.toCharArray();
        for (char ch : charArray) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String address = "192.168.0.128";
        System.out.println(defangIPaddr(address));
    }
}
