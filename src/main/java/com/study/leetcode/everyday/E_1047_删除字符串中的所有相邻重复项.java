package com.study.leetcode.everyday;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/9 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1047_删除字符串中的所有相邻重复项 {

    public static String removeDuplicates(String s) {
        int preIndex = 0, curIndex = 1;
        while (curIndex < s.length()) {
            char pre = s.charAt(preIndex);
            char cur = s.charAt(curIndex);
            if (pre != cur) {
                preIndex++;
                curIndex++;
            } else {
                s = s.replaceFirst("" + pre + cur, "");
                preIndex = 0;
                curIndex = 1;
            }
        }

        return s;
    }

    public static String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        // -1表示当前sb中没有字符
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            // 如果top >= 0 表示当前sb中有字符
            if (top >= 0 && s.charAt(i) == sb.charAt(top))
                    sb.deleteCharAt(top--);
            else {
                sb.append(s.charAt(i));
                top++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
//        String s = "abbaabccaaa";
//        String s = "a";
//        String s = "";
        System.out.println(removeDuplicates2(s));
    }
}
