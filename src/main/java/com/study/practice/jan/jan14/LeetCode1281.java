package com.study.practice.jan.jan14;

/**
 * 整数的各位积和之差
 *
 * @author Daniel 2020/1/14
 */
public class LeetCode1281 {

    public static int subtractProductAndSum(int n) {
        return plusOfNum(n) - sumOfNum(n);
    }

    /**
     * 各位数之和
     */
    public static int sumOfNum(int num) {
        int sum = 0;
        while (true) {
            sum += num % 10;
            if (num / 10 == 0) {
                break;
            }
            num /= 10;
        }
        return sum;
    }

    /**
     * 各位数只积
     */
    public static int plusOfNum(int num) {
        int plus = 1;
        while (true) {
            int remainder = num % 10;
            plus *= remainder;
            if (num / 10 == 0) {
                break;
            }
            num /= 10;
        }
        return plus;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));;
    }
}
