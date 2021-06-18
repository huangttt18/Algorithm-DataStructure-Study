package com.study.leetcode.everyday;

/**
 * 65. 有效数字
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/6/17</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_65_有效数字 {

    /**
     * 如果存在e/E，那么E的左侧为小数或者整数，E的右侧必须为整数
     * 如果不存在e/E，那么数字为整数或者小数
     *
     * (1)E的左侧：
     *      a. 符号只能出现在第一个位置
     *      b. dot只能出现一次
     * (2)E的右侧：
     *      a. 符号只能出现在第一个位置
     *      b. 只能是整数，即出现了dot，那么不是有效数字
     */
    public static boolean isNumber(String s) {
        int len = s.length();
        int eIndex = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'E' || s.charAt(i) == 'e') {
                if (eIndex != -1)
                    // 此时表示有2个e/E
                    return false;
                // 记录下e/E的索引值
                eIndex = i;
            }
        }

        boolean ans = true;
        if (eIndex != -1) {
            // 有e，那么分别判断e的左右两侧是否符合条件
            // 左侧
            ans &= check(s, 0, eIndex - 1, false);
            // 右侧
            ans &= check(s, eIndex + 1, len - 1, true);
        } else {
            // 没有e，判断是否符合小数或者整数的定义
            ans &= check(s,0, len - 1, false);
        }

        return ans;
    }

    static boolean check(String s, int start, int end, boolean mustInteger) {
        if (start > end)
            return false;
        boolean dot = false, num = false;
        // 跳过符号位，因为符号位必须在首位并且只有一位
        if (s.charAt(start) == '+' || s.charAt(start) == '-')
            start++;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '.') {
                // 当前位置的字符为dot
                if (mustInteger || dot)
                    // 如果必须为数字，也就是在e的右侧，那么返回false
                    // 如果已经存在了一个dot，那么不能存在另外的dot，返回false
                    return false;
                // 记录dot存在
                dot = true;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                // 如果是数字
                num = true;
            else
                // 如果是其他字符，直接返回false，check函数中的字符只能包含[0-9,dot]
                return false;
        }
        return num;
    }

    public static void main(String[] args) {

    }

}
