package com.study.practice.jan.jan17;

/**
 * 分割平衡字符串
 *
 * @author Daniel 2020/1/17
 */
public class LeetCode1211 {

    public static int balancedStringSplit(String s) {
        int total = 0;
        int flag = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                flag++;
            } else {
                flag--;
            }

            if (flag == 0) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "LLLLRRRR";
        System.out.println(balancedStringSplit(s));
    }
}
