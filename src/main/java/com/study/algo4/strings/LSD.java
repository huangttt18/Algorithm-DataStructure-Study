package com.study.algo4.strings;

import java.util.Arrays;

/**
 * 低位优先字符串排序: 适用于定长字符串的排序，该排序是稳定的排序算法
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/17 </a>
 * @since <span>1.0</span>
 */
public class LSD {

    public static void sort(String[] a, int w) {
        int length = a.length;
        int base = 256;
        String[] aux = new String[length];

        // 根据字符串的长度来决定遍历的次数，每一次从字符串的末位来执行键索引计数
        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[base + 1];
            // 统计字符串在当前索引位置d的字符的频率，也就是当前字符出现的次数
            for (int i = 0; i < length; i++)
                count[a[i].charAt(d) + 1]++;

            // 计算每一个字符应该位于的索引位置
            // 如果字符重复，那么索引值会累加
            // 比如对于字符0, 0, 1 ,2
            // 那么它们对应的索引起始位置应该是0 -> 2, 1 -> 1, 2 -> 1
            for (int r = 0; r < base; r++)
                count[r + 1] += count[r];

            // 移动字符串到对应的索引位置
            // 比如对于字符0, 0, 1, 2
            // 通过获取字符在count中的索引值即count[ch] 来获取到当前字符对应的字符串应该存放在aux数组中的位置
            // 每次存放一个字符串到aux数组后，count[ch]++，意思是如果当前字符有多个重复的，那么下一个同样的字符的字符串会在当前位置的下一个位置
            for (int i = 0; i < length; i++) {
                int curIndex = count[a[i].charAt(d)];
                aux[curIndex] = a[i];
                count[a[i].charAt(d)]++;
            }

            // 将aux数组中的元素拷贝到a数组中即可
            for (int i = 0; i < length; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {
                "2RLA629",
                "1ICK750",
                "3ATW723",
                "2IYE230",
                "4PGC938",
                "1OHV845",
                "3CIO720",
                "2RLA629"
        };
        sort(a, 7);
        Arrays.stream(a).forEach(System.out::println);
    }
}
