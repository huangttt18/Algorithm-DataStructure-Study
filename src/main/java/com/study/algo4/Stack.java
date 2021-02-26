package com.study.algo4;

import java.util.Scanner;

/**
 * 链表实现栈
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class Stack<T> {

    private int size;
    private Node<T> dummyHead;
    private Node<T> top;

    public Stack() {
        this.dummyHead = new Node<T>(null);
    }

    private class Node<T> {
        T val;
        Node<T> next;

        Node(T val) {
            this.val = val;
        }
    }

    public void push(T val) {
        Node<T> oldTop = top;
        top = new Node<>(val);
        top.next = oldTop;
        size++;
        dummyHead.next = top;
    }

    public T pop() {
        T ret = top.val;
        top = top.next;
        size--;
        dummyHead.next = top;
        return ret;
    }

    public T peek() {
        return top.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void traverse() {
        Node<T> traverseHead = dummyHead.next;
        while (traverseHead != null) {
            System.out.print(traverseHead.val);
            System.out.print(" -> ");
            traverseHead = traverseHead.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.traverse();
        stack.pop();
        stack.traverse();

        System.out.println(parentheses());
//        System.out.println(parentheses("()()((())}"));
    }

    public static boolean parentheses() {
        Scanner scanner = new Scanner(System.in);
        boolean res = true;
        Stack<String> stack = new Stack<>();
        while (true) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("quit")
                    || next.equalsIgnoreCase("exit")
                    || next.equalsIgnoreCase("q"))
                break;
            if (next.equals("{") || next.equals("(") || next.equals("["))
                stack.push(next);
            else if (!stack.isEmpty()) {
                if (next.equals("}")) {
                    String pop = stack.pop();
                    if (!pop.equals("{")) {
                        res = false;
                        break;
                    }
                } else if (next.equals(")")) {
                    String pop = stack.pop();
                    if (!pop.equals("(")) {
                        res = false;
                        break;
                    }
                } else if (next.equals("]")) {
                    String pop = stack.pop();
                    if (!pop.equals("[")) {
                        res = false;
                        break;
                    }
                }
            } else if (stack.isEmpty()) {
                res = false;
                break;
            }
        }

        if (!stack.isEmpty())
            return false;
        return res;
    }

    public static boolean parentheses(String s) {
        if (s == null || s.length() == 0)
            return true;
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch;
            if ((ch = s.charAt(i)) == '{' || ch == '(' || ch == '[')
                stack.push(ch);
            else if (!stack.isEmpty()) {
                if (ch == '}') {
                    char pop = stack.pop();
                    if (!(pop == '{')) {
                        res = false;
                        break;
                    }
                } else if (ch == ')') {
                    char pop = stack.pop();
                    if (!(pop == '(')) {
                        res = false;
                        break;
                    }
                } else if (ch == ']') {
                    char pop = stack.pop();
                    if (!(pop == '[')) {
                        res = false;
                        break;
                    }
                }
            } else if (stack.isEmpty()) {
                res = false;
                break;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return res;
    }
}
