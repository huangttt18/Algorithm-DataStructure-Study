package com.study.leetcode.everyday;

/**
 * 168. Excel表列名称
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/29</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_168_Excel表列名称 {

    /**
     * 260 ->
     * A B C D E
     * F G H I J
     * K L M N O
     * P Q R S T
     * U V W X Y
     * Z
     *
     * 260 % 26 = 0
     * 2600 % 26 = 0
     * 2600 / 26 = 100 => Z
     * 99 % 26 = 3...21
     * CUZ
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber != 0) {
            int remainder = columnNumber % 26;
            if (remainder == 0) {
                ans.append('Z');
                columnNumber = columnNumber / 26 - 1;
            } else {
                ans.append((char) ('A' + remainder - 1));
                columnNumber /= 26;
            }
        }
        return ans.reverse().toString();
    }

    public static String convertToTitle2(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            ans.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle2(2147483647));
    }
}
