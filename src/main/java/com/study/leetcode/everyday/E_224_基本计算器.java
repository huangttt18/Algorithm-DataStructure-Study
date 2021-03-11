package com.study.leetcode.everyday;

import com.study.algo4.ds.Stack;

/**
 * 224. 基本计算器
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/10 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_224_基本计算器 {

    /**
     * 使用栈保存当前符号位，通过{1, -1}来表示正负号
     * 当遍历到' '时，跳过即可
     * 当遍历到'+'时，当前符号sign = stack.peek()
     * 当遍历到'-'时，当前符号sign = -stack.peek()
     * 当遍历到'('时，表示遇到了括号，那么括号内的符号都需要被反转，因此将当前sign压栈
     * 当遍历到')'时，表示括号结束，当前sign出栈
     * 当遍历到数字时，求当前字符到下一个为'+'、'-'、'('、')'、' '之前的所有数字符号所表示的数字值，比如对于字符345，如何求该字符串的数值
     *      while (index < length && Character.isDigit(s.charAt(index))) {
     *          数值num = num * 10 + s.charAt(index) - '0';
     *          index ++;
     *      }
     *  当下一个字符不是数字时，将当前num值加到结果res中，注意需要带上当前值的符号sign => res += num * sign
     *
     * - (3 + (4 + 5))
     * stack = [1]
     * ans = 0;
     * 1. s.charAt() == '-' => sign = -stack.peek() = -1 => stack = [1]
     * 2. s.charAt() == '(' => stack.push(sign) => stack = [1, -1]
     * 3. s.charAt() == '3' => ans += sign * 3 = 3 * -1 + 0 = -3
     * 4. s.charAt() == '+' => sign = stack.peek() = -1 => stack = [1, -1]
     * 5. s.charAt() == '(' => stack.push(sign) => stack = [1, -1, -1]
     * 6. s.charAt() == '+' => sign = stack.peek() = -1 => stack = [1, -1, -1]
     * 7. s.charAt() == '4' => ans += sign * 4 = -3 + (-1) * 4 = -7 => stack = [1, -1, -1]
     * 8. s.charAt() == '+' => sign = stack.peek() = -1 => stack = [1, -1, -1]
     * 9. s.charAt() == '5' => ans += sign * 5 = -7 + (-1) * 5 = -12 => stack = [1, -1, -1]
     * 10. s.charAt() == ')' => stack.pop() => stack = [1, -1]
     * 11. s.charAt() == ')' => stack.pop() => stack = [1]
     * 遍历结束
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<Integer> operatorStack = new Stack<>();
        int sign = 1;
        operatorStack.push(sign);

        int ans = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }

            if (s.charAt(index) == '+') {
                sign = operatorStack.peek();
                index++;
            } else if (s.charAt(index) == '-') {
                sign = -operatorStack.peek();
                index++;
            } else if (s.charAt(index) == '(') {
                operatorStack.push(sign);
                index++;
            } else if (s.charAt(index) == ')') {
                operatorStack.pop();
                index++;
            } else {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                ans += num * sign;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "+1";
//        String s = "(1)+(1)";
//        String s = "- (3 + (4 + 5))";
//        String s = "1";
//        String s = "1 + 1";
//        String s = " 2-1 + 2 ";
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
