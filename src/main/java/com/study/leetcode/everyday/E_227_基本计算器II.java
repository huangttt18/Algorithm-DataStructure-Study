package com.study.leetcode.everyday;

import com.study.algo4.ds.Stack;

/**
 * 227. 基本计算器 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/11 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_227_基本计算器II {

    /**
     * 双栈解法：一个栈保存当前数字*sign(默认为1)，一个栈保存'*'和'-'
     * 当遇到'+' '-'时，只需要改变sign即可，
     *      当'+'时，sign = sign，
     *      当'-'时，sign = -sign
     * 当遇到'*'时，opStack.push('*')
     * 当遇到'/'时，opStack.push('/')
     * 当遇到数字时，
     *      首先通过公式 num = num * 10 + num求得当前的数字的实际值
     *      接着检查opStack中是否有元素
     *          如果有元素，则将numStack中的元素pop出来，与当前元素相乘或者相除(根据opStack.pop()来判断相乘还是相除)。【注意使用完符号需要重置符号为正】
     *      求值完毕之后，将当前值push到numStack
     * 最后将numStack中的元素pop出来并求和即可得到结果ans
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        // 符号位
        int sign = 1;
        int index = 0;
        int ans = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }

            if (s.charAt(index) == '+') {
                sign = sign;
                index++;
            } else if (s.charAt(index) == '-') {
                sign = -sign;
                index++;
            } else if (s.charAt(index) == '*') {
                opStack.push('*');
                index++;
            } else if (s.charAt(index) == '/') {
                opStack.push('/');
                index++;
            } else {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }

                if (!opStack.isEmpty()) {
                    char op = opStack.pop();
                    if (op == '*') {
                        num = num * numStack.pop();
                    } else if (op == '/') {
                        num = numStack.pop() / num;
                    }
                }

                numStack.push(num * sign);
                sign = 1;
            }
        }

        while (!numStack.isEmpty()) {
            ans += numStack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = " 3/2 ";
        String s1 = " 3+5 / 2 ";
        String s2 = "3+2*2";
        String s3 = "+1-2*+3/-4";
        String s4 = "--2++1*-3/+-4";
        String s5 = "-52";
        String s6 = "42";
        String s7 = "--42";
        String s8 = "1-1";
        String s9 = "-1-1";
        String s10 = "2-+3";
        System.out.println(calculate(s2));
        System.out.println(calculate(s));
        System.out.println(calculate(s1));
        System.out.println(calculate(s3));
        System.out.println(calculate(s4));
        System.out.println(calculate(s5));
        System.out.println(calculate(s6));
        System.out.println(calculate(s7));
        System.out.println(calculate(s8));
        System.out.println(calculate(s9));
        System.out.println(calculate(s10));
//        System.out.println(+1-2*+3/-4);
//        System.out.println(-(-2)+(+1)*-3/+(-4));
    }
}
