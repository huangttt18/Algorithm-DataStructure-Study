package com.study.practice.jan19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6 和 9 组成的最大数字
 *
 * @author Daniel 2020/1/19
 */
public class LeetCode5135 {

    public static int maximum69Number (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public static int maximum69Number2 (int num) {
        String s = String.valueOf(num);
        char[] charArray = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int replaceIndex = 0;
        while (replaceIndex <= s.lastIndexOf('6')) {
            int replaceTime = 1;
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (ch == '6' && replaceTime != 0) {
                    if (i == 0) {
                        charArray[i] = '9';
                        replaceTime --;
                    } else {
                        charArray[replaceIndex] = '9';
                        replaceTime--;
                    }
                }
                replaceIndex++;
                sb.append(charArray[i]);
            }
            replaceIndex = 0;
            list.add(Integer.parseInt(sb.toString()));
        }

        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static int maximum69Number3 (int num) {
        String s = String.valueOf(num);
        char[] charArray = s.toCharArray();
        if (charArray[0] == '6') {
            charArray[0] = '9';
            return Integer.parseInt(new String(charArray));
        }

        // 边界
        if (!s.contains("6")) {
            return num;
        }

        int lastReplaceIndex = 0;
        List<Integer> numberList = new ArrayList<>();
        while (lastReplaceIndex != s.lastIndexOf('6')) {
            int replaceTime = 1;
            char[] temp = Arrays.copyOf(charArray, charArray.length);
            for (int i = 1; i < temp.length; i++) {
                if (i > lastReplaceIndex && temp[i] == '6' && replaceTime == 1) {
                    replaceTime--;
                    lastReplaceIndex = i;
                    temp[i] = '9';
                }
            }
            numberList.add(Integer.parseInt(new String(temp)));
        }

        int max = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            if (numberList.get(i) > max) {
                max = numberList.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number3(9999));
    }
}
