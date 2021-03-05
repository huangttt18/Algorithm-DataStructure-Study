package com.study.leetcode.everyday;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * 感觉实际上是考api运用。。。。。。
 *
 * 用栈实现队列，需要保证pop从栈底出来，peek从中栈底出来
 * <p>
 * 栈：LIFO
 * 队列：FIFO
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/5 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_232_用栈实现队列 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }

    static class MyQueue {

        Stack<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.addElement(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            // firstElement返回stack中数组的第一个元素
            // stack继承自vector，底层实现为数组
            // 当push一个元素到stack中时，实际上是放在vector中的数组的当前index位置，接着index往后推即可
            int ret = stack.firstElement();
            // indexOf返回vector数组中的第一个ret所在的位置
            // 例如对于stack = [1, 1, 2, 3, 4, 5]，调用indexOf(1)返回索引位置0
            stack.remove(stack.indexOf(ret));
            return ret;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.firstElement();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
