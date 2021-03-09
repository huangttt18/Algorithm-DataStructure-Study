package com.study.leetcode.strings;

/**
 * 1446. 连续字符
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/9 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1446_连续字符 {

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public static int maxPower(String s) {
        int maxPower = 1;
        int pre = 0;
        int cur = 1;
        while (cur < s.length()) {
            char preChar = s.charAt(pre);
            char curChar = s.charAt(cur);
            if (preChar == curChar) {
                maxPower = Math.max(cur - pre + 1, maxPower);
                cur++;
            } else {
                pre = cur;
                cur++;
            }
        }

        return maxPower;
    }

    public static void main(String[] args) {
//        String s = "leetcode";
//        String s = "abbcccddddeeeeedcba";
//        String s = "triplepillooooow";
//        String s = "hooraaaaaaaaaaay";
//        String s = "tourist";
        String s = "ccbccbb";
        System.out.println(maxPower(s));
    }
}
