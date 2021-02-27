package com.study.leetcode.strings;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class Offer58 {

    public static String reverseLeftWords(String s, int k) {
        char[] array = s.toCharArray();
        while (k-- > 0) {
            char ch = array[0];
            for (int i = 1; i < array.length; i++) {
                array[i - 1] = array[i];
            }
            array[array.length - 1] = ch;
        }

        return new String(array);
    }

    /**
     * 将字符串分割为[0...n)和[n...s.length)然后拼接
     * @param s
     * @param k
     * @return
     */
    public static String reverseLeftWords2(String s, int k) {
        String endStr = s.substring(0, k);
        String startStr = s.substring(k);
        return startStr + endStr;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = "lrloseumgh";
        System.out.println(reverseLeftWords(s, 2));
        System.out.println(reverseLeftWords2(s, 2));
    }
}
