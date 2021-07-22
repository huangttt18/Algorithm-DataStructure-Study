package com.study.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 726. 原子的数量
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/5</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_726_原子的数量 {

    static Pattern p = Pattern.compile("[A-Z]{1}[a-z]*[2-9]*");

    public static String countOfAtoms(String formula) {
        Matcher m = p.matcher(formula);
        Map<String, Integer> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        StringBuilder num = new StringBuilder();
        while (m.find()) {
            char[] find = m.group().toCharArray();
            for (int i = 0; i < find.length; i++) {
                if (Character.isDigit(find[i])) {
                    num.append(find[i]);
                } else {
                    s.append(find[i]);
                }
            }
            map.put(s.toString(), num.length() == 0 ? 0 : Integer.parseInt(num.toString()));
            s.delete(0, s.length());
            num.delete(0, num.length());
        }

        List<String> sorted = map.keySet().stream().sorted((k1, k2) -> {
            return k1.compareTo(k2);
        }).collect(Collectors.toList());

        for (String str : sorted) {
            s.append(str).append(map.get(str));
        }

        return s.toString();
    }

    public static String countOfAtoms2(String formula) {
        StringBuilder s = new StringBuilder();

        return s.toString();
    }

    static String help(String formula) {
        Stack<Character> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        char[] array = formula.toCharArray();
        StringBuilder s = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        StringBuilder num = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < array.length;) {
            char c = array[i];
            // 如果是(，就放入栈中
            // 如果是)
            // 先读出)后的数字，再将[(,))出栈，并且每个原子都乘以数字
            // 然后继续往后读
            if (c == '(') {
                i++;
                flag = true;
                stack.push(c);
            } else if (c == ')') {
                i++;
                flag = false;
                int j = i;
                // 读出数字
                while (j < array.length && Character.isDigit(array[j])) {
                    num.append(array[j]);
                }
                int n = Integer.parseInt(num.toString());
                // 从stack中pop原子，并且给
                while (stack.peek() != '(') {
                    tmp.append(stack.pop());
                }
                Matcher matcher = p.matcher(tmp.toString());
                while (matcher.find()) {
                    String find = matcher.group();
                    map.put(find, map.getOrDefault(find, 0) * n);
                }
                // 把(pop出来
                stack.pop();
                // 维护i
                i = j + 1;
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String formula = "H2MgO2";
        System.out.println(countOfAtoms(formula));;
    }

}
