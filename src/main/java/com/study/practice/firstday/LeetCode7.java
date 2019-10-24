package com.study.practice.firstday;

/**
 * @author Daniel 2019/10/24
 *
 */
public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        String string = "";
        if(x < 0) {
            string = "-";
            string +=  sb.reverse().substring(0, sb.length() - 1);
            if(Long.parseLong(string) < Integer.MIN_VALUE) {
                return 0;
            }
        }else {
            string +=  sb.reverse().substring(0, sb.length());
            if(Long.parseLong(string) > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return Integer.parseInt(string);
    }

    public static int reverse1(int x) {
        // 对整数进行整除+取余操作取得每一位的数字
        // 接着用字符串拼接
        // 然后Integer.parseInt()
        // 最后与Integer.MAX_VALUE 、Integer.MIN_VALUE进行比较大小
        // 如果溢出，则return 0
        // 否则return result
        StringBuilder result = new StringBuilder();
        if (x < 0) {
            result.append('-');
            x = Math.abs(x);
        }
        while(x != 0) {
            result.append(x % 10);
            x = x / 10;
        }
        if (Long.parseLong(result.toString()) < Integer.MIN_VALUE || Long.parseLong(result.toString()) > Integer.MAX_VALUE) {
            return 0;
        }
        return Integer.parseInt(result.toString());
    }
}
