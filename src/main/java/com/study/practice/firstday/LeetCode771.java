package com.study.practice.firstday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Created by Daniel
 */
public class LeetCode771 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("wasd", "WASDwasdwasdwasdwasdwasdwasdwasdwasdwdasdwadasdawdasdawdasdawdasdasdawdasdregrg34g34g3g34g34g43"));
        System.out.println(numJewelsInStones1("wasd", "WASDwasdwasdwasdwasdwasdwasdwasdwasdwdasdwadasdawdasdawdasdawdasdasdawdasdregrg34g34g3g34g34g43"));
    }

    public static int numJewelsInStones(String J, String S) {
        long start = System.nanoTime();
        int count = 0;
        for (int i = 0;i < J.length();i ++) {
            char ch = J.charAt(i);
            for (int j = 0;j < S.length();j ++) {
                if (S.charAt(j) == ch) {
                    count ++;
                }
            }
        }
        System.out.println("Cost: " + (System.nanoTime() - start));
        return count;
    }

    public static int numJewelsInStones1(String J, String S) {
        long start = System.nanoTime();
        int count = 0;
        Map<Character, Integer> map = new HashMap(J.length());
        for (int i = 0;i < J.length();i ++) {
            char ch = J.charAt(i);
            map.put(ch, 0);
        }

        for (int i = 0;i < S.length();i ++) {
            char ch = S.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }

        for (char ch : map.keySet()) {
            count += map.get(ch);
        }
        System.out.println("Cost: " + (System.nanoTime() - start));
        return count;
    }
}
