package com.study.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1006. 笨阶乘
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1006_笨阶乘 {

    public static int clumsy(int N) {
        int ans = 0;
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N);
        int res = 0;
        for (int i = N - 1; i > 0; i--) {
            // 判断符号
            // 如果当前符号为 *
            // res = stack.pop() * i
            // stack.push(res)
            // 如果当前符号为 /
            // res = stack.pop() / i
            // stack.push(res)
            // 如果当前符号为 +
            // stack.push(i)
            // 如果当前符号为 -
            // stack.push(-i)
            // while (!stack.isEmpty()) ans += stack.pop()
            int op = index++ % 4;
            switch (op) {
                case 0: // *
                    if (!stack.isEmpty()) {
                        res = stack.pop() * i;
                        stack.push(res);
                    } else
                        stack.push(i);
                    break;
                case 1: // /
                    if (!stack.isEmpty()) {
                        res = stack.pop() / i;
                        stack.push(res);
                    } else
                        stack.push(i);
                    break;
                case 2: // +
                    stack.push(i);
                    break;
                case 3: // -
                    stack.push(-i);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static int clumsy2(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(clumsy(4));
    }
}
