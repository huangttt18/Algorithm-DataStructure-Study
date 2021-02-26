package com.study.leetcode.sort;

/**
 * 1528. 重新排列字符串
 * <p>
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * <p>
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * <p>
 * 返回重新排列后的字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
public class LeetCode1528 {

    public static String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];
        int c = 0;
        for (int index : indices) {
            // 将ans在index位置上的元素替换为s在index位置上的元素
            ans[index] = s.charAt(c++);
        }

        return new String(ans);
    }

    public static void main(String[] args) {
//        String s = "codeleet";
//        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String s = "aaiougrt";
        int[] indices = {4,0,2,6,7,3,1,5};
        System.out.println(restoreString(s, indices));
    }
}
