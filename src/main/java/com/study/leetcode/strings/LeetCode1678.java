package com.study.leetcode.strings;

/**
 * 1678. 设计 Goal 解析器
 * <p>
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * <p>
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goal-parser-interpretation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/27 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class LeetCode1678 {

    public static String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < command.length();) {
            if (command.charAt(i) == 'G') {
                ans.append('G');
                i++;
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    ans.append("o");
                    i += 2;
                } else if (command.charAt(i + 1) == 'a') {
                    ans.append("al");
                    i += 4;
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String command = "G()()()()(al)";
        System.out.println(interpret(command));
        command = "G()(al)";
        System.out.println(interpret(command));
        command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }
}
